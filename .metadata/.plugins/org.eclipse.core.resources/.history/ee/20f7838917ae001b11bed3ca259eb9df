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

import shallWe.Service.DateSelect;
import shallWe.Service.MemberPlanService;
import shallWe.Service.PlanService;

/**
 * Servlet implementation class Makeplan
 */
@WebServlet("/makeplan/Makeplan")
public class MakeplanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("makePlan.jsp");
		rd.forward(request, response);
		//response.sendRedirect("makePlan.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host_id = request.getParameter("host_id");						
		String plan_name = request.getParameter("plan_name");
		int numbers = Integer.parseInt(request.getParameter("membercount"));	// 인원수
		String plan_id = host_id + System.currentTimeMillis();					// plan id 생성
		
		// 호스트가 고른 장소 이름, 위도, 경도
		String host_place = request.getParameter("host_place");
		String lat = request.getParameter("host_lat");
		String lon = request.getParameter("host_lon");
		double host_lat = Double.parseDouble(lat.equals("")?"0.0":lat);
		double host_lon = Double.parseDouble(lon.equals("")?"0.0":lon);
		
		// 호스트가 고른 날짜
		String[] host_dates = request.getParameter("host_dates").split(",");
		
		// 초대한 친구 리스트
		List<String> friend_id_list = new ArrayList<>();
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			if(name.substring(0, 1).equals("f")) {
				String value = request.getParameter(name);
				friend_id_list.add(value);
			}
		}
		
		
		// 무조건 plans, members_plans(친구) 입력
		// 1. plans inert
		PlanService ps = new PlanService();
		ps.insertPlan(plan_id, plan_name, host_id, numbers);
		
		// 2. members_plans 친구
		MemberPlanService mps = new MemberPlanService();
		for(String friend_id : friend_id_list) {
			mps.insertMemberPlan(plan_id, friend_id, 0.0, 0.0);
		}
		
		// 3. host --> members_plans
		// 장소 안정하면 0.0으로 들어가고 장소 정하면 위도 경도 값이 들어감.
		mps.insertMemberPlan(plan_id, host_id, host_lat, host_lon);
		
		// 4. 날짜 선택 했다면 --> date_options에 날짜들 insert
		DateSelect ds = new DateSelect();
		if(!host_dates[0].equals("")) {
			for(String date:host_dates) {
				ds.insertMasterDate(plan_id, date);
			}
		}
		
		response.sendRedirect("PlanSelectServlet");
	}

}
