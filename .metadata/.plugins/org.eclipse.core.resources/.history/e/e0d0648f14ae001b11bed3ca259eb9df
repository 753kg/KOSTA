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
import shallWe.VO.PagingVO;
import shallWe.VO.RestaurantVO;
import shallWe.VO.SafetyRestaurantVO;

/**
 * Servlet implementation class SelectNPageServlet
 */
@WebServlet("/activityView/SelectNPage")
public class SelectNPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location_name = request.getParameter("location_name");
		String type = request.getParameter("type");
		int page = 1;
		
		String spage = request.getParameter("page");
		if(spage != null) {
			page = Integer.parseInt(spage);
		}
		
		int displayData = 5;
		int startNum = (page - 1) * displayData + 1;
		int endNum = page * displayData;
		
		ActivityService service = new ActivityService();
		
		String path = "";
		switch (type) {
		case "r":
			List<RestaurantVO> rlist = service.selectRestByLoc(location_name, page, startNum, endNum);
			request.setAttribute("rlist", rlist);
			path = "restaurant_page.jsp";
			break;
		case "c":
			List<CafeVO> clist = service.selectCafeByLoc(location_name, page, startNum, endNum);
			request.setAttribute("clist", clist);
			path = "cafe_page.jsp";
			break;
		case "a":
			List<ActivityVO> alist = service.selectActByLoc(location_name, page, startNum, endNum);
			request.setAttribute("alist", alist);
			path = "activity_page.jsp";
			break;
		case "s":
			List<SafetyRestaurantVO> slist = service.selectSafetyByLoc(location_name, page, startNum, endNum);
			request.setAttribute("slist", slist);
			path = "safety_page.jsp";
			break;
		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
