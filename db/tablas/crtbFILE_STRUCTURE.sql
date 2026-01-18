/************************************************************************************
Description:  Table in charge of storing the extra fields chose to be placed into the file
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.FILE_STRUCTURE
(
FILE_STRUCTURE_ID	            NUMBER(3,0)  GENERATED ALWAYS AS IDENTITY,    
FK_AVAILABLE_FIELD_ID			NUMBER(3,0)  NOT NULL,
FK_MENUPRIME_LOCATION_ID		NUMBER(4,0)  NOT NULL,
FK_DELIVERY_COMPANY_ID			NUMBER(4,0)  NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.FILE_STRUCTURE IS 'Extra fields chosen' 
/