package Controller;

import Model.Administrator;
import Model.RegisteredUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 *
 * @author Henry Cullen <119402282%40umail.ucc.ie>
 * 
 * 
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RegisteredUser user = new RegisteredUser();
        user.setPassword("user");
        user.setEmail("user@gmail.com");
        Administrator admin = new Administrator();
        admin.setPassword("admin");
        admin.setEmail("admin@gmail.com");
        
        HttpSession session = request.getSession(true);
        
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        
        System.out.println("");
        
        if(email.equals(user.getEmail()) && pass.equals(user.getPassword())){
            response.setContentType("application/json");
            try (PrintWriter out = response.getWriter()) {
                out.println("user");
            }
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        }
        
        
        if(email.equals(admin.getEmail()) && pass.equals(admin.getPassword())){
            response.setContentType("application/json");
            try (PrintWriter out = response.getWriter()) {
                out.println("admin");
            }
            session.setAttribute("user", admin);
            response.sendRedirect("admin.jsp");
        
        } else {
            response.setContentType("application/json");
            try (PrintWriter out = response.getWriter()) {
                out.println("fail");
            }
            //response.sendRedirect("index.jsp");
            session.setAttribute("user", null);
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
