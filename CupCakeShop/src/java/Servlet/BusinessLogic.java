/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Data.DataMapper;
import classes.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sanox
 */
@WebServlet(name = "BusinessLogic", urlPatterns = {"/BusinessLogic"})
public class BusinessLogic extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DataMapper dm = new DataMapper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if ("login".equals(action)) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = dm.getUser(username, password);

            if (user == null) {
                //Login fail
                sendLoginForm(request, response);

            } else {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("username", user.getUsername());
                sendStoreFront(request, response);
            }
        }

        User user = (User) request.getSession().getAttribute("user");
        if ("register".equals(action)) {
            String username = request.getParameter("registerUsername");
            String password = request.getParameter("registerPassword");
            dm.registerUser(username, password);
            user = dm.getUser(username, password);
            request.setAttribute("user", user);

            if (user == null) {
                //registration fail
                sendRegisterForm(request, response);
            } else {
                request.getSession().setAttribute("username", user.getUsername());
                sendStoreFront(request, response);
            }
        }
        if (user == null) {
            //Login Fail
            sendLoginForm(request, response);
        }
        if (action == null) {
            
            sendStoreFront(request, response);
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

    private void sendStoreFront(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            RequestDispatcher rd = request.getRequestDispatcher("storeFront.jsp");
            rd.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getMessage();
        }
    }

    private void sendLoginForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getMessage();
        }
    }

    private void sendRegisterForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("registerUser.html");
            rd.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getMessage();
        }
    }

}
