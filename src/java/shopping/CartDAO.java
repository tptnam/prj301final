package shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import product.productDTO;
import utils.DBUtils;

public class CartDAO {

    private static final String checkCart = "Select * from tblCart where email = ?";
    private static final String getMaxCartID = "Select MAX(CartID) from tblCart";
    private static final String insertCart = "insert into tblCart (CartID, proID, email, quantity) values(?,?,?,?)";
    private static final String delete = "delete from tblCart where email = ?";
    private static final String update = "update tblCart set quantity =? where CartID = ? and proID=?";

    public void insertCart(productDTO pro, String email) throws SQLException {

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String cartid = "";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(checkCart);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                List<productDTO> idnotfound = new ArrayList();
                if (rs.next()) { // update if product in cart exist

                    cartid = rs.getString("CartID");
                    String proID = rs.getString("proID");
                    productDTO producttemp = new productDTO(proID, rs.getInt("quantity"));
                    idnotfound.add(producttemp);
                    if (pro.getProID().equals(proID)) {
                        ptm = conn.prepareStatement(update);
                        int quantity = pro.getQuantity();
                        ptm.setInt(1, quantity);
                        ptm.setString(2, cartid);
                        ptm.setString(3, proID);
                        ptm.execute();
                        idnotfound.remove(producttemp);
                    }
                } else {
                    while (!idnotfound.isEmpty()) {
                        int i = 0;
                        String proid = idnotfound.get(i).getProID();
                        int quantity = idnotfound.get(i).getQuantity();
                        ptm = conn.prepareStatement(insertCart);
                        ptm.setString(1, cartid);
                        ptm.setString(2, proid);
                        ptm.setString(3, email);
                        ptm.setInt(4, quantity);
                        ptm.execute();
                        i++;
                    }
                }  
            }
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
    }

}
