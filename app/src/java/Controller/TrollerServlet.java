/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Boot;
import Model.User;
import Util.BootUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author culle
 */
public class TrollerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
                String addCode = request.getParameter("add");
                HttpSession session = request.getSession(true);
                ServletContext application = getServletContext();
                User currentUser = (User)session.getAttribute("SESSION_USER");
                
                if( (!addCode.equals("") && addCode !=null) && currentUser.getType().equals("USER")){
                    try{
                        int code = Integer.parseInt(addCode);
                        ArrayList<Boot> bootList = (ArrayList<Boot>)application.getAttribute("bootsList");
                        BootUtil bootWorker = new BootUtil(bootList);
                        Boot newBoot = bootWorker.getBootByCode(code);
                        if(newBoot != null){
                            System.out.println(currentUser.getTrolley());
                            currentUser.getTrolley().addBoot(newBoot);
                        }
                    }
                    catch (NumberFormatException ex){
                        ex.printStackTrace();
//            <script defer>
//                alert("Invalid Product code");
//            </script>
// send user the error and redirect them to the product page.
                    }
                } else { 
                    //send user the error that they were not loggedin and redirect to product page
//            <script defer>
//                alert("You must be logged in as a user to add to your trolley");
//            </script>
                } 
        try ( PrintWriter out = response.getWriter()) {
            
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
