/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package delegation.controller;

import delegation.model.Miscreant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AlterMiscreant implements Logic {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Miscreant mc = MiscreantDAO.getMiscreant(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("mc", mc);
        request.setAttribute("isNew", false);
        
        return "MiscreantRegister.jsp";
        
    }
    
}
