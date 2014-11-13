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
public class MiscreantList implements Logic {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List<Miscreant> list = MiscreantDAO.getMiscreantList(MiscreantDAO.QueryType.FullList);
        request.setAttribute("mclist", list);
        
        return "MiscreantList.jsp";
        
    }

}
