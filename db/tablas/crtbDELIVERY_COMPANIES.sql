/************************************************************************************
Description:  Table in charge of storing the delivery companies
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.DELIVERY_COMPANIES
(
DELIVERY_COMPANY_ID	            NUMBER(4,0)   GENERATED ALWAYS AS IDENTITY,    
BUSINESS_NAME	                VARCHAR2(50)  NOT NULL,
TAX_NUMBER                    	NUMBER(9,0)   NOT NULL,
FREQUENCY_RATE                 	VARCHAR2(11)  NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.DELIVERY_COMPANIES IS 'List of delivery companies' 
/


