package com.menuprime.services;

import com.menuprime.model.File_structure;
import com.menuprime.repository.File_structure_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * File_structure_Service permite la conexión con el repositorio de la entidad File_structure
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Service
public class File_structure_Service {
    
    @Autowired
    private File_structure_Repository repository;

    /**
     * Devuelve todos los registros que están en la entidad File_structure de acuerdo a un id_location y un id_delivery_company.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param id_location ID de una Menuprime_locations
     * @param id_delivery_company Id de una Delivery_company
     * @return List<Delivery_companies>
     */
    @Transactional
    public List<File_structure> findAll(int id_location, int id_delivery_company) {
        List<File_structure> list = repository.findAllByLocationAndCompany(id_location, id_delivery_company);
        return list;
    }

    /**
     * Crea un nuevo registro en la entidad File_structure
     * Devuelve un mensaje con el resultado de la operación.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param newRegistro Objeto de tipo File_structure que contiene toda la información del nuevo registro a crear.
     * @return List<Available_fields>
     */
    @Transactional
    public String save(File_structure newRegistro) {
        try
        {
            repository.save(newRegistro);
            return "Registro creado exitosamente";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "Error. Por favor intente de nuevo";
        }
    }

    /**
     * Elimina un registro especifico de la entidad File_structure.
     * Devuelve un mensaje con el resultado de la operación.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param id Id del registro a eliminar.
     * @return String
     */
    @Transactional
    public String delete(int id) {
        try
        {
            Optional<File_structure> oldRegistro = repository.findById(id);
            if (!oldRegistro.isPresent())
            {
                return "Error. Registro no existe";
            }

            repository.deleteById(id);
            return "Registro eliminado exitosamente";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "Error. Por favor intente de nuevo.";
        }
    }
}
