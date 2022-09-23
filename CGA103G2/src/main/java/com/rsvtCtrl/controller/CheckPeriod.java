package com.rsvtCtrl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rsvtCtrl.model.RsvtCtrlService;
import com.rsvtCtrl.model.RsvtCtrlVO;

@WebServlet("/back-end/reservation_ctrl/Period")
public class CheckPeriod extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//	System.out.println("fetch");
	Gson gson = new Gson();
    JsonObject jsonObject = gson.fromJson(req.getReader(), JsonObject.class);
    String date = jsonObject.get("rsvtCtrlDate").toString().replace("\"", "");
    Integer num = 0;
    try {
        num = Integer.valueOf(jsonObject.get("rsvtNum").toString().replace("\"", ""));
	} catch (Exception ignore) {
	}
//    System.out.println(date);
        List<RsvtCtrlVO> list = new RsvtCtrlService().getOneDate(date);
        System.out.println(list.size());
        List<Integer> Period = new ArrayList<>();
        if(list.size() != 0) {
      	  for(RsvtCtrlVO obj : list) {
      		  System.out.println(obj.getRsvtCtrlPeriod());
      		  if(obj.getRsvtCtrlOpen() == 0){
      			  Period.add(obj.getRsvtCtrlPeriod());
      			  Period.add(num + obj.getRsvtCtrlMax() - obj.getRsvtCtrlNumber());
      			  }
      	  }
        }
        System.out.println(Period.size());
		res.getWriter().append(gson.toJson(Period));
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
