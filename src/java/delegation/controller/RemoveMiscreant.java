    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package delegation.controller;

import delegation.model.Miscreant;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RemoveMiscreant implements Logic {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        MiscreantDAO.deleteMiscreant(id);
        
        List<Miscreant> list = MiscreantDAO.getMiscreantList(MiscreantDAO.QueryType.FullList);
        request.setAttribute("mclist", list);
        
        return "MiscreantList.jsp";
        
    }

}
