/************************************************************************************
Description:  Defining foreing key in DELIVERIES table for its relation with DELIVERY_COMPANIES table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

ALTER TABLE APP_GEST_DOMICILIOS.DELIVERIES ADD CONSTRAINT FK_DELIVERY_COMPANIES_DELIVERIES FOREIGN KEY (FK_DELIVERY_COMPANY_ID) REFERENCES APP_GEST_DOMICILIOS.DELIVERY_COMPANIES (DELIVERY_COMPANY_ID)
/