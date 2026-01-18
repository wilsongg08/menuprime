/************************************************************************************
Description:  Defining primary key for AVAILABLE_FIELDS table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

ALTER TABLE APP_GEST_DOMICILIOS.AVAILABLE_FIELDS ADD CONSTRAINT PK_AVAILABLE_FIELDS PRIMARY KEY (AVAILABLE_FIELD_ID)
/