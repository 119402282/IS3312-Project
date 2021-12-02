package Util;

import Model.Boot;
import java.util.ArrayList;

import static data.BootIO.getAllBoots;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

public class HikersDelightContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {

        ServletContext context = event.getServletContext();
        String bootsFile = context.getRealPath("/WEB-INF/boots.txt");
        context.setAttribute("path", bootsFile);
        context.setAttribute("bootsList", getAllBoots( bootsFile));
        context.setAttribute("Email", context.getInitParameter("Email"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // no cleanup necessary
    }
}
