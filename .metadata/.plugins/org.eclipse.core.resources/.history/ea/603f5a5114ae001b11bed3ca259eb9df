package shallWe.Service;

import java.util.List;

import shallWe.DAO.ActivityDAO;
import shallWe.VO.ActivityVO;
import shallWe.VO.CafeVO;
import shallWe.VO.PagingVO;
import shallWe.VO.RestaurantVO;
import shallWe.VO.SafetyRestaurantVO;

public class ActivityService {
	
	ActivityDAO dao = new ActivityDAO();
	
	public List<RestaurantVO> selectRestaurantByLocationName(String location_name) {
		return dao.selectRestaurantByLocationName(location_name);
	}
	
	public List<CafeVO> selectCafeByLocationName(String location_name) {
		return dao.selectCafeByLocationName(location_name);
	}
	
	public List<ActivityVO> selectActivityByLocationName(String location_name) {
		return dao.selectActivityByLocationName(location_name);
	}
	
	public int countRestByLoc(String location_name) {
		return dao.countRestByLoc(location_name);
	}
	
	public int countCafeByLoc(String location_name) {
		return dao.countCafeByLoc(location_name);
	}
	
	public int countActByLoc(String location_name) {
		return dao.countActByLoc(location_name);
	}
	
	public int countSafetyByLoc(String location_name) {
		return dao.countSafetyByLoc(location_name);
	}
	
	// ∆‰¿Ã¬°
	public List<RestaurantVO> selectRestByLoc(String location_name, int currentPage, PagingVO paging) {
		return dao.selectRestByLoc(location_name, currentPage, paging);
	}
	
	public List<CafeVO> selectCafeByLoc(String location_name, int currentPage, PagingVO paging) {
		return dao.selectCafeByLoc(location_name, currentPage, paging);
	}
	
	public List<ActivityVO> selectActByLoc(String location_name, int currentPage, PagingVO paging) {
		return dao.selectActByLoc(location_name, currentPage, paging);
	}
	
	public List<SafetyRestaurantVO> selectSafetyByLoc(String location_name, int currentPage, PagingVO paging) {
		return dao.selectSafetyByLoc(location_name, currentPage, paging);
	}
}
