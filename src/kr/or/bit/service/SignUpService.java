package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOMember;
import kr.or.bit.model.dto.DTOMember;
import kr.or.bit.utils.c_SHAUtil;
import kr.or.bit.utils.c_Salt;
import sun.security.provider.SHA;

// 회원가입
public class SignUpService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		c_Salt salt = new c_Salt();
		c_SHAUtil sha = new c_SHAUtil();
		String s = salt.readSalt("key.txt");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String address = request.getParameter("address");
		String cardNum = request.getParameter("cardNum");
		DTOMember member = new DTOMember(id,sha.getSha512( s+pwd), name, hp, cardNum, address);
		int resultRow = DAOMember.insertMember(member); // 어떻게 처리할지 생각해보자
		
		forward.setRedirect(true);
		forward.setPath("mainPage.do");
		
		return forward;
	}

}
