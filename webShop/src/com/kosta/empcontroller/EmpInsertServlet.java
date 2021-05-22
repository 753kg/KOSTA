package com.kosta.empcontroller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptDAO;
import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;
import com.kosta.util.ConvertUtil;
import com.kosta.util.UploadFileHelper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class EmpInsertServlet
 */
@WebServlet("/emp/empInsert")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO empdao = new EmpDAO();
		DeptDAO deptdao = new DeptDAO();
		request.setAttribute("joblist", empdao.selectAllJobs());
		request.setAttribute("deptlist", deptdao.selectAll());
		request.setAttribute("mlist", deptdao.selectAllManager());
		RequestDispatcher rd = request.getRequestDispatcher("emp_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에 insert
		//request.setCharacterEncoding("utf-8");
		
		String UPLOAD_DIR ="upload";
		 int size = 1024 * 1024 * 10; // 파일 사이즈 설정 : 10M
		// DefaultFileRenamePolicy 처리는 중복된 이름이 존재할 경우 처리할 때
		 String path = getServletContext().getRealPath(UPLOAD_DIR);
		 System.out.println(path);
		 MultipartRequest mprequest = 
				 new MultipartRequest(request, path, size, "utf-8", 
				 new DefaultFileRenamePolicy());
		 
		// 전송한 전체 파일이름들을 가져온다.
		Enumeration files = mprequest.getFileNames();
		String str = (String) files.nextElement();

		// 파일명 중복이 발생했을 때 정책에 의해 뒤에 1,2,3 처럼 숫자가 붙어 고유 파일명을 생성한다.
		// 이때 생성된 이름을 FilesystemName이라고 하여 그 이름 정보를 가져온다. (중복 처리)
		//String fileName = mprequest.getFilesystemName(str);
		// 실제 파일 이름을 가져온다.
		String originalFileName = mprequest.getOriginalFileName(str);
		System.out.println(originalFileName);

		
		EmpVO emp = new EmpVO();
		emp.setEmployee_id(ConvertUtil.convertInt(mprequest.getParameter("employee_id")));
		emp.setFirst_name(mprequest.getParameter("first_name"));
		emp.setLast_name(mprequest.getParameter("last_name"));
		emp.setEmail(mprequest.getParameter("email"));
		//emp.setPhone_number(mprequest.getParameter("phone_number"));
		emp.setPhone_number(originalFileName);
		emp.setHire_date(ConvertUtil.convertDate(mprequest.getParameter("hire_date")));
		emp.setJob_id(mprequest.getParameter("job_id"));
		emp.setSalary(ConvertUtil.convertInt(mprequest.getParameter("salary")));
		emp.setCommission_pct(ConvertUtil.convertDouble(mprequest.getParameter("commission_pct")));
		emp.setManager_id(ConvertUtil.convertInt(mprequest.getParameter("manager_id")));
		emp.setDepartment_id(ConvertUtil.convertInt(mprequest.getParameter("department_id")));
		
		EmpDAO dao = new EmpDAO();
		int result = dao.insertEmp(emp);
		String message = result>0?"등록성공":"등록실패";
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("emp_result.jsp");
		rd.forward(request, response);
	}

}
