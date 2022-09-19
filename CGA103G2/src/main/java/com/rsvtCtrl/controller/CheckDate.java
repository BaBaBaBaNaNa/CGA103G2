package com.rsvtCtrl.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rsvtCtrl.model.RsvtCtrlDAOImpl;
import com.rsvtCtrl.model.RsvtCtrlService;
import com.rsvtCtrl.model.RsvtCtrlVO;
@WebServlet("/back-end/reservation_ctrl/Date")
public class CheckDate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("fetch");
		Gson gson = new Gson();
		RsvtCtrlDAOImpl dao = new RsvtCtrlDAOImpl();
		List<RsvtCtrlVO> list = dao.getAll();
		List<String> date = new ArrayList<String>();
		for(RsvtCtrlVO obj : list) {
			if(obj.getRsvtCtrlOpen() == 1 && obj.getRsvtCtrlPeriod() == 0) {
//				System.out.println(obj.getRsvtCtrlDate());
				for(RsvtCtrlVO obj2 : list) {
					if(obj.getRsvtCtrlDate().toString().equals(obj2.getRsvtCtrlDate().toString()) && obj2.getRsvtCtrlOpen() == 1 && obj2.getRsvtCtrlPeriod() != obj.getRsvtCtrlPeriod()) {
							date.add(obj2.getRsvtCtrlDate().toString());
					}
				}
			}
		}
//		System.out.println(date.size());
		res.getWriter().append(gson.toJson(date));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
