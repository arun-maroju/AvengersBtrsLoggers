package com.avengers.bus.models.entityModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_stops")
public class Stations {
	@Id
	@Column(name = "stop_id")
	private String stop_id;
	@Column(name = "stop_name")
	private String stop_name;

	public String getStop_id() {
		return stop_id;
	}

	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}

	public String getStop_name() {
		return stop_name;
	}

	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}

	@Override
	public String toString() {
		return "Stations [stop_id=" + stop_id + ", stop_name=" + stop_name + "]";
	}

}

//// import org.hibernate.annotations.Table;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.Table;
//
// @Entity
// @Table(name = "EMP")
// public class Employee {
//
// @Id
// private Integer empNo;
// private Integer deptNo;
// private String eName;
// private String job;
//
// @Column(name = "sal")
// private Double salary;
//
// public Employee() {
// }
//
// public Employee(Integer eno, Integer dno, String enm, String jb, Double sal) {
// this.empNo = eno;
// this.eName = enm;
// this.job = jb;
// this.salary = sal;
// this.deptNo = dno;
// }
//
// public Integer getEmpNo() {
// return empNo;
// }
//
// public void setEmpNo(Integer eno) {
// this.empNo = eno;
// }
//
// public Integer getDeptNo() {
// return deptNo;
// }
//
// public void setDeptNo(Integer dno) {
// this.deptNo = dno;
// }
//
// public String getEName() {
// return eName;
// }
//
// public void setEName(String enm) {
// this.eName = enm;
// }
//
// public String getJob() {
// return job;
// }
//
// public void setJob(String jb) {
// this.job = jb;
// }
//
// public Double getSalary() {
// return salary;
// }
//
// public void setSalary(double sal) {
// this.salary = sal;
// }
//
// @Override
// public String toString() {
// return "Employee{" + "Emp No=" + empNo + ", deptNo=" + deptNo + ", EmpName='" + eName + '\'' + ", job='" + job
// + '\'' + '}';
// }
//
// }
