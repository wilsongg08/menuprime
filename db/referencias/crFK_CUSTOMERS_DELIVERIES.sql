/************************************************************************************
Description:  Defining foreing key in DELIVERIES table for its relation with CUSTOMERS table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

ALTER TABLE APP_GEST_DOMICILIOS.DELIVERIES ADD CONSTRAINT FK_CUSTOMERS_DELIVERIES FOREIGN KEY (FK_CUSTOMER_ID)  REFERENCES APP_GEST_DOMICILIOS.CUSTOMERS (CUSTOMER_ID)
/