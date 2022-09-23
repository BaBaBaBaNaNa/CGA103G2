package com.blob.reader;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.news.model.NewsService;

@WebServlet("/back-end/news/DBGifReader4")
public class DBGifReaderControllerNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			System.out.println("================================");
			Integer newsID = Integer.valueOf(req.getParameter("newsID"));
			NewsService empSvc = new NewsService();
			out.write(empSvc.getOneNews(newsID).getNewsPictures());
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/back-end/news/NoData/nopic.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();

		}
	}

}
