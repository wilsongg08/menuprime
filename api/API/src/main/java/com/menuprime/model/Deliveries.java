package com.menuprime.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Deliveries es la clase que permite mapear la entidad con el mismo nombre en el esquema de Oracle APP_GEST_DOMICILIOS
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "deliveries")
public class Deliveries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_id;

    @Column(name = "delivery_date", nullable = false)
    private Date delivery_date;

    @Column(name = "payment_method", nullable = false)
    private String payment_method;

    @Column(name = "total_amount", nullable = false)
    private int total_amount;

    @Column(name = "delivery_cost", nullable = false)
    private int delivery_cost;

    @Column(name = "fk_menuprime_locations_id", nullable = false)
    private int fk_menuprime_location_id;

    @Column(name = "fk_customer_id", nullable = false)
    private int fk_customer_id;

    @Column(name = "fk_delivery_company_id", nullable = false)
    private int fk_delivery_company_id;

    @JoinColumn(name = "fk_menuprime_locations_id", insertable = false, updatable = false)
    @ManyToOne
    private Menuprime_locations menuprime_locations;

    @JoinColumn(name = "fk_customer_id", insertable = false, updatable = false)
    @ManyToOne
    private Customers customers;

    @JoinColumn(name = "fk_delivery_company_id", insertable = false, updatable = false)
    @ManyToOne
    private Delivery_companies delivery_companies;

    public Deliveries(Date delivery_date, String payment_method, int total_amount, int delivery_cost, int fk_menuprime_location_id, int fk_customer_id, int fk_delivery_company_id) {
        this.delivery_date = delivery_date;
        this.payment_method = payment_method;
        this.total_amount = total_amount;
        this.delivery_cost = delivery_cost;
        this.fk_menuprime_location_id = fk_menuprime_location_id;
        this.fk_customer_id = fk_customer_id;
        this.fk_delivery_company_id = fk_delivery_company_id;
    }
}
