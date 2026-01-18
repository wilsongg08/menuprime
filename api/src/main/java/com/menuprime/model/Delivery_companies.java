package com.menuprime.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Delivery_companies es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Data
@Entity
@Table(name = "delivery_companies")
public class Delivery_companies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_company_id;

    @Column(name = "business_name", nullable = false)
    private String business_name;

    @Column(name = "tax_number", nullable = false)
    private int tax_number;

    @Column(name = "frequency_rate", nullable = false)
    private String frequency_rate;

}
