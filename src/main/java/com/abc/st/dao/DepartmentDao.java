package com.abc.st.dao;

import java.util.List;

import com.abc.st.model.Department;

public interface DepartmentDao {
	public int saveDepartment(Department d);
	public void updateDepartment(Department d);
	public int deleteDepartment(Integer departmentid);
	public Department getById(int id);
	List<Department> getDepartments();
	public Department getDepartmentBydepartmentCode(String departmentcode);
}
