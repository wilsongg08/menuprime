/************************************************************************************
Description:  Table in charge of storing the menus available
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.MENUS
(
MENU_ID				            NUMBER(3,0)   GENERATED ALWAYS AS IDENTITY,    
DESCRIPTION		                VARCHAR2(150) NOT NULL,
UNIT_COST						NUMBER(6,0)   NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.MENUS IS 'List of menus' 
/