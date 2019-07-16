package com.visa.prj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.QuestionDao;
import com.visa.prj.entity.Question;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		if( ses==null) {
			Question q = QuestionDao.getQuestion();
			ses = request.getSession(true);
			ses.setAttribute("question", q);
		}
		request.getRequestDispatcher("question.jsp").forward(request, response);
	}

}
