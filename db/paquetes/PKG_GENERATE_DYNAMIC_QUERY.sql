create or replace PACKAGE PKG_GENERATE_DYNAMIC_QUERY IS
/************************************************************************************
Description: 	This package gathers all procedures related with elaborating the dynamic query 
				needed to obtain the information to generate the file
Author:       	Wilson Gómez
Date:       	14-12-2022
ManagementId:   GB48-14
@copyright: 	Seguros Bolivar
------------------------------------------------------------------------------------
History of modifications=>
Date			ManagementId		Person					Action        
------------------------------------------------------------------------------------
14-12-2022		GB48-14				Wilson Gómez			Creation 
************************************************************************************/

    /* Public data type declaration 
     

    /* Declaration of public variables */


    /* Declaration of public methods and functions */

    /************************************************************************************
	Description: 	Procedure in charge of elaborate the dynamic query needed to generate the file
	Author:       	Wilson Gómez
	Date:       	14-12-2022
	ManagementId:   GB48-14
	@copyright: 	Seguros Bolivar
	------------------------------------------------------------------------------------
	History of modifications=>
	Date			ManagementId		Person					Action        
	------------------------------------------------------------------------------------
	14-12-2022		GB48-14				Wilson Gómez			Creation 
	************************************************************************************/
	    
    FUNCTION getFILE_INFORMATION (selectedCompanyId NUMBER,
                                    locationId NUMBER,
                                    fromDate VARCHAR2,
                                    toDate VARCHAR2) 
                                    RETURN SYS_REFCURSOR;
                                    
   
END PKG_GENERATE_DYNAMIC_QUERY;