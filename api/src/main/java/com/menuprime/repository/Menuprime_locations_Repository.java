package com.menuprime.repository;

import com.menuprime.model.Menuprime_locations;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Menuprime_locations_Repository extiende de JpaRepository y proporciona diferentes metodos para
 * consultar y modificar la entidad Menuprime_locations en la Base de datos
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
public interface Menuprime_locations_Repository extends JpaRepository<Menuprime_locations, Integer> {
}
