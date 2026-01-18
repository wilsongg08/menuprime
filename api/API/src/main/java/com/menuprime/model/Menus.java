package com.menuprime.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Menus es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Data
@Entity
@Table(name = "menus")
public class Menus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menu_id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "unit_cost", nullable = false)
    private int unit_cost;
}
