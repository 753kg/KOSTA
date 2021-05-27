package com.kosta.sbproject.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString// (exclude = "department") // 한쪽만 막아도 됨
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_emp")
public class EmpVO {

	@Id
	int employeeId;
	
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	Date hireDate;
	String jobId;
	@Column(nullable = true)
	int salary;
	@Column(nullable = true)
	double commissionPct;
	@Column(nullable = true)
	int managerId;
	
	@ManyToOne
	DeptVO department;		// department_deptid
}
