<%@page import="model.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="model.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
int deptid = Integer.parseInt(request.getParameter("deptid"));
EmpDAO empDAO = new EmpDAO();
List<EmpVO> emplist = empDAO.selectByDept(deptid);
%>
<table>
	<tr>
		<td>������ȣ</td>
		<td>�����̸�</td>
		<td>�޿�</td>
		<td>�Ի���</td>
		<td>�μ���ȣ</td>
	</tr>
	<%
	for(EmpVO emp : emplist){
		String format = 
				"<tr>" +
					"<td>%d</td>" +
					"<td>%s</td>" +
					"<td>%d</td>" +
					"<td>%s</td>" +
					"<td>%d</td>" +
				"</tr>";
		String s = String.format(format, emp.getEmployee_id(), emp.getFirst_name(), 
				emp.getSalary(), emp.getHire_date(), emp.getDepartment_id());
		out.print(s);
	}
	%>
</table>