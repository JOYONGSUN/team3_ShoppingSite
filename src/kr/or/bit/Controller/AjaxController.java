package kr.or.bit.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.service_ajax.IdCheckAjaxService;
import kr.or.bit.service_ajax.SignInAjaxService;


@WebServlet(
      name = "AjaxController",
      urlPatterns = "*.ajax",
      loadOnStartup = 1
      )
public class AjaxController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   private HashMap<String, ActionAjax> actionList = null;
       
    public AjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

   public void init(ServletConfig config) throws ServletException {
      System.out.print("*.ajax Servlet ->");
      actionList = new HashMap<String, ActionAjax>();
      
      actionList.put("/idCheck.ajax", new IdCheckAjaxService());
      actionList.put("/signIn.ajax", new SignInAjaxService());
      
      System.out.println(" initialized");
   }

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String urlCommand = (String)request.getAttribute("urlCommand");
      
      PrintWriter out = response.getWriter();
      ActionAjax actionAjax = actionList.get(urlCommand);
      if(actionAjax != null) {
         ActionAjaxData ajaxData = actionAjax.execute(request, response);
         response.setContentType(ajaxData.getContentType());
         out.print(ajaxData.getData());
      } else {
         // wrong request
         response.setStatus(404);
      }
      
      out.close();
   }

//   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());
//   }
//
//   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      doGet(request, response);
//   }

}