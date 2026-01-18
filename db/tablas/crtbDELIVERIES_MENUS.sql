/************************************************************************************
Description:  Join/intersection table in charge of break the many-to-many relationship between Deliveries and Menus tables.
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.DELIVERIES_MENUS
(
DELIVERY_MENU_ID	            NUMBER(10,0) GENERATED ALWAYS AS IDENTITY,    
QUANTITY						NUMBER(2,0)  NOT NULL,
UNIT_COST						NUMBER(6,0)  NOT NULL,
TOTAL_COST						NUMBER(7,0)  NOT NULL,
FK_MENU_ID						NUMBER(3,0)  NOT NULL,
FK_DELIVERY_ID					NUMBER(8,0)  NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.DELIVERIES_MENUS IS 'Join/intersection table' 
/