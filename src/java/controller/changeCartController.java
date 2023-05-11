package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.productDTO;
import shopping.Cart;

public class changeCartController extends HttpServlet {

    public final static String success = "cart.jsp";
    public final static String error = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        try {
            String proId = request.getParameter("id");
            int newQuantity = Integer.parseInt(request.getParameter("quantityChange"));
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            productDTO proCartChange = null;
            for (productDTO dto : cart.getCart().values()) {
                if (dto.getProID().equals(proId)) {
                    proCartChange = new productDTO(proId, dto.getProName(), dto.getPrice(), newQuantity, dto.getPath());
                    break;
                }
            }
            cart.update(proId, proCartChange);
            session.setAttribute("CART", cart);
            url = success;

        } catch (Exception e) {

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
