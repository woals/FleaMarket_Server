package com.yinyxn.LAL.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yinyxn.dao.RegisterDao;
import com.yinyxn.dao.impl.RegisterDaoImpl;
import com.yinyxn.vo.Register;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String time = request.getParameter("time");
		Register register = new Register(name,password,phone,time);
		RegisterDao dao = new RegisterDaoImpl();
		System.out.println(name);
		System.out.println(password);
		System.out.println(phone);
		System.out.println(time);
		if(dao.userRegister(register)){
			out.println("注册成功~……！3秒后返回注册界面！");
			response.setHeader("refresh", "3;url=index.jsp");
		}else{
			out.println("注册失败了~……！");
			out.println("你是<a href='Register/index.jsp'>继续注册</a>，还是" +
					"<a href='Register/view.jsp'>查看所有用户</a>");
		}
		out.flush();
		out.close();
	}

}
