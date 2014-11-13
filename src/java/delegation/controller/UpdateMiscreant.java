/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package delegation.controller;

import delegation.model.Miscreant;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UpdateMiscreant implements Logic {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Miscreant mc = new Miscreant();
        
        mc.setId(Integer.parseInt(request.getParameter("id")));
        mc.setName(request.getParameter("name"));
        mc.setCpf(request.getParameter("cpf"));
        mc.setAddress(request.getParameter("addr"));
        mc.setCrime(request.getParameter("crime"));
        mc.setCrimeLocation(request.getParameter("crimeLocation"));
        mc.setCrimeDate(Date.valueOf(request.getParameter("crimeDate")));
        mc.setCrimeTime(request.getParameter("crimeTime"));
        mc.setState(request.getParameter("state"));
        mc.setPicture(request.getParameter("picture"));
        
        MiscreantDAO.updateMiscreant(mc);
        
        List<Miscreant> list = MiscreantDAO.getMiscreantList(MiscreantDAO.QueryType.FullList);
        request.setAttribute("mclist", list);
        
        return "MiscreantList.jsp";
        
    }

}
