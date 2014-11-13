/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package delegation.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet("/mvc")
public class Controller extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String param = request.getParameter("logic");
        String className = "delegation.controller." + param;
        
        try {
            
            Class classe = Class.forName(className);
            
            Logic logic = (Logic) classe.newInstance();
            String page = logic.execute(request, response);
            
            request.getRequestDispatcher(page).forward(request, response);

        } catch (Exception ex) {
            response.getWriter().print(ex);
            response.getWriter().print(Arrays.toString(ex.getStackTrace()));
        }
        
    }

}
