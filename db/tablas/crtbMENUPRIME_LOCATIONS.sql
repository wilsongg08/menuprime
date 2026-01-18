/************************************************************************************
Description:  Table in charge of storing the locations of Menuprime restaurant
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE TABLE APP_GEST_DOMICILIOS.MENUPRIME_LOCATIONS
(
MENUPRIME_LOCATION_ID           NUMBER(4,0)	  GENERATED ALWAYS AS IDENTITY,    
NAME	                    	VARCHAR2(20)  NOT NULL,
ADDRESS	                    	VARCHAR2(50)  NOT NULL,
CITY	                    	VARCHAR2(25)  NOT NULL,
DEPARTMENT  	                VARCHAR2(25)  NOT NULL
)

/
COMMENT ON TABLE APP_GEST_DOMICILIOS.MENUPRIME_LOCATIONS IS 'List of MenuPrime locations' 
/