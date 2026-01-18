package com.menuprime.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Deliveries_menus es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Data
@Entity
@Table(name = "deliveries_menus")
public class Deliveries_menus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_menu_id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_cost", nullable = false)
    private int unit_cost;

    @Column(name = "total_cost", nullable = false)
    private int total_cost;

    @Column(name = "fk_menu_id", nullable = false)
    private int fk_menu_id;

    @Column(name = "fk_delivery_id", nullable = false)
    private int fk_delivery_id;

    @JoinColumn(name = "fk_menu_id", insertable = false, updatable = false)
    @ManyToOne
    private Menus menus;

    @JoinColumn(name = "fk_delivery_id", insertable = false, updatable = false)
    @ManyToOne
    private Deliveries deliveries;
}
