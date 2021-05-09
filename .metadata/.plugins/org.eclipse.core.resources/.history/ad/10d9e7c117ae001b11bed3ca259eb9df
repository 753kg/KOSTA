package shallWe.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shallWe.Service.DateSelect;
import shallWe.Service.MemberPlanService;
import shallWe.Service.PlanService;
import shallWe.VO.PlanVO;

/**
 * Servlet implementation class Makeplan
 */
@WebServlet("/makeplan/Makeplan")
public class MakeplanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlanService service = new PlanService();
		HttpSession session = request.getSession();
		String memberid = (String) session.getAttribute("memberid");
	
		if(memberid == null) {
			response.sendRedirect("../login/login.jsp");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("makePlan.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host_id = request.getParameter("host_id");						
		String plan_name = request.getParameter("plan_name");
		int numbers = Integer.parseInt(request.getParameter("membercount"));	// �ο���
		String plan_id = host_id + System.currentTimeMillis();					// plan id ����
		
		// ȣ��Ʈ�� �� ��� �̸�, ����, �浵
		String host_place = request.getParameter("host_place");
		String lat = request.getParameter("host_lat");
		String lon = request.getParameter("host_lon");
		double host_lat = Double.parseDouble(lat.equals("")?"0.0":lat);
		double host_lon = Double.parseDouble(lon.equals("")?"0.0":lon);
		
		// ȣ��Ʈ�� �� ��¥
		String[] host_dates = request.getParameter("host_dates").split(",");
		
		// �ʴ��� ģ�� ����Ʈ
		List<String> friend_id_list = new ArrayList<>();
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			if(name.substring(0, 1).equals("f")) {
				String value = request.getParameter(name);
				friend_id_list.add(value);
			}
		}
		
		
		// ������ plans, members_plans(ģ��) �Է�
		// 1. plans inert
		PlanService ps = new PlanService();
		ps.insertPlan(plan_id, plan_name, host_id, numbers);
		
		// 2. members_plans ģ��
		MemberPlanService mps = new MemberPlanService();
		for(String friend_id : friend_id_list) {
			mps.insertMemberPlan(plan_id, friend_id, 0.0, 0.0);
		}
		
		// 3. host --> members_plans
		// ��� �����ϸ� 0.0���� ���� ��� ���ϸ� ���� �浵 ���� ��.
		mps.insertMemberPlan(plan_id, host_id, host_lat, host_lon);
		
		// 4. ��¥ ���� �ߴٸ� --> date_options�� ��¥�� insert
		DateSelect ds = new DateSelect();
		if(!host_dates[0].equals("")) {
			for(String date:host_dates) {
				ds.insertMasterDate(plan_id, date);
			}
		}
		
		response.sendRedirect("PlanSelectServlet");
	}

}
