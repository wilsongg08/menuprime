package com.menuprime.services;

import com.menuprime.model.Menuprime_locations;
import com.menuprime.repository.Menuprime_locations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Menuprime_locations_Service permite la conexión con el repositorio de la entidad Menuprime_locations
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Service
public class Menuprime_locations_Service {
    
    @Autowired
    private Menuprime_locations_Repository repository;

    /**
     * Devuelve todos los registros que están en la entidad Menuprime_locations.
     * En caso de algún error, se devolverá una lista vacía.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @return List<Menuprime_locations>
     */
    @Transactional
    public List<Menuprime_locations> findAll() {
        List<Menuprime_locations> list = repository.findAll();
        return list;
    }
}
