package com.menuprime.services;

import com.menuprime.model.Dynamic_Query_Model;
import com.menuprime.model.File_structure;
import com.menuprime.model.Menuprime_locations;
import com.menuprime.repository.File_structure_Repository;
import com.menuprime.repository.Generate_File_Repository;
import com.menuprime.repository.Menuprime_locations_Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate_File_Service permite la generación de un archivo CSV con la información que recupera Generate_File_Repository.callFunction
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Service
public class Generate_File_Service  {

    private List<String> headers;
    private List<String> propiedades;

    private String toDate;

    private String fromDate;
    @Autowired
    private Generate_File_Repository generate_File_Repository;

    @Autowired
    private Menuprime_locations_Repository menuprime_locations_Repository;

    @Autowired
    private File_structure_Repository file_structure_Repository;

    /**
     * Escribe el archivo CSV detallando por cada sede de MenuPrime la información de los domicilios realizados por la empresa indicada
     * y que corresponde a su vez a un mes, año y frecuencia especifica.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param selectedCompanyName Nombre de la Delivery_company.
     * @param selectedCompanyId Id de la Delivery_company.
     * @param month Mes al cual corresponde la información
     * @param year Año al cual corresponde la información
     * @param frequency Frecuencia para mostrar la información, puede ser Mensual, Quincenal o Semanal
     * @param writer Writer
     * @return ICsvBeanWriter
     */
    @Transactional
    public ICsvBeanWriter getCsv(String selectedCompanyName,int selectedCompanyId, String month,
                                  String year, String frequency, Writer writer) throws IOException {

        int counter = 1;

        DefineDates(frequency, year, month);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);

        List<Menuprime_locations> sedes = menuprime_locations_Repository.findAll();

        csvWriter.writeComment("/* Archivo correspondiente a los domicilios realizados por " + selectedCompanyName + ", desde " +
                                fromDate + " hasta " + toDate + " */");

        csvWriter.writeComment("");

        for (Menuprime_locations sede : sedes) {

            csvWriter.writeComment("/******** Sede Número: "+ counter + " ********/");

            List<Dynamic_Query_Model> datos = generate_File_Repository.callFunction(selectedCompanyId, sede.getMenuprime_location_id(), fromDate, toDate);

            List<File_structure> file_structures = file_structure_Repository.findAllByLocationAndCompany(sede.getMenuprime_location_id(), selectedCompanyId);

            BuildHeadersAndPropiedades(file_structures);

            String [] headersArray = new String[this.headers.size()];
            headersArray = this.headers.toArray(headersArray);

            String [] propiedadesArray = new String[this.propiedades.size()];
            propiedadesArray = this.propiedades.toArray(propiedadesArray);

            csvWriter.writeHeader(headersArray);


            for (Dynamic_Query_Model data : datos) {
                csvWriter.write(data, propiedadesArray);
            }

            counter += 1;
            csvWriter.writeComment("");

        }
        return csvWriter;
    }

    /**
     * Modifica los headers y las propiedades que se escriben en el archivo CSV, esto es agregando aquella información
     * adicional que el usurio final desea y que se encuentra previamente definida en la entidad File_structure
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param file_structures Lista de File_structure con los campos adicionales requeridos
     */
    private void BuildHeadersAndPropiedades(List<File_structure> file_structures){

        //Campos base obligatorios
        this.headers = new ArrayList<String> (Arrays.asList("NOMBRE_SEDE", "DIRECCIÓN_ENTREGA", "FECHA_ENTREGA", "MENU", "COSTO_TOTAL", "COSTO_DOMICILIO"));
        this.propiedades = new ArrayList<String> (Arrays.asList("v_locationName", "v_deliveryAddress", "v_deliveryDate", "v_menu", "v_totalAmount", "v_deliveryCost"));

        //Se añaden los campos extra requeridos
        for(File_structure structure: file_structures){
            if (structure.getFk_available_field_id() == 1){
                this.headers.add("CIUDAD");
                this.propiedades.add("v_city");
            } else if (structure.getFk_available_field_id() == 2) {
                this.headers.add("METODO_PAGO");
                this.propiedades.add("v_paymentMethod");
            }else if (structure.getFk_available_field_id() == 3) {
                this.headers.add("NOMBRE_CLIENTE");
                this.propiedades.add("v_fullName");
            }else if (structure.getFk_available_field_id() == 4) {
                this.headers.add("NUMERO_CELULAR");
                this.propiedades.add("v_cellphoneNumber");
            }else if (structure.getFk_available_field_id() == 5) {
                this.headers.add("TIPO_DOCUMENTO");
                this.propiedades.add("v_documentType");
            }
        }
    }

    /**
     * Modifica las fechas entre las cuales se filtra la información a escribir en el archivo CSV, de acuerdo a las elecciones
     * de frecuencia, año y mes escogidas por el usuario
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param frequency Frecuencia para mostrar la información, puede ser Mensual, Quincenal o Semanal
     * @param year Año al cual corresponde la información
     * @param month Mes al cual corresponde la información
     */
    private void DefineDates(String frequency, String year, String month){

        //Obtengo el último día del mes definido
        LocalDate completeDate = LocalDate.parse("01/"+ month + "/" + year, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate completeLastDate = completeDate.withDayOfMonth(completeDate.getMonth().length(completeDate.isLeapYear()));
        Integer lastDayInt = completeLastDate.getDayOfMonth();
        String lastDayString = String.valueOf(lastDayInt);

        String shortYear = year.substring(2);
        String fromDay = "";
        String toDay = "";
        Integer tempCalculations;

        switch (frequency) {

            case "Mensual":
                fromDay = "01";
                toDay = lastDayString;
                break;

            case "Quincena 1":
                fromDay = "01";
                toDay = "15";
                break;

            case "Quincena 2":
                fromDay = "16";
                toDay = lastDayString;
                break;

            case "Semana 1":
                fromDay = "01";
                toDay = "07";
                break;

            case "Semana 2":
                fromDay = "08";
                toDay = "15";
                break;

            case "Semana 3":
                fromDay = "16";
                tempCalculations = ((lastDayInt-15)/2)+15;
                toDay = tempCalculations.toString();
                break;

            case "Semana 4":
                tempCalculations = ((lastDayInt-15)/2)+16;
                fromDay = tempCalculations.toString();
                toDay = lastDayString;
                break;
        }

        fromDate = fromDay + "/" + month + "/" + shortYear;
        toDate = toDay + "/" + month + "/" + shortYear;
    }
}



