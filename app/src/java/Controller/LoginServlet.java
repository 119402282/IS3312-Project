package Controller;

import Model.Administrator;
import Model.RegisteredUser;
import static Util.LoginUtil.approveLogin;
import static Util.LoginUtil.loginType;
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
        
        String resultType;
        if(approveLogin(email, pass, user)){
            session.setAttribute("user", user);
            resultType = loginType(user);
        } else if(approveLogin(email, pass, admin)){
            session.setAttribute("user", admin);
            resultType = loginType(admin);
        } else {
            session.setAttribute("user", null);
            resultType = loginType(null);
            email = null;
        }
        email = email==null? null : "\""+email +"\"";
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
                out.println("{\n"
                        + "\"email\": " + email + ",\n"
                        + "\"type\": " + resultType + "\n"
                        + "}");
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
