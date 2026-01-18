package com.menuprime.repository;

import com.menuprime.model.Available_fields;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Available_fields_Repository extiende de JpaRepository y proporciona diferentes metodos para
 * consultar y modificar la entidad Available_fields en la Base de datos
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
public interface Available_fields_Repository extends JpaRepository<Available_fields, Integer> {
}
