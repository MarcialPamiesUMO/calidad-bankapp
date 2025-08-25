package com.example.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRepository {

    // Simulados para ejemplo; no se va a conectar realmente
    private final String url = "jdbc:h2:mem:testdb";
    private final String user = "sa";
    private final String password = "";

    public String findFullNameByUsername(String username) throws Exception {
        // Regla java:S2077: SQL injection (concatenación directa)
        String sql = "SELECT full_name FROM users WHERE username = '" + username + "'";

        // Regla java:S2095: recursos no cerrados (Connection/Statement/ResultSet)
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        String result = null;
        if (rs.next()) {
            result = rs.getString("full_name");
        }

        // Intencionado: NO cerrar rs, st ni conn para que Sonar lo marque
        return result;
    }
}
