package com.menuprime.services;

import com.menuprime.model.Delivery_companies;
import com.menuprime.repository.Delivery_companies_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Delivery_companies_Service permite la conexión con el repositorio de la entidad Delivery_companies
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Service
public class Delivery_companies_Service {
    
    @Autowired
    private Delivery_companies_Repository repository;

    /**
     * Devuelve todos los registros que están en la entidad Delivery_companies.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @return List<Delivery_companies>
     */
    @Transactional
    public List<Delivery_companies> findAll() {
        List<Delivery_companies> list =  repository.findAll();
        return list;
    }

    /**
     * Actualiza el atributo Frequency_rate de registro especifico de la entidad Delivery_companies.
     * Devuelve un mensaje con el resultado de la operación.
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param company Objeto de tipo Delivery_companies que contiene el id del registro a modificar, así como el nuevo valor de Frequency_rate
     * @return String
     */
    @Transactional
    public String updateFrequencyById(Delivery_companies company ) {

        try{
            Optional<Delivery_companies> temp = repository.findById(company.getDelivery_company_id());
            Delivery_companies delivery_company = temp.get();
            delivery_company.setFrequency_rate(company.getFrequency_rate());
            repository.save(delivery_company);
            return "Modificado con éxito";
        }
        catch(Exception e){
            System.out.println(e);
            return "Error en la modificación";
        }
    }
}
