package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOMember;
import kr.or.bit.model.dto.DTOMember;

// 회원가입
public class SignUpService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String address = request.getParameter("address");
		String cardNum = request.getParameter("card_num");
		
<<<<<<< HEAD
		System.out.println("pwd(변환전):"+pwd);
=======
		System.out.println(pwd);
>>>>>>> f6fa83a0eea4f294321c96fd8368998a4f885e8f
		
		DTOMember member = new DTOMember(id, pwd, name, hp, cardNum, address);
		int resultRow = DAOMember.c_insertMember(member); // 어떻게 처리할지 생각해보자
		
		forward.setRedirect(true);
		forward.setPath("mainPage.do");
		
		return forward;
	}

}
