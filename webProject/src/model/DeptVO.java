package model;

public class DeptVO {

	int department_id;
	String department_name;
	int manager_id;
	int locatoin_id;
	public DeptVO(int department_id, String department_name, int manager_id, int locatoin_id) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager_id = manager_id;
		this.locatoin_id = locatoin_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getLocatoin_id() {
		return locatoin_id;
	}
	public void setLocatoin_id(int locatoin_id) {
		this.locatoin_id = locatoin_id;
	}
	
	
	
}

