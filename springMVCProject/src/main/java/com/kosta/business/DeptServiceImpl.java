package com.kosta.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kosta.model.DeptVO;
import com.kosta.model.LocationVO;
import com.kosta.model.ManagerVO;

@Service("deptService")
public class DeptServiceImpl implements DeptServiceInterface {
	
	@Autowired
	@Qualifier("deptDAO_mybatis")
	DeptDAOInterface deptDAO;
	// DeptDAOInterface 구현 class ==> DeptDAO, DeptDAOMyBatis
	// @Autowired : type이 같으면 자동으로 DI
	// @Qualifier : type이 같은 class가 여러개라면 이름으로 구분.

	@Override
	public List<DeptVO> findAll() {
		// TODO Auto-generated method stub
		return deptDAO.findAll();
	}

	@Override
	public DeptVO findById(int deptid) {
		// TODO Auto-generated method stub
		return deptDAO.findById(deptid);
	}

	@Override
	public int insert(DeptVO dept) {
		// TODO Auto-generated method stub
		return deptDAO.insert(dept);
	}

	@Override
	public int update(DeptVO dept) {
		// TODO Auto-generated method stub
		return deptDAO.update(dept);
	}

	@Override
	public int delete(int deptid) {
		// TODO Auto-generated method stub
		return deptDAO.delete(deptid);
	}

	@Override
	public List<ManagerVO> findAllManager() {
		// TODO Auto-generated method stub
		return deptDAO.findAllManager();
	}

	@Override
	public List<LocationVO> findAllLocation() {
		// TODO Auto-generated method stub
		return deptDAO.findAllLocation();
	}

}
