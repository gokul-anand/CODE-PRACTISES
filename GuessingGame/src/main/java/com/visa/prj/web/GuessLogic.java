package com.visa.prj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.entity.Question;
import com.visa.prj.util.QuestionUtil;

@WebServlet("/GuessLogic")
public class GuessLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guess = request.getParameter("guess");
		HttpSession ses = request.getSession(true);
		Question question = QuestionUtil.guessChar((Question) ses.getAttribute("question"),guess);
		if (question.getLife()<=0) {
			response.sendRedirect("logout");
		}
		response.sendRedirect("question");
	}

}
