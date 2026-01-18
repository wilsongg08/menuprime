package com.menuprime.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * File_structure es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "file_structure")
public class File_structure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int file_structure_id;

    @Column(name="fk_available_field_id", nullable = false)
    private int fk_available_field_id;

    @Column(name="fk_menuprime_location_id", nullable = false)
    private int fk_location_id;

    @Column(name="fk_delivery_company_id", nullable = false)
    private int fk_delivery_company_id;

    /*
    @JoinColumn(name = "fk_available_field_id", insertable = false, updatable = false)
    @ManyToOne
    private Available_fields available_fields;

    @JoinColumn(name = "fk_menuprime_location_id", insertable = false, updatable = false)
    @ManyToOne
    private Menuprime_locations menuprime_locations;

    @JoinColumn(name = "fk_delivery_company_id", insertable = false, updatable = false)
    @ManyToOne
    private Delivery_companies delivery_companies;
    */
}
