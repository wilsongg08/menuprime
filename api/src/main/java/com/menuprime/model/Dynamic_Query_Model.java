package com.menuprime.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Dynamic_Query_Model es la clase que permite mapear la  respuesta que envía la base de datos cuando se hace uso de la clase/repositorio Generate_File_Repository
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dynamic_Query_Model {

    private String v_locationName;
    private String v_deliveryAddress;
    private Date v_deliveryDate;
    private String v_menu;
    private Integer v_totalAmount;
    private Integer v_deliveryCost;
    private String v_city;
    private String v_paymentMethod;
    private String v_fullName;
    private Long v_cellphoneNumber;
    private String v_documentType;
}
