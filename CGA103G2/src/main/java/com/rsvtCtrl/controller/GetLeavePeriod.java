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

@WebServlet("/back-end/reservation_ctrl/getCtrlPeriod")
public class GetLeavePeriod extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("fetch");
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(req.getReader(), JsonObject.class);
		String date = jsonObject.get("date").toString().replace("\"", "");
		List<RsvtCtrlVO> list = new RsvtCtrlService().getOneDate(date);
		String[] arr = {"0","1"};
		if(list.size() == 0) {
			res.getWriter().append(gson.toJson(arr));
		}else if(list.size() != 2 && list.size() > 0	){
			List<String> period = new ArrayList<>();
			for(RsvtCtrlVO obj : list) {
				if(obj.getRsvtCtrlPeriod() == 0) {
					period.add("1");
				}else {
					period.add("0");
				}
			}
			res.getWriter().append(gson.toJson(period));
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
