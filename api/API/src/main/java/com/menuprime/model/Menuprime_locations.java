package com.menuprime.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Menuprime_locations es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Data
@Entity
@Table(name = "menuprime_locations")
public class Menuprime_locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuprime_location_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "department", nullable = false)
    private String department;
}
