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

@WebServlet("/back-end/reservation_ctrl/getPeriod")
public class GetPeriod extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("fetch");
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(req.getReader(), JsonObject.class);
		String date = jsonObject.get("date").toString().replace("\"", "");
		String period = jsonObject.get("rsvtPeriod").toString();
		System.out.println(date);
		System.out.println(period);
		List<RsvtCtrlVO> list = new RsvtCtrlService().getOneDate(date);
		Integer leave = Integer.valueOf(jsonObject.get("rsvtNum").toString());
		for (RsvtCtrlVO obj : list) {
			if (obj.getRsvtCtrlPeriod().toString() == period) {
				leave = obj.getRsvtCtrlMax() - obj.getRsvtCtrlNumber();
			}
		}
		System.out.println(leave);
		res.getWriter().append(gson.toJson(leave));
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
