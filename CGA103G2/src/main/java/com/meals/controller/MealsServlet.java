package com.meals.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.util.*;
import com.meals.model.*;
import com.mealscateory.model.MealsCategoryDAO;
import com.mealscateory.model.MealsCategoryVO;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet("/back-end/meals/MealsServlet.do")
public class MealsServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getAll1".equals(action)) {
			/*************************** 開始查詢資料 ****************************************/
		    MealsDAO dao = new MealsDAO();
			List<MealsVO> list = dao.getAll();
			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("list", list); // 資料庫取出的list物件,存入session
			// Send the Success view
			String url = "/front-end/shopcart/ShopCartMenu2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
		}
		
		
		
		if ("getAll".equals(action)) {
			/*************************** 開始查詢資料 ****************************************/
		    MealsDAO dao = new MealsDAO();
			List<MealsVO> list = dao.getAll();
			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("list", list); // 資料庫取出的list物件,存入session
			// Send the Success view
			String url = "/back-end/meals/listAllPicture.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
		}

		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理**********************/
			
				String str = req.getParameter("mealsID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/meals/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				Integer mealsID = null;
				try {
					mealsID = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("員工編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/meals/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/**************************2.開始查詢資料****************************************/
				MealsService MealsSvc = new MealsService();
				MealsVO mealsVO = MealsSvc.getOneMeals(mealsID);
				if (mealsVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/meals/select_page.jsp");
					failureView.forward(req, res);
					return;//
				}
				
				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("mealsVO", mealsVO); //資料庫取出的empVO物件,存入req
				String url = "/back-end/meals/MealsOne.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數 ****************************************/
				Integer MealsID = Integer.valueOf(req.getParameter("mealsID"));
				/***************************2.開始查詢資料****************************************/
				MealsService MealsSvc = new MealsService();
				MealsVO mealsVO = MealsSvc.getOneMeals(MealsID);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?mealsID="  +mealsVO.getMealsID()+
						       "&mealsCategoryID="  +mealsVO.getMealsCategoryID()+
						       "&mealsName="    +mealsVO.getMealsName()+
						       "&mealsPrice="+mealsVO.getMealsPrice()+
						       "&mealsInfo="    +mealsVO.getMealsInfo()+
						       "&mealsPicture="   +mealsVO.getMealsPicture()+
						       "&mealsControl=" +mealsVO.getMealsControl();
			String url = "/back-end/meals/updateMeals_input.jsp"+param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer mealsID = Integer.valueOf(req.getParameter("mealsID").trim());

			Integer mealsCategoryID = Integer.valueOf(req.getParameter("mealsCategoryID").trim());
			
			String mealsName = req.getParameter("mealsName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{0,10}$";
			if (mealsName == null || mealsName.trim().length() == 0) {
				errorMsgs.put("mealsName","菜色名稱: 請勿空白");
				System.out.println("菜名空白");
			} else if (!mealsName.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("mealsName","菜色名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				System.out.println("菜名自述");
			}
			Integer mealsPrice = null;
			try {
				mealsPrice = Integer.valueOf(req.getParameter("mealsPrice").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("mealsPrice",": 價錢:請輸入數字");
			}
			
			String mealsInfo = req.getParameter("mealsInfo").trim();
			String mealsInfoReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9_)]{0,100}$"; //此正則(規)表示式(regular-expression)- 用來比對JSR 303 的@Size
			if (mealsInfo == null || mealsInfo.trim().length() == 0) {
				errorMsgs.put("mealsInfo","說明: 請勿空白");
				System.out.println("菜名說明");
			} else if(!mealsInfo.trim().matches(mealsInfoReg)) {
				errorMsgs.put("mealsInfo","說明: 長度必需在2到100之間");
				System.out.println("菜名空白自");
            }
			
			InputStream in = req.getPart("mealsPicture").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
			byte[] mealsPicture = null;
			if(in.available()!=0){
				mealsPicture = new byte[in.available()];
				in.read(mealsPicture);
				System.out.println("NotIMG");
				in.close();
			}  else {
				System.out.println("NotIMG2");
				MealsService mealsSvc = new MealsService();
				mealsPicture = mealsSvc.getOneMeals(mealsID).getMealsPicture();
				System.out.println("mealsPicture");
			}
			
			Integer mealsControl = 0;
			String[] mealsControl1 = null;
			try {
				 mealsControl1 = req.getParameterValues("mealsControl");
				 if (mealsControl1[0].equals("0")) {
					 mealsControl = 0;
					 System.out.println(0);
				}else if (mealsControl1[0].equals("1")) {
					mealsControl = 1;
					System.out.println(1);	
				}
			} catch (Exception e) {
				errorMsgs.put("mealsControl","菜色控制: 請勿空白");
			}
			MealsVO mealsVO = new MealsVO();
			mealsVO.setMealsID(mealsID);
			mealsVO.setMealsCategoryID(mealsCategoryID);
			mealsVO.setMealsName(mealsName);
			mealsVO.setMealsPrice(mealsPrice);
			mealsVO.setMealsControl(mealsControl);
			mealsVO.setMealsPicture(mealsPicture);
			
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("mealsVO", mealsVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/meals/updateMeals_input.jsp");
				failureView.forward(req, res);
				System.out.println("errorMsgs.isEmpty()");
				return; //程式中斷
			}
			/***************************2.開始修改資料 *****************************************/
			System.out.println("MealsService");
			MealsService MealsSvc = new MealsService();
			mealsVO = MealsSvc.updateMeals(mealsID, mealsCategoryID,mealsName,mealsPrice,mealsInfo,mealsPicture,mealsControl);

			/*************************** 3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("mealsVO", mealsVO); // 資料庫update成功後,正確的的empVO物件,存入req
			System.out.println("/back-end/meals/mealsEditSuccess.jsp");
			String url = "/back-end/meals/mealsEditSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			System.out.println("insert");
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);


			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			
			
			Integer mealsCategoryID =Integer.valueOf(req.getParameter("mealsCategoryID").trim());
			
			
			String mealsName = req.getParameter("mealsName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (mealsName == null || mealsName.trim().length() == 0) {
				errorMsgs.put("mealsName","名稱:請勿空白");
			} else if (!mealsName.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("mealsName","名稱:只能是中、英文字母、數字和_ 且長度必需在2到10之間");
			}
			
			Integer mealsPrice = null;
			try {
				mealsPrice = Integer.valueOf(req.getParameter("mealsPrice").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("mealsPrice","價錢: 請輸入數字");
			}
			
			
			
			String mealsInfo = req.getParameter("mealsInfo");
			if (mealsInfo == null || mealsInfo.trim().length() == 0) {
				errorMsgs.put("mealsInfo","菜色說明:請勿空白");
			} else if (!mealsInfo.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("mealsInfo:","菜色說明:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			InputStream in = req.getPart("mealsPicture").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
			byte[] mealsPicture = null;
			if(in.available()!=0){
				mealsPicture = new byte[in.available()];
				in.read(mealsPicture);
				in.close();
			}  else errorMsgs.put("upFiles","員工照片: 請上傳照片");
			Integer mealsControl =0;
			String[] mealsControl1 = null;
			try {
				mealsControl1 = req.getParameterValues("mealsControl");
				if (mealsControl1[0].equals("0")) {
					 mealsControl = 0;
					 System.out.println(0);
				}else if (mealsControl1[0].equals("1")) {
					mealsControl = 1;
					System.out.println(1);	
				}
			} catch (Exception e) {
				errorMsgs.put("mealsControl",": 請選擇上下架");
			}
			
			MealsVO mealsVO = new MealsVO();
			mealsVO.setMealsCategoryID(mealsCategoryID);
			mealsVO.setMealsName(mealsName);
			mealsVO.setMealsPrice(mealsPrice);
			mealsVO.setMealsControl(mealsControl);
			mealsVO.setMealsPicture(mealsPicture);

			
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("iner錯");
				req.setAttribute("mealsVO", mealsVO); // 資料庫update成功後,正確的的empVO物件,存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/meals/mealsAdd.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料***************************************/
			MealsService MealsSvc = new MealsService();
			MealsSvc.addMeals(mealsCategoryID,mealsName,mealsPrice,mealsInfo,mealsPicture,mealsControl);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("mealsVO", mealsVO);
			req.setAttribute("success", "- (新增成功)");
			String url = "/back-end/meals/mealsAddSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.***************************************/
			Integer mealsID = Integer.valueOf(req.getParameter("mealsID"));

			/*************************** 2.開始新增資料***************************************/
			System.out.println(mealsID);
			MealsService MealsSvc = new MealsService();
			MealsSvc.daletMeals(mealsID);
			
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/meals/mealsDeleteSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);//  刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		
		if ("listMeals_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				
				/***************************1.將輸入資料轉為Map**********************************/ 
				//採用Map<String,String[]> getParameterMap()的方法 
				//注意:an immutable java.util.Map 
				//Map<String, String[]> map = req.getParameterMap();
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				
				// 以下的 if 區塊只對第一次執行時有效
				if (req.getParameter("whichPage") == null){
					Map<String, String[]> map1 = new HashMap<String, String[]>(req.getParameterMap());
					session.setAttribute("map",map1);
					map = map1;
				} 
				
				/***************************2.開始複合查詢***************************************/
				MealsService mealsSvc = new MealsService();
				List<MealsVO> list  = mealsSvc.getAll(map);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("listMeals_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
				RequestDispatcher successView = req.getRequestDispatcher("/back-end/meals/listMeals_ByCompositeQuery.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
				successView.forward(req, res);
		}
		
	}
}
