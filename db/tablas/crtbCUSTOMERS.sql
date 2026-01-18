/************************************************************************************
Description:  Table in charge of storing the customers
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.CUSTOMERS
(
CUSTOMER_ID			            NUMBER(7,0)   GENERATED ALWAYS AS IDENTITY,    
FULL_NAME		                VARCHAR2(65)  NOT NULL,
DELIVERY_ADDRESS               	VARCHAR2(50)  NOT NULL,
CELLPHONE_NUMBER				NUMBER(11,0)  NOT NULL,
DOCUMENT_TYPE                 	VARCHAR2(30)  NOT NULL,
DOCUMENT_NUMBER					NUMBER(10,0)  NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.CUSTOMERS IS 'List of customers' 
/