package com.menuprime.repository;

import com.menuprime.model.Deliveries;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Deliveries_Repository extiende de JpaRepository y proporciona diferentes metodos para
 * consultar y modificar la entidad Deliveries en la Base de datos
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
public interface Deliveries_Repository extends JpaRepository<Deliveries, Integer> {
}
