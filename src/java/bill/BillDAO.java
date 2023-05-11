package bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.productDTO;
import user.userDTO;
import utils.DBUtils;

public class BillDAO {

    private static final String insertBill = "INSERT into tblBill(BillID, name, email, address,note, status, proID, phone, quantity) values(?,?,?,?,?,?,?,?,?)";
    private static final String getMaxBillID = "select max(BillID) as maxid from tblBill";
    private static final String delete = "delete from tblCart where email = ?";

    public boolean insertBill(BillDTO bill, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;

        PreparedStatement ptm = null;

        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        conn = DBUtils.getConnection();

        HttpSession session = request.getSession();
        userDTO usLogin = (userDTO) session.getAttribute("LOGIN_USER");

        try {
            if (conn != null) {

                if (usLogin != null) {
                    String email = usLogin.getEmail();
                    ptm = conn.prepareStatement(delete);
                    ptm.setString(1, email);
                    ptm.execute();
                }
            }

            ptm = conn.prepareStatement(insertBill);
            ptm.setString(1, "4");
            ptm.setString(2, bill.getName());
            ptm.setString(3, bill.getEmail());
            ptm.setString(4, bill.getAddress());
            ptm.setString(5, bill.getNote());
            ptm.setBoolean(6, true);
            ptm.setString(7, bill.getProID());
            ptm.setString(8, bill.getPhone());
            ptm.setInt(9, bill.getQuantity());
            ptm.execute();

        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
