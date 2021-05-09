package shallWe.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.ActivityService;
import shallWe.VO.ActivityVO;
import shallWe.VO.CafeVO;
import shallWe.VO.RestaurantVO;

import com.google.gson.Gson;

/**
 * Servlet implementation class AcivitySelect ï¿½È³ï¿½ddï¿½Æ¿ï¿½
 */
@WebServlet("/makeplan/AcivitySelect")
public class AcivitySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location_name = request.getParameter("location_name");
		
		int displayData = 5;		// ÇÑ ÆäÀÌÁö ´ç º¸¿©Áú µ¥ÀÌÅÍ °¹¼ö
		
		ActivityService service = new ActivityService();
		int r_data_total = service.countRestByLoc(location_name);
		int r_total_page = r_data_total / displayData;
		if(r_data_total % displayData > 0) r_total_page++;
		
		int c_data_total = service.countCafeByLoc(location_name);
		int c_total_page = c_data_total / displayData;
		if(c_data_total % displayData > 0) c_total_page++;
		
		int a_data_total = service.countActByLoc(location_name);
		int a_total_page = a_data_total / displayData;
		if(a_data_total % displayData > 0) a_total_page++;
		
		int s_data_total = service.countSafetyByLoc(location_name);
		int s_total_page = s_data_total / displayData;
		if(s_data_total % displayData > 0) s_total_page++;
		
		//request.setAttribute("currentPage", 1);
		request.setAttribute("r_total_page", r_total_page);
		request.setAttribute("c_total_page", c_total_page);
		request.setAttribute("a_total_page", a_total_page);
		request.setAttribute("s_total_page", s_total_page);
		request.setAttribute("location_name", location_name);
		
		RequestDispatcher rd = request.getRequestDispatcher("paginationTest.jsp");
		rd.forward(request, response);
	}
}
