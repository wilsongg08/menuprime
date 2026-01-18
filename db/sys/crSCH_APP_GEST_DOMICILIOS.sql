/************************************************************************************
Description:  Creation of schema APP_GEST_DOMICILIOS
Author:       Wilson Gómez (wilson.gomez@segurosbolivar.com)
Date:         28-11-2022
ManagementId: GB48-12
@copyright:   Seguros Bolivar
************************************************************************************/

CREATE USER APP_GEST_DOMICILIOS IDENTIFIED BY oracle;
GRANT CONNECT,RESOURCE,dba TO APP_GEST_DOMICILIOS;
GRANT UNLIMITED TABLESPACE TO APP_GEST_DOMICILIOS;
ALTER PROFILE DEFAULT LIMIT PASSWORD_REUSE_TIME UNLIMITED;
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;
