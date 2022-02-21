package Util;

import DAO.BootDAO;
import static DAO.BootDAO.getInstance;
import Data.PopulateDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author culle
 */
public class DBContextListener implements ServletContextListener {

 
//    @Override
//    public void contextInitialized(ServletContextEvent event) {
//
//        initDb(event);
//        
//        ServletContext context = event.getServletContext();
//        
//        //setting application paths for images
//        String pathWork = context.getRealPath("/assets/product-images/");
//        String sep = System.getProperty("file.separator");
//        Path buildImages = Paths.get(pathWork);
//        Path srcImages = Paths.get(pathWork, sep,"..",sep,"..",sep, "..", sep, "..", "web", "assets", "product-images");
//        srcImages    = srcImages.normalize();
//        
//        context.setAttribute("srcImages", srcImages);
//        context.setAttribute("buildImages", buildImages);
//        //setting email
//        context.setAttribute("Email", context.getInitParameter("Email"));
//        System.out.println(buildImages);
//        System.out.println(srcImages);
//        
//    }
//
//    public void initDb(ServletContextEvent event){
//        ServletContext context = event.getServletContext();
//        PopulateDb data = new PopulateDb();
//        data.createTables();
//        data.insertData();
//        BootDAO bDao = getInstance();
//        context.setAttribute("bootsList", bDao.loadAll());
//        
//    }
//    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // no cleanup necessary
    }
}
