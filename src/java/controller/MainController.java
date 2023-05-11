/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "loginController";
    private static final String SEARCH = "search";
    private static final String SEARCH_CONTROLLER = "searchController";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "deleteController";
    private static final String UPDATE = "update";
    private static final String UPDATE_CONTROLLER = "updateController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "logoutController";
    private static final String ADD = "Add";
    private static final String ADD_CONTROLLER = "addTocCartController";
    private static final String SEARCHPRICE = "searchByPrice";
    private static final String SEARCHPRICE_CONTROLLER = "searchByPrice";
    private static final String INSERT = "insert";
    private static final String INSERT_CONTROLLER = "insertController";
    private static final String CHANGE = "change";
    private static final String CHANGE_CONTROLLER = "changeCartController";
    private static final String REMOVE = "remove";
    private static final String REMOVE_CONTROLLER = "removeProCartController";
    private static final String SINGLE = "singlePro";
    private static final String SINGLE_CONTROLLER = "singleProController";
    private static final String insertBill = "SUBMIT";
    private static final String add_Bill_Controller = "addBillController";
    private static final String loadpro = "load";
    private static final String loadpro_controller = "loadPro";
    private static final String edit = "edit";
    private static final String loadproedit_controller = "loadProEdit";
    private static final String editDone = "Done";
    private static final String update_pro = "updatePro";
    private static final String addnewpro = "AddNew";
    private static final String addnewcontroller = "addnewcontroller";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (null == action) {
                request.setAttribute("ERROR", "Your action is not supported!");
            } else {
                switch (action) {
                    case LOGIN:
                        url = LOGIN_CONTROLLER;
                        break;
                    case SEARCH:
                        url = SEARCH_CONTROLLER;
                        break;
                    case DELETE:
                        url = DELETE_CONTROLLER;
                        break;
                    case UPDATE:
                        url = UPDATE_CONTROLLER;
                        break;
                    case LOGOUT:
                        url = LOGOUT_CONTROLLER;
                        break;
                    case ADD:
                        url = ADD_CONTROLLER;
                        break;
                    case CHANGE:
                        url = CHANGE_CONTROLLER;
                        break;
                    case SEARCHPRICE:
                        url = SEARCHPRICE_CONTROLLER;
                        break;
                    case INSERT:
                        url = INSERT_CONTROLLER;
                        break;
                    case REMOVE:
                        url = REMOVE_CONTROLLER;
                        break;
                    case SINGLE:
                        url = SINGLE_CONTROLLER;
                        break;
                    case insertBill:
                        url = add_Bill_Controller;
                        break;
                    case loadpro:
                        url = loadpro_controller;
                        break;
                    case edit:
                        url = loadproedit_controller;
                        break;
                    case editDone:
                        url = update_pro;
                        break;
                    case addnewpro:
                        url = addnewcontroller;
                        break;

                }
            }
        } catch (Exception ex) {
            log("Error at: MainController" + ex.toString());
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
