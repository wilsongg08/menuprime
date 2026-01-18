package com.menuprime.controller;

import com.menuprime.model.Delivery_companies;
import com.menuprime.services.Delivery_companies_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Delivery_companies_Controller es la clase que permite definir y controlar todos los endpoints
 * relacionados con la entidad Delivery_companies
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@RestController
@CrossOrigin(origins = "*")
public class Delivery_companies_Controller {

    @Autowired
    private Delivery_companies_Service service;

    /**
     * Devuelve una ResponseEntity con la lista de todos los registros que están en la entidad Delivery_companies.
     * En caso de que haya ocurrido un error, devolverá el código Http 500.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @return ResponseEntity<List<Delivery_companies>>
     */
    @GetMapping("/companies")
    public ResponseEntity<List<Delivery_companies>> get_delivery_companies()
    {
        try {
            List<Delivery_companies> list = service.findAll();
            return new ResponseEntity<List<Delivery_companies>>(list, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<List<Delivery_companies>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Devuelve una ResponseEntity con el mensaje final al intentar modificar un registro de la entidad Delivery_companies.
     * El mensaje de exito va acompañado de un código Http 201 y el de error con un 500
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param delivery_company Objeto de tipo Delivery_companies que contiene la información a modificar
     * @return ResponseEntity<List<Available_fields>>
     */
    @PutMapping("/update")
    public ResponseEntity<String> update_frequency( @RequestBody Delivery_companies delivery_company )
    {
        String result = service.updateFrequencyById(delivery_company);

        if (result == "Modificado con éxito") {
            return new ResponseEntity<String>(result, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}