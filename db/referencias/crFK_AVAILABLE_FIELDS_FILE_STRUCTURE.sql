/************************************************************************************
Description:  Defining foreing key in FILE_STRUCTURE table for its relation with AVAILABLE_FIELDS table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

ALTER TABLE APP_GEST_DOMICILIOS.FILE_STRUCTURE ADD CONSTRAINT FK_AVAILABLE_FIELDS_FILE_STRUCTURE FOREIGN KEY (FK_AVAILABLE_FIELD_ID) REFERENCES APP_GEST_DOMICILIOS.AVAILABLE_FIELDS (AVAILABLE_FIELD_ID)
/