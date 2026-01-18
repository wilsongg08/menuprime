/************************************************************************************
Description:  Index for FK_CUSTOMER_ID in DELIVERIES table
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE INDEX IDX_FK_CUSTOMER_DELIVERIES ON DELIVERIES (FK_CUSTOMER_ID)
/