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
import javax.servlet.RequestDispatcher;
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
        
        String addCode ="";
        if(request.getParameter("add") != null){
            addCode = request.getParameter("add");
        }
        String changeCode ="";
        String quantity ="";
        if(request.getParameter("change") != null && request.getParameter("quantity")!= null){
            changeCode = request.getParameter("change");
            quantity = request.getParameter("quantity");
        }
        String remCode = "";
        if(request.getParameter("remove") != null){
            remCode = request.getParameter("remove");
        }
        HttpSession session = request.getSession(true);
        ServletContext application = getServletContext();
        User currentUser = (User)session.getAttribute("SESSION_USER");

        String type = "";
        if(currentUser!=null){
            type = currentUser.getType();
        }
        if( (!addCode.isBlank()) && type.equals("USER")){
            try{
                int code = Integer.parseInt(addCode);
                ArrayList<Boot> bootList = (ArrayList<Boot>)application.getAttribute("bootsList");
                BootUtil bootWorker = new BootUtil(bootList);
                Boot newBoot = bootWorker.getBootByCode(code);
                if(newBoot != null){
                    currentUser.getTrolley().addBoot(newBoot);
                }
                response.sendRedirect("./trolley.jsp");
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                request.setAttribute("message", new String[]{"invalid","The code reffernced is invalid."});
                request.getRequestDispatcher("boots.jsp").forward(request, response);
            }
        } else if((!remCode.isBlank()) && type.equals("USER")){
            try{
                int code = Integer.parseInt(remCode);
                ArrayList<Boot> bootList = (ArrayList<Boot>)application.getAttribute("bootsList");
                BootUtil bootWorker = new BootUtil(bootList);
                Boot removalBoot = bootWorker.getBootByCode(code);
                if(removalBoot != null){
                    currentUser.getTrolley().removeBoot(removalBoot);
                }
                response.sendRedirect("./trolley.jsp");
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                request.setAttribute("message", new String[]{"invalid","The code reffernced is invalid."});
                request.getRequestDispatcher("boots.jsp").forward(request, response);
            }
         } else if((!changeCode.isBlank() && !quantity.isBlank()) && type.equals("USER")){
            try{
                int code = Integer.parseInt(changeCode);
                int quant = Integer.parseInt(quantity);
                ArrayList<Boot> bootList = (ArrayList<Boot>)application.getAttribute("bootsList");
                BootUtil bootWorker = new BootUtil(bootList);
                Boot bootOfChange = bootWorker.getBootByCode(code);
                
                if(bootOfChange != null && quant>0){
                    currentUser.getTrolley().setBootQuantity(bootOfChange, quant);
                }
                response.sendRedirect("./trolley.jsp");
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                request.setAttribute("message", new String[]{"invalid","The code or quantity refferenced is invalid."});
                request.getRequestDispatcher("boots.jsp").forward(request, response);

            }
        } else { 

            request.setAttribute("message", new String[]{"invalid","You must be logged in as a user to put items in your trolley."});
            request.getRequestDispatcher("boots.jsp").forward(request, response);
        } 

                
        //code needed to tell user their checkout was successful and add their items ti the databas
//                request.setAttribute("message", new String[]{"success", "Your order has been successful"});e
        //move to order History array and create a method on the user that listens to chanegs in the array and writes them to the database
        //write the changes of trolley to the database too.
                
        
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
