/************************************************************************************
Description:  Defining foreing key in DELIVERIES_MENUS table for its relation with DELIVERIES table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

ALTER TABLE APP_GEST_DOMICILIOS.DELIVERIES_MENUS ADD CONSTRAINT FK_DELIVERIES_DELIVERIES_MENUS FOREIGN KEY (FK_DELIVERY_ID) REFERENCES APP_GEST_DOMICILIOS.DELIVERIES (DELIVERY_ID)
/