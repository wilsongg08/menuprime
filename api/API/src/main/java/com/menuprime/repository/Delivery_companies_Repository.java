package com.menuprime.repository;

import com.menuprime.model.Delivery_companies;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Delivery_companies_Repository extiende de JpaRepository y proporciona diferentes metodos para
 * consultar y modificar la entidad Delivery_companies en la Base de datos
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
public interface Delivery_companies_Repository extends JpaRepository<Delivery_companies, Integer> {
}
