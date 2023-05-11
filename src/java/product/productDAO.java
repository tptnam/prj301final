package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class productDAO {

    private static final String get2lightpro = "Select * from tblFeaturedProducts";
    private static final String getall = "Select * from tblProducts where status = '1'";
    private static final String getprobyid = "Select * from tblProducts where proId = ?";
    private static final String search = "Select * from tblProducts where proId = ?";
    private static final String getforUser = "Select CartID, tblCart.proID, tblCart.quantity, proName, price, img from tblCart join tblProducts on (tblProducts.proId = tblCart.proID) and email =?";
    private static final String updatepro = "UPDATE tblProducts SET proName=?, price=?, information =?, quantity=?, img=?, status=? WHERE proId = ?;";

    public List<productDTO> get2lightpro() throws ClassNotFoundException, SQLException {
        List<productDTO> list = new ArrayList();
        productDTO pro = new productDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        conn = DBUtils.getConnection();
        try {
            if (conn != null) {
                ptm = conn.prepareStatement(get2lightpro);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proId");
                    String name = rs.getString("proName");
                    Float price = rs.getFloat("price");
                    String imgpath = rs.getString("img");
                    pro = new productDTO(proID, name, price, imgpath);
                    list.add(pro);
                }
            }
        } catch (SQLException e) {

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
        return list;
    }

    public List<productDTO> getall() throws ClassNotFoundException, SQLException {
        List<productDTO> list = new ArrayList();
        productDTO pro = new productDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getall);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proId");
                    String name = rs.getString("proName");
                    Float price = rs.getFloat("price");
                    String infor = rs.getString("information");
                    int quantity = rs.getInt("quantity");
                    String imgpath = rs.getString("img");
                    boolean status = rs.getBoolean("status");
                    
                    pro = new productDTO(proID, name, price, infor, quantity, imgpath, status);
                    list.add(pro);
                }
            }
        } catch (SQLException e) {

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
        return list;
    }

    public productDTO searchPro(String id) throws ClassNotFoundException, SQLException {
        productDTO pro = new productDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(search);
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String proID = rs.getString("proId");
                    String name = rs.getString("proName");
                    Float price = rs.getFloat("price");
                    String imgpath = rs.getString("img");
                    pro = new productDTO(proID, name, price, imgpath);
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

        return pro;
    }

    public List<productDTO> cart(String email) throws ClassNotFoundException, SQLException {
        List cart = new ArrayList();
        productDTO pro = new productDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getforUser);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("proID");
                    String name = rs.getString("proName");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String path = rs.getString("img");
                    pro = new productDTO(id, name, price, quantity, path);
                    cart.add(pro);
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

        return cart;
    }

    public productDTO getproid(String id) throws ClassNotFoundException, SQLException {
        productDTO pro = new productDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getprobyid);
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proId");
                    String name = rs.getString("proName");
                    Float price = rs.getFloat("price");
                    String infor = rs.getString("information");
                    int quantity = rs.getInt("quantity");
                    String imgpath = rs.getString("img");
                    boolean status = rs.getBoolean("status");
                    pro = new productDTO(proID, name, price, infor, quantity, imgpath, status);
                }
            }
        } catch (SQLException e) {

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
        return pro;
    }

    public boolean update(productDTO pro) throws SQLException {

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(updatepro);
                ptm.setString(1, pro.getProName());
                ptm.setFloat(2, pro.getPrice());
                ptm.setString(3, pro.getInfor());
                ptm.setInt(4, pro.getQuantity());
                ptm.setString(5, pro.getPath());
                ptm.setBoolean(6, pro.isStatus());
                ptm.setString(7, pro.getProID());
                check = ptm.execute();

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

            return check;

        }

    }
}
