package com.menuprime.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Customers es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Data
@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "delivery_address", nullable = false)
    private String delivery_address;

    @Column(name = "cellphone_number", nullable = false)
    private int cellphone_number;

    @Column(name = "document_type", nullable = false)
    private String document_type;

    @Column(name = "document_number", nullable = false)
    private int document_number;
}
