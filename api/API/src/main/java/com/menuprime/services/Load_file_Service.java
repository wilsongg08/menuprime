package com.menuprime.services;

import com.menuprime.model.Deliveries;
import com.menuprime.repository.Deliveries_Repository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Load_file_Service permite guardar información de un archivo CSV en la entidad Deliveries
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Service
public class Load_file_Service {

    @Autowired
    private Deliveries_Repository deliveries_repository;

    /**
     * Crea nuevos registros en la entidad Deliveries de acuerdo a la información proveniente del archivo CSV
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param file Archivo CSV con la información a guardar
     * @return String
     */
    @Transactional
    public String save(MultipartFile file) {
        try {
            List<Deliveries> deliveries = csvToDeliveries(file.getInputStream());
            deliveries_repository.saveAll(deliveries);
            return "Registros creados exitosamente";
        } catch (Exception e) {
            System.out.println(e);
            return "Error. Por favor intente de nuevo";
        }
    }

    /**
     * Convierte el archivo CSV en una lista de Deliveries
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param is Stream de bytes
     * @return List<Deliveries>
     */
    public static List<Deliveries> csvToDeliveries(InputStream is) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<Deliveries> deliveries = new ArrayList<Deliveries>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Deliveries delivery = new Deliveries(formato.parse(csvRecord.get("delivery_date")), csvRecord.get("payment_method"),
                                                        Integer.parseInt(csvRecord.get("total_amount")), Integer.parseInt(csvRecord.get("delivery_cost")),
                                                        Integer.parseInt(csvRecord.get("fk_menuprime_locations_id")), Integer.parseInt(csvRecord.get("fk_customer_id")),
                                                        Integer.parseInt(csvRecord.get("fk_delivery_company_id")));

                deliveries.add(delivery);
            }

            return deliveries;

        } catch (Exception e) {
            throw new RuntimeException("Fail to parse CSV file: " + e.getMessage());
        }
    }
}
