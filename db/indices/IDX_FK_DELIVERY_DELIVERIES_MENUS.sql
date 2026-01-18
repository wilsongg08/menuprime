/************************************************************************************
Description:  Index for FK_CUSTOMER_ID in DELIVERIES_MENUS table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE INDEX IDX_FK_DELIVERY_DELIVERIES_MENUS ON DELIVERIES_MENUS (FK_DELIVERY_ID)
/