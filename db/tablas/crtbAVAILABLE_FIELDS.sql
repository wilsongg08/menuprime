/************************************************************************************
Description:  Table in charge of storing the extra fields available to add to the file
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.AVAILABLE_FIELDS 
(
AVAILABLE_FIELD_ID              NUMBER(3,0)   GENERATED ALWAYS AS IDENTITY,    
TABLE_NAME                     	VARCHAR2(25)  NOT NULL,
COLUMN_NAME  	                VARCHAR2(30)  NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.AVAILABLE_FIELDS IS 'Extra fields/information available' 
/