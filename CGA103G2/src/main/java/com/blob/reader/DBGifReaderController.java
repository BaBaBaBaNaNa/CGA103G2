package com.blob.reader;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.meals.model.*;

@WebServlet("/meals/DBGifReader")
public class DBGifReaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			System.out.println("1234");
			Integer mealsID = Integer.valueOf(req.getParameter("mealsID"));
			MealsService mealsSvc = new MealsService();
			System.out.println("12345");
			out.write(mealsSvc.getOneMeals(mealsID).getMealsPicture());
			System.out.println("123");
		} catch (Exception e) {
			System.out.println("catch");
			InputStream in = getServletContext().getResourceAsStream("/resources/NoData/nopic.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();

		}
	}

}
