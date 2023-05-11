package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.productDAO;
import product.productDTO;
import shopping.Cart;
import user.userDAO;
import user.userDTO;

public class loginController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            userDAO dao = new userDAO();
            userDTO us = dao.checkLogin(email, pass);
            if (us != null) {
                HttpSession session = request.getSession();
                session.setAttribute("LOGIN_USER", us);
                if(us.getRole().equals("US")){
                    url = SUCCESS;
                } else if(us.getRole().equals("AD")){
                    url = "admin.jsp";
                }
                

                Cart cart = (Cart) session.getAttribute("CART");
                product.productDAO daopro = new productDAO();
                List<productDTO> cartget = new ArrayList();
                cartget = daopro.cart(email);
                if (cart == null) {
                    cart = new Cart();
                    if (cartget.size() != 0) {
                        for (productDTO dTO : cartget) {
                            cart.add(dTO);
                        }
                        session.setAttribute("CART", cart);
                    } else if (cartget == null) {
                        cart = new Cart();
                        session.setAttribute("CART", cart);
                    }
                } else {
                    if (cartget.size() != 0) {
                        for (int i = 0; i < cartget.size(); i++) {
                            cart.add(cartget.get(i));
                        }
                        session.setAttribute("CART", cart);
                    } else {
                        session.setAttribute("CART", cart);
                    }
                }

            }

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
