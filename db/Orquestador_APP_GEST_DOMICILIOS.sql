/****************************************************************************************************/
--- IT team  - 	"Seguros Bolivar"

--- File:	 	Orquestador_APP_GEST_DOMICILIOS.sql
--- Author:	    Wilson Gomez - wilson.gomez@segurosbolivar.com
--- Cellphone:	    
--- Record:	 	time.Date(2022, time.December, 18, 17, 30, 41, 756501200, time.Local)
--- HU:		 	GB48-12
/****************************************************************************************************/

PROMPT Orquestador_APP_GEST_DOMICILIOS.SQL

ALTER SESSION SET CURRENT_SCHEMA=SYSTEM;
/

/****************************************************************************************************/

PROMPT ---------------------------Objetos: Esquema-------------------------------------

PROMPT Aplicando Objeto ...  @..\DB\sys\crSCH_APP_GEST_DOMICILIOS.sql
@..\DB\sys\crSCH_APP_GEST_DOMICILIOS.sql
/

/****************************************************************************************************/

ALTER SESSION SET CURRENT_SCHEMA=APP_GEST_DOMICILIOS;
/

/****************************************************************************************************/

PROMPT ---------------------------Objetos: tablas-------------------------------------

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbAVAILABLE_FIELDS.sql
@..\DB\tablas\crtbAVAILABLE_FIELDS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbCUSTOMERS.sql
@..\DB\tablas\crtbCUSTOMERS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbDELIVERIES.sql
@..\DB\tablas\crtbDELIVERIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbDELIVERIES_MENUS.sql
@..\DB\tablas\crtbDELIVERIES_MENUS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbDELIVERY_COMPANIES.sql
@..\DB\tablas\crtbDELIVERY_COMPANIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbFILE_STRUCTURE.sql
@..\DB\tablas\crtbFILE_STRUCTURE.sql
/

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbMENUPRIME_LOCATIONS.sql
@..\DB\tablas\crtbMENUPRIME_LOCATIONS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\tablas\crtbMENUS.sql
@..\DB\tablas\crtbMENUS.sql
/

/****************************************************************************************************/

PROMPT ---------------------------Objetos: indices-------------------------------------

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_AVAILABLE_FIELDS.sql
@..\DB\indices\crPK_AVAILABLE_FIELDS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_CUSTOMERS.sql
@..\DB\indices\crPK_CUSTOMERS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_DELIVERIES.sql
@..\DB\indices\crPK_DELIVERIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_DELIVERIES_MENUS.sql
@..\DB\indices\crPK_DELIVERIES_MENUS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_DELIVERY_COMPANIES.sql
@..\DB\indices\crPK_DELIVERY_COMPANIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_FILE_STRUCTURE.sql
@..\DB\indices\crPK_FILE_STRUCTURE.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_MENUPRIME_LOCATIONS.sql
@..\DB\indices\crPK_MENUPRIME_LOCATIONS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\crPK_MENUS.sql
@..\DB\indices\crPK_MENUS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\IDX_FK_CUSTOMER_DELIVERIES.sql
@..\DB\indices\IDX_FK_CUSTOMER_DELIVERIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\indices\IDX_FK_DELIVERY_DELIVERIES_MENUS.sql
@..\DB\indices\IDX_FK_DELIVERY_DELIVERIES_MENUS.sql
/

/****************************************************************************************************/

PROMPT ---------------------------Objetos: referencias-------------------------------------

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_AVAILABLE_FIELDS_FILE_STRUCTURE.sql
@..\DB\referencias\crFK_AVAILABLE_FIELDS_FILE_STRUCTURE.sql
/

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_CUSTOMERS_DELIVERIES.sql
@..\DB\referencias\crFK_CUSTOMERS_DELIVERIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_DELIVERIES_DELIVERIES_MENUS.sql
@..\DB\referencias\crFK_DELIVERIES_DELIVERIES_MENUS.sql
/

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_DELIVERY_COMPANIES_DELIVERIES.sql
@..\DB\referencias\crFK_DELIVERY_COMPANIES_DELIVERIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_DELIVERY_COMPANIES_FILE_STRUCTURE.sql
@..\DB\referencias\crFK_DELIVERY_COMPANIES_FILE_STRUCTURE.sql
/

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_LOCATIONS_FILE_STRUCTURE.sql
@..\DB\referencias\crFK_LOCATIONS_FILE_STRUCTURE.sql
/

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_MENUPRIME_LOCATIONS_DELIVERIES.sql
@..\DB\referencias\crFK_MENUPRIME_LOCATIONS_DELIVERIES.sql
/

PROMPT Aplicando Objeto ...  @..\DB\referencias\crFK_MENUS_DELIVERIES_MENUS.sql
@..\DB\referencias\crFK_MENUS_DELIVERIES_MENUS.sql
/

/****************************************************************************************************/

PROMPT ---------------------------Objetos: paquetes-------------------------------------

PROMPT Aplicando Objeto ...  @..\DB\paquetes\PKG_GENERATE_DYNAMIC_QUERY.sql
@..\DB\paquetes\PKG_GENERATE_DYNAMIC_QUERY.sql
/

PROMPT Aplicando Objeto ...  @..\DB\paquetes\PKG_GENERATE_DYNAMIC_QUERY_BODY.sql
@..\DB\paquetes\PKG_GENERATE_DYNAMIC_QUERY_BODY.sql
/

/****************************************************************************************************/

PROMPT ---------------------------Objetos: sql-------------------------------------

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataAvailable_Fields.sql
@..\DB\sql\insDataAvailable_Fields.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataCustomer.sql
@..\DB\sql\insDataCustomer.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDelivery_Companies.sql
@..\DB\sql\insDataDelivery_Companies.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataMenuprime_Locations.sql
@..\DB\sql\insDataMenuprime_Locations.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataMenus.sql
@..\DB\sql\insDataMenus.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries2020.sql
@..\DB\sql\insDataDeliveries2020.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries2021.sql
@..\DB\sql\insDataDeliveries2021.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries2022.sql
@..\DB\sql\insDataDeliveries2022.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries_Menus_Consolidado1.sql
@..\DB\sql\insDataDeliveries_Menus_Consolidado1.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries_Menus_Consolidado2.sql
@..\DB\sql\insDataDeliveries_Menus_Consolidado2.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries_Menus_Consolidado3.sql
@..\DB\sql\insDataDeliveries_Menus_Consolidado3.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries_Menus_Consolidado4.sql
@..\DB\sql\insDataDeliveries_Menus_Consolidado4.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataDeliveries_Menus_Consolidado5.sql
@..\DB\sql\insDataDeliveries_Menus_Consolidado5.sql
/

PROMPT Aplicando Objeto ...  @..\DB\sql\insDataCorregirValores.sql
@..\DB\sql\insDataCorregirValores.sql
/

/****************************************************************************************************/
PROMPT ----------------------------------------------------------------
PROMPT Fin de Orquestador_APP_GEST_DOMICILIOS.sql
PROMPT ----------------------------------------------------------------