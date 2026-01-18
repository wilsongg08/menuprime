package com.menuprime.controller;

import com.menuprime.model.Available_fields;
import com.menuprime.services.Available_fields_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Available_fields_Controller es la clase que permite definir y controlar todos los endpoints
 * relacionados con la entidad Available_fields
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@RestController
@CrossOrigin(origins = "*")
public class Available_fields_Controller {

    @Autowired
    private Available_fields_Service service;

    /**
     * Devuelve una ResponseEntity con la lista de todos los registros que están en la entidad Available_fields.
     * En caso de que ocurra un error, devolverá el código Http 500.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @return ResponseEntity<List<Available_fields>>
     */
    @GetMapping("/availablefields")
    public ResponseEntity<List<Available_fields>> Get_available_fields()
    {
        try {
            List<Available_fields> list = service.findAll();
            return new ResponseEntity<List<Available_fields>>(list, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<List<Available_fields>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}