package com.scale.style.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scale.style.model.service.StyleService;
import com.scale.style.model.vo.Style;
import com.scale.user.model.service.UserService;
import com.scale.user.model.vo.User;

/**
 * Servlet implementation class StyleProfileViewController
 */
@WebServlet("/profileView.st")
public class StyleProfileViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StyleProfileViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		User user = new UserService().selectUserByUserNo(userNo);
		request.setAttribute("user", user);
		
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if(loginUser != null && loginUser.getUserNo() == userNo) {
			request.getRequestDispatcher("views/style/styleMyProfile.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("views/style/styleProfileView.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
