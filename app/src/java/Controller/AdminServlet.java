/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BootDAO;
import DAO.UserDAO;
import Model.Boot;
import Model.BootFactory;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author culle
 */
public class AdminServlet extends HttpServlet {

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

        String page = "";
        if(request.getParameter("page") != null){
            page = request.getParameter("page");
        }

        if(page.equals("users")){
            UserDAO uDao = UserDAO.getInstance();
            ArrayList<User> allUsers = uDao.loadAll();
            request.setAttribute("allUsers", allUsers);
            RequestDispatcher rd=request.getRequestDispatcher("./admin-pages/users.jsp");  
            rd.forward(request, response);//method may be include or forward  
        }else if (page.equals("boots")){
            RequestDispatcher rd=request.getRequestDispatcher("./admin-pages/boots.jsp");  
            rd.forward(request, response);//method may be include or forward  
        }
        
        if(request.getParameter("class") != null){
            if(request.getParameter("class").equals("boot")){
                if(request.getParameter("action") != null){
                    if(request.getParameter("action").equals("save")){
                        if(request.getParameter("id") !=null  
                            && request.getParameter("name") !=null 
                            && request.getParameter("description") !=null 
                            && request.getParameter("boottype") !=null 
                            && request.getParameter("size") !=null 
                            && request.getParameter("color") !=null 
                            && request.getParameter("price") !=null 
                            && request.getParameter("brand") !=null){
                         
                            int code = Integer.parseInt(request.getParameter("id")); 
                            String name = request.getParameter("name"); 
                            String description = request.getParameter("description"); 
                            String type = request.getParameter("boottype"); 
                            int size  = Integer.parseInt(request.getParameter("size")); 
                            String color = request.getParameter("color"); 
                            double price = Double.parseDouble(request.getParameter("price")); 
                            String brand = request.getParameter("brand");     
                            
                            BootFactory bootMaker = new BootFactory();
                            Boot newBoot = bootMaker.createBoot(code, name, type, description, size, color, price, brand);
                            BootDAO bDao = BootDAO.getInstance();
                            ArrayList<Boot> newList=bDao.update(newBoot);
                            ServletContext context = getServletContext();
                            
                            context.setAttribute("bootsList", newList);
                        }
                    }else if(request.getParameter("action").equals("add")){
                        if(request.getParameter("name") !=null 
                            && request.getParameter("description") !=null 
                            && request.getParameter("boottype") !=null 
                            && request.getParameter("size") !=null 
                            && request.getParameter("color") !=null 
                            && request.getParameter("price") !=null 
                            && request.getParameter("brand") !=null){
                            
                            int code; 
                            String name = request.getParameter("name"); 
                            String description = request.getParameter("description"); 
                            String type = request.getParameter("boottype"); 
                            int size  = Integer.parseInt(request.getParameter("size")); 
                            String color = request.getParameter("color"); 
                            double price = Double.parseDouble(request.getParameter("price")); 
                            String brand = request.getParameter("brand");     
                            
                            BootDAO bDao = BootDAO.getInstance();
                            code = bDao.getNewCode();
                            
                            
                            BootFactory bootMaker = new BootFactory();
                            Boot newBoot = bootMaker.createBoot(code, name, type, description, size, color, price, brand);
                            newBoot.setCode(code);
                            System.out.println(newBoot);
                            ArrayList<Boot> newList=bDao.create(newBoot);
                            ServletContext context = getServletContext();
                            
                            context.setAttribute("bootsList", newList);
                            
                        }
                    }else if(request.getParameter("action").equals("delete")){
                        if(request.getParameter("id")!= null){
                            
                            int code = Integer.parseInt(request.getParameter("id"));    
                            
                            BootDAO bDao = BootDAO.getInstance();
                            BootFactory bootMaker = new BootFactory();
                            
                            ArrayList<Boot> newList=bDao.deleteById(code);
                            ServletContext context = getServletContext();
                            
                            context.setAttribute("bootsList", newList);
                            
                        }
                    }
                    
                }
                response.sendRedirect("./admin?page=boots");
            }else if (request.getParameter("class").equals("user")){
                if(request.getParameter("action") != null){
                    if(request.getParameter("action").equals("save")){
                        if(request.getParameter("id") !=null
                            && request.getParameter("name") !=null
                            && request.getParameter("eircode") !=null
                            && request.getParameter("password") !=null
                            && request.getParameter("type") !=null){

                            String email = request.getParameter("id");
                            String fullName = request.getParameter("name");
                            String eircode = request.getParameter("eircode");
                            String type =  request.getParameter("type");
                            String password =  request.getParameter("password");

                            User newUsr = new User();
                            newUsr.setEmail(email);
                            newUsr.setFullName(fullName);
                            newUsr.setEircode(eircode);
                            newUsr.setPassword(password);
                            newUsr.setType(type);
                            
                            UserDAO uDao = UserDAO.getInstance();
                           uDao.update(newUsr);
                        }
                    }else if(request.getParameter("action").equals("add")){
                        if(request.getParameter("id") !=null
                            && request.getParameter("name") !=null
                            && request.getParameter("eircode") !=null
                            && request.getParameter("password") !=null
                            && request.getParameter("type") !=null){
                            
                            String email = request.getParameter("id");
                            String fullName = request.getParameter("name");
                            String eircode = request.getParameter("eircode");
                            String type =  request.getParameter("type");
                            String password =  request.getParameter("password");

                            User newUsr = new User();
                            newUsr.setEmail(email);
                            newUsr.setFullName(fullName);
                            newUsr.setEircode(eircode);
                            newUsr.setPassword(password);
                            newUsr.setType(type);
                            UserDAO uDao = UserDAO.getInstance();
                            uDao.create(newUsr);
                        }
                    }else if(request.getParameter("action").equals("delete")){
                        if(request.getParameter("id")!= null){
                            String email = request.getParameter("id");    
                            
                            UserDAO uDao = UserDAO.getInstance();
                            ArrayList<User> newList=uDao.deleteById(email);
                        }
                    }
                }
                response.sendRedirect("./admin?page=users");
            }
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
