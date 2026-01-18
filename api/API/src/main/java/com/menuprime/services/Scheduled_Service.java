package com.menuprime.services;

import com.menuprime.model.Delivery_companies;
import com.menuprime.repository.Delivery_companies_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.supercsv.io.ICsvBeanWriter;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Scheduled_Service es la clase que permite generar automaticamente los archivos por cada una de las empresas
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Service
public class Scheduled_Service {

    String filepath = "C:\\Users\\Public";

    @Autowired
    private Generate_File_Service generate_File_Service;

    @Autowired
    private Delivery_companies_Repository delivery_companies_Repository;

    /**
     * Metodo agendado para ejecutarse automaticamente el primer día de todos los meses.
     * Genera los archivos de cada empresa domiciliaria y los guarda en la ruta del equipo especificada en la variable filepath.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     */
    @Scheduled(cron = "0 0 2 1 * ?")  // Segundos, minutos, horas, dias, meses, dia especifico semana
    public void Scheduled_files_generator() throws IOException {

        String month = "";
        String year = "";

        try{
            LocalDate currentDate = LocalDate.now();
            if (currentDate.getMonthValue() == 1) {
                month = "12";
                year = String.valueOf(currentDate.getYear()-1);
            } else {
                month = String.valueOf(currentDate.getMonthValue());
                year = String.valueOf(currentDate.getYear());
            }

            List<Delivery_companies> delivery_companies = delivery_companies_Repository.findAll();

            for (Delivery_companies company : delivery_companies) {
                File file = new File(filepath + "\\" + company.getBusiness_name() + "_" + company.getFrequency_rate() + "_" + month + "_" + year + ".csv");

                FileWriter outputfile = new FileWriter(file);

                ICsvBeanWriter writer = generate_File_Service.getCsv(company.getBusiness_name(), company.getDelivery_company_id(), month, year, company.getFrequency_rate(), outputfile);

                writer.close();
            }
        } catch (IOException IOe) {
            System.out.println(IOe);
        }
    }
}

/*
    @Scheduled(fixedRate = 3000)
    public void tarea1() {
        System.out.println("Tarea usando fixedRate cada 3 segundos - " + System.currentTimeMillis() / 1000);
    }
*/
