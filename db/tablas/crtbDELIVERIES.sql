/************************************************************************************
Description:  Table in charge of storing all the deliveries
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.DELIVERIES
(
DELIVERY_ID			            NUMBER(8,0)  GENERATED ALWAYS AS IDENTITY,    
DELIVERY_DATE					DATE		 NOT NULL,
PAYMENT_METHOD					VARCHAR2(20) NOT NULL,
TOTAL_AMOUNT					NUMBER(8,0)  NOT NULL,
DELIVERY_COST					NUMBER(5,0)  NOT NULL,
FK_MENUPRIME_LOCATIONS_ID		NUMBER(4,0)  NOT NULL,
FK_CUSTOMER_ID					NUMBER(7,0)  NOT NULL,
FK_DELIVERY_COMPANY_ID			NUMBER(4,0)  NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.FILE_STRUCTURE IS 'List of deliveries' 
/
