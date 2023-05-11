package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

public class userDAO {

    private static final String LOGIN = "SELECT * FROM tblUsers WHERE email = ? AND password = ?";

    public userDTO checkLogin(String email, String password) throws SQLException {
        userDTO uslogin = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    String name = rs.getString("name");
                    uslogin = new userDTO(email, name, role, "");
                }
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ptm.close();
            conn.close();
        }

        return uslogin;
    }

}
