package com.rsvt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rsvt.model.RsvtService;
import com.rsvt.model.RsvtVO;

@WebServlet("/back-end/reservation/Search")
public class RsvtSearch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("fetch");
    res.setHeader("content-type", "text/html;charset=UTF-8");
	Gson gson = new Gson();
	JsonObject jsonObj = gson.fromJson(req.getReader(), JsonObject.class);
	String cName = jsonObj.get("cName").toString().replace("\"", "");
	RsvtService rsvtSvc = new RsvtService();
	List<RsvtVO> list = rsvtSvc.getCustomerName(cName);
	System.out.println(cName);
	res.getWriter().append(gson.toJson(list));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

