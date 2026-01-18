package com.menuprime.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Available_fields es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Data
@Entity
@Table(name = "available_fields")
public class Available_fields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int available_field_id;

    @Column(name = "table_name", nullable = false)
    private String table_name;

    @Column(name = "column_name", nullable = false)
    private String column_name;

}
