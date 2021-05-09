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
		
		int displayDataNum = 5;		// 한 페이지 당 보여질 데이터 갯수
		int displayPageNum = 5;		// 페이지바에 보일 페이지 개수 --> 이거는 무시
		
		ActivityService service = new ActivityService();
		int total = service.countRestByLoc(location_name);
		PagingVO paging = new PagingVO();
		paging.setDisplayData(displayDataNum);
		paging.setDisplayPage(displayPageNum);
		paging.setCurrentPage(page);
		paging.setTotalData(total);
		
		String path = "";
		switch (type) {
		case "r":
			List<RestaurantVO> rlist = service.selectRestByLoc(location_name, page, paging);
			request.setAttribute("rlist", rlist);
			path = "restaurant_page.jsp";
			break;
		case "c":
			List<CafeVO> clist = service.selectCafeByLoc(location_name, page, paging);
			request.setAttribute("clist", clist);
			path = "cafe_page.jsp";
			break;
		case "a":
			List<ActivityVO> alist = service.selectActByLoc(location_name, page, paging);
			request.setAttribute("alist", alist);
			path = "activity_page.jsp";
			break;
		case "s":
			List<SafetyRestaurantVO> slist = service.selectSafetyByLoc(location_name, page, paging);
			request.setAttribute("slist", slist);
			path = "safety_page.jsp";
			break;
		default:
			break;
		}
		
		request.setAttribute("paging", paging);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
