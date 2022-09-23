package com.rsvtCtrl.controller;


import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class CommonUtil {
	
	public static <P> P json2Pojo(HttpServletRequest request, Class<P> classOfPojo) {
		try (BufferedReader br = request.getReader()) {
			Gson GSON = new Gson();
			return GSON.fromJson(br, classOfPojo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <P> void writePojo2Json(HttpServletResponse response, P pojo) {
		response.setContentType("application/json");
		try (PrintWriter pw = response.getWriter()) {
			Gson GSON = new Gson();
			pw.print(GSON.toJson(pojo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
