package com.menuprime.services;

import com.menuprime.model.Available_fields;
import com.menuprime.repository.Available_fields_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Available_fields_Service permite la conexión con el repositorio de la entidad Available_fields
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Service
public class Available_fields_Service {

    @Autowired
    private Available_fields_Repository repository;

    /**
     * Devuelve todos los registros que están en la entidad Available_fields
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @return List<Available_fields>
     */
    @Transactional
    public List<Available_fields> findAll() {
        List<Available_fields> list= repository.findAll();
        return list;
    }
}
