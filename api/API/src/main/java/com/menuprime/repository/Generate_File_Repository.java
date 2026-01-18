package com.menuprime.repository;

import com.menuprime.model.Dynamic_Query_Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Permite llamar al paquete PKG_GENERATE_DYNAMIC_QUERY y sus funciones dentro de la Base de datos y
 * recuperar la información que estos devuelven.
 * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
 */
@Repository
public class Generate_File_Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Metodo personalizado con JDBC que permite llamar a la función getFILE_INFORMATION en la base de datos y  recuperar el resultado
     * en un arreglo de tipo List<Dynamic_Query_Model>
     * @author Wilson Gomez (wilson.gomez@segurosbolivar.com)
     * @param selectedCompanyId Id de una Delivery_company.
     * @param locationId Id de una Menuprime_locations.
     * @param fromDate Fecha desde la cual se va a filtrar la información
     * @param toDate Fecha hasta la cual se va a filtrar la información
     * @return List<Dynamic_Query_Model>
     */
    public List<Dynamic_Query_Model> callFunction(int selectedCompanyId, int locationId,
                                                  String fromDate, String toDate) {

        // Se define el schema, paquete y función a llamar
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("APP_GEST_DOMICILIOS")
                .withCatalogName("PKG_GENERATE_DYNAMIC_QUERY")
                .withFunctionName("getFILE_INFORMATION");

        // Se mapea la respuesta que viene de la base de datos a través de la clase/modelo "Dynamic_Query_Model"
        call.returningResultSet("result", (rs, rowNum) -> {
            Dynamic_Query_Model obj = new Dynamic_Query_Model();
            obj.setV_locationName(rs.getString("NAME"));
            obj.setV_deliveryAddress(rs.getString("DELIVERY_ADDRESS"));
            obj.setV_deliveryDate(rs.getDate("DELIVERY_DATE" ));
            obj.setV_menu(rs.getString("DESCRIPTION"));
            obj.setV_totalAmount(rs.getInt("TOTAL_AMOUNT"));
            obj.setV_deliveryCost(rs.getInt("DELIVERY_COST"));
            obj.setV_city(rs.getString("CITY"));
            obj.setV_paymentMethod(rs.getString("PAYMENT_METHOD"));
            obj.setV_fullName(rs.getString("FULL_NAME"));
            obj.setV_cellphoneNumber(rs.getLong("CELLPHONE_NUMBER"));
            obj.setV_documentType(rs.getString("DOCUMENT_TYPE"));
            return obj;
        });

        // Se pasan los parametros de entrada que pide la función
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("SELECTEDCOMPANYID", selectedCompanyId)
                .addValue("LOCATIONID", locationId)
                .addValue("FROMDATE", fromDate)
                .addValue("TODATE", toDate);

        Map<String, Object> out = call.execute(in);

        @SuppressWarnings("unchecked")
        List<Dynamic_Query_Model> list = (List<Dynamic_Query_Model>) out.get("result");

        return list;
    }
}

    /*
    comment out
    Otra forma de llamar la función en BD

    private final DataSource datasource;

    @Autowired
    public Generate_File_Repository(DataSource datasource) {
        this.datasource = datasource;
    }

    public List<Dynamic_Query_Model> callFunction2(int selectedCompanyId, int locationId, String fromDate,
                                                   String toDate) throws SQLException {

        List<Dynamic_Query_Model> valores = new ArrayList<Dynamic_Query_Model>();
        Connection conn = datasource.getConnection();
        CallableStatement stmt = conn.prepareCall("{ ? = call PKG_GENERATE_DYNAMIC_QUERY2.GETFILE_INFORMATION2(?,?,?,?)}");

        stmt.registerOutParameter(1, OracleTypes.REF_CURSOR);
        stmt.setInt(2, selectedCompanyId);
        stmt.setInt(3, locationId);
        stmt.setString(4, fromDate);
        stmt.setString(5, toDate);
        stmt.execute();
        System.out.println(stmt.getObject(1));
        ResultSet rs = (ResultSet) stmt.getObject(1);

        System.out.println("Antes while");

        while (rs.next()) {
            System.out.println("Entrando while");
            Dynamic_Query_Model obj = new Dynamic_Query_Model();
            obj.setV_locationName(rs.getString("NAME"));
            obj.setV_deliveryAddress(rs.getString("DELIVERY_ADDRESS"));
            obj.setV_menu(rs.getString("DESCRIPTION"));
            obj.setV_totalAmount(rs.getInt("TOTAL_AMOUNT"));
            obj.setV_deliveryCost(rs.getInt("DELIVERY_COST"));
            obj.setV_city(rs.getString("CITY"));
            obj.setV_paymentMethod(rs.getString("PAYMENT_METHOD"));
            obj.setV_fullName(rs.getString("FULL_NAME"));
            obj.setV_cellphoneNumber(rs.getLong("CELLPHONE_NUMBER"));
            obj.setV_documentType(rs.getString("DOCUMENT_TYPE"));

            System.out.println("Finalizando while por fin!!!!!");
            valores.add(obj);
        }

        System.out.println(valores);
        return valores;

    }
     */
