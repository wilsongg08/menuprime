/************************************************************************************
Description:  Defining foreing key in DELIVERIES table for its relation with MENUPRIME_LOCATIONS table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

ALTER TABLE APP_GEST_DOMICILIOS.DELIVERIES ADD CONSTRAINT FK_MENUPRIME_LOCATIONS_DELIVERIES FOREIGN KEY (FK_MENUPRIME_LOCATIONS_ID)  REFERENCES APP_GEST_DOMICILIOS.MENUPRIME_LOCATIONS (MENUPRIME_LOCATION_ID)
/