package com.menuprime.repository;

import com.menuprime.model.File_structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * File_structure_Repository extiende de JpaRepository y proporciona diferentes metodos para
 * consultar y modificar la entidad File_structure en la Base de datos.
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
public interface File_structure_Repository extends JpaRepository<File_structure, Integer> {

    /**
     * Metodo personalizado con JPQL que devuelve todos los registros de la entidad File_structure
     * de acuerdo a una location_id y delivery_company_id especifica.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param id_location ID de una Menuprime_locations
     * @param id_delivery_company Id de una Delivery_company
     * @return List<File_structure>
     */
    @Query("SELECT fs FROM File_structure fs WHERE fs.fk_location_id = :id_location AND fs.fk_delivery_company_id = :id_company ")
    public List<File_structure> findAllByLocationAndCompany(@Param("id_location") int id_location, @Param("id_company") int id_delivery_company);
}
