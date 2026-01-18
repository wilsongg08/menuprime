package com.menuprime.controller;

import com.menuprime.model.Menuprime_locations;
import com.menuprime.services.Menuprime_locations_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Menuprime_locations_Controller es la clase que permite definir y controlar todos los endpoints
 * relacionados con la entidad Menuprime_locations
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@RestController
@CrossOrigin(origins = "*")
public class Menuprime_locations_Controller {

    @Autowired
    private Menuprime_locations_Service service;

    /**
     * Devuelve una ResponseEntity con la lista de todos los registros que están en la entidad Menuprime_locations.
     * En caso de que haya ocurrido un error en el service, devolverá una lista vacía con el código Http 500.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @return ResponseEntity<List<Menuprime_locations>>
     */
    @GetMapping("/locations")
    public ResponseEntity<List<Menuprime_locations>> get_available_fields()
    {
        try {
            List<Menuprime_locations> list  = service.findAll();
            return new ResponseEntity<List<Menuprime_locations>>(list, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<List<Menuprime_locations>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
