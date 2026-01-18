create or replace PACKAGE BODY PKG_GENERATE_DYNAMIC_QUERY IS

/***********************************************************************************/
	FUNCTION getFILE_INFORMATION (selectedCompanyId IN NUMBER,
    								locationId IN NUMBER,
    								fromDate IN VARCHAR2,
                                    toDate IN VARCHAR2) 
                                    RETURN SYS_REFCURSOR
    	IS 
            l_cursor SYS_REFCURSOR;
   		 		
 -- d.DELIVERY_DATE,    	
    	BEGIN               
            
            OPEN l_cursor FOR
                        SELECT 
                            ml.NAME, c.DELIVERY_ADDRESS, d.DELIVERY_DATE, LISTAGG(m.DESCRIPTION, '/') DESCRIPTION, d.TOTAL_AMOUNT, 
                            d.DELIVERY_COST, ml.CITY, d.PAYMENT_METHOD, c.FULL_NAME, c.CELLPHONE_NUMBER, c.DOCUMENT_TYPE
                        FROM 
                            DELIVERIES d
						JOIN 
                            MENUPRIME_LOCATIONS ml ON ml.MENUPRIME_LOCATION_ID= d.FK_MENUPRIME_LOCATIONS_ID
						JOIN 
                            CUSTOMERS c ON c.CUSTOMER_ID = d.FK_CUSTOMER_ID 
						JOIN 
                            DELIVERIES_MENUS dm ON dm.FK_DELIVERY_ID = d.DELIVERY_ID 
						JOIN 
                            MENUS m ON m.MENU_ID = dm.FK_MENU_ID
						JOIN 
                            DELIVERY_COMPANIES dc ON dc.DELIVERY_COMPANY_ID = d.FK_DELIVERY_COMPANY_ID				 
                        WHERE 
                            dc.DELIVERY_COMPANY_ID = selectedCompanyId
                            AND d.FK_MENUPRIME_LOCATIONS_ID = locationId 
                            AND d.DELIVERY_DATE BETWEEN TO_DATE(fromDate, 'DD/MM/YY') AND TO_DATE(toDate,'DD/MM/YY')
                        GROUP BY 
                            ml.NAME, c.DELIVERY_ADDRESS, d.DELIVERY_DATE, d.TOTAL_AMOUNT, d.DELIVERY_COST,  
                            ml.CITY, d.PAYMENT_METHOD, c.FULL_NAME, c.CELLPHONE_NUMBER, c.DOCUMENT_TYPE;
            RETURN l_cursor;
	   
	    END getFILE_INFORMATION;
/***********************************************************************************/
END PKG_GENERATE_DYNAMIC_QUERY;