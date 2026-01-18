package com.menuprime.controller;

import com.menuprime.services.Load_file_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Load_File_Controller es la clase que permite definir y controlar  los endpoints
 * relacionados con la carga de archivos
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@RestController
@CrossOrigin(origins = "*")
public class Load_File_Controller {

    @Autowired
    private Load_file_Service service;

    /**
     * Devuelve una ResponseEntity con el mensaje final al intentar guardar la información del archo CSV en la entidad Deliveries.
     * El mensaje de exito va acompañado de un código Http 201 y el de error con un 500
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param file Archivo CSV con la información a guardar
     * @return ResponseEntity<List<Available_fields>>
     */
    @PostMapping("/load")
    public ResponseEntity<String> loadData (@RequestParam("file") MultipartFile file) {

        String result = service.save(file);

        if (result == "Registros creados exitosamente") {
            return new ResponseEntity<String>(result, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
