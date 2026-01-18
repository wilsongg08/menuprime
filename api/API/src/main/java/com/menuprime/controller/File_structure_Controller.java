package com.menuprime.controller;

import com.menuprime.model.File_structure;
import com.menuprime.services.File_structure_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * File_structure_Controller es la clase que permite definir y controlar todos los endpoints
 * relacionados con la entidad File_structure
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@RestController
@CrossOrigin(origins = "*")
public class File_structure_Controller {

    @Autowired
    private File_structure_Service service;

    /**
     * Devuelve una ResponseEntity con la lista de todos los registros que están en la entidad File_structure de acuerdo a un id_location y un id_delivery_company.
     * En caso de que haya ocurrido un error en el service, devolverá una lista vacia con el código Http 500.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param id_location ID de una Menuprime_locations
     * @param id_delivery_company Id de una Delivery_company
     * @return ResponseEntity<List<Available_fields>>
     */
    @GetMapping("/structure")
    public ResponseEntity<List<File_structure>> get_file_structure(@RequestParam int id_location, @RequestParam int id_delivery_company)
    {
        try {
            List<File_structure> list =  service.findAll(id_location, id_delivery_company);
            return new ResponseEntity<List<File_structure>>(list, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<List<File_structure>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Devuelve una ResponseEntity con el mensaje final al intentar añadir un registro nuevo a la entidad file_structure.
     * El mensaje de exito va acompañado de un código Http 201 y el de error con un 500
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param file_structure Objeto de tipo File_structure a crear.
     * @return ResponseEntity<String>
     */
    @PostMapping("/structure")
    public ResponseEntity<String> save_file_structure(@RequestBody File_structure file_structure) {

        String result = service.save(file_structure);

        if (result == "Registro creado exitosamente") {
            return new ResponseEntity<String>(result, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Devuelve una ResponseEntity con el mensaje final al intentar eliminar un registro de la entidad file_structure.
     * El mensaje de exito va acompañado de un código Http 200 y el de error con un 500
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param sid Id del registro a eliminar
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/structure/{sid}")
    public ResponseEntity<String> deleteTipoTransaccion(@PathVariable int sid)
    {
        String result = service.delete(sid);

        if (result == "Registro eliminado exitosamente") {
            return new ResponseEntity<String>(result, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
