package com.menuprime.controller;


import com.menuprime.services.Generate_File_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.ICsvBeanWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Generate_File_Controller es la clase que permite definir generar el archivo por empresa, frecuencia, mes y año
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@RestController
@CrossOrigin(origins = "*")
public class Generate_File_Controller {

    @Autowired
    private Generate_File_Service service;


    /**
     * Devuelve una ResponseEntity con un map que contiene en la llave "file" el archivo CSV en formato Base 64
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param selectedCompanyName Nombre de la Delivery_company.
     * @param selectedCompanyId Id de la Delivery_company.
     * @param selectedMonth Mes al cual corresponde la información
     * @param selectedYear Año al cual corresponde la información
     * @param selectedFrequency Frecuencia para mostrar la información, puede ser Mensual, Quincenal o Semanal
     * @return ResponseEntity<Map<String, Object>>
     */
    @GetMapping("/generate")
    public ResponseEntity<Map<String, Object>> exportCsv(@RequestParam String selectedCompanyName,
                                                         @RequestParam int selectedCompanyId,
                                                         @RequestParam String selectedMonth,
                                                         @RequestParam String selectedYear,
                                                         @RequestParam String selectedFrequency) throws IOException {

        try{
            Map<String, Object> response = new HashMap<String, Object>();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ICsvBeanWriter writer = service.getCsv(selectedCompanyName, selectedCompanyId, selectedMonth, selectedYear, selectedFrequency, new OutputStreamWriter(output));
            writer.close();
            response.put("file", new String(Base64.getEncoder().encode(output.toByteArray())));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}