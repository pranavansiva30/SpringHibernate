package com.abc.st.service.impl;

import java.util.List;

import javax.jws.WebService;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.st.model.Department;
import com.abc.st.service.DepartmentManager;
import com.abc.st.dao.DepartmentDao;
@Service("departmentManager")
@WebService(serviceName = "DepartmentService", endpointInterface = "com.abc.st.service.DepartmentManager")
@Transactional
public class DepartmentManagerImpl implements DepartmentManager {
	@Autowired
	private DepartmentDao depDao;
	public Department getDepatrmentDetailById(Integer id) {
		
		return depDao.getById(id);
	}

	public Department getDepatrmentDetailByCode(String code) {
		
		return depDao.getDepartmentBydepartmentCode(code);
	}

	public int saveDepartment(Department department) {
	
		return depDao.saveDepartment(department);
	}

	public void updateDepartment(Department d) {
		depDao.updateDepartment(d);
		
	}

	public int deleteDepartmentDetail(Integer DepartmentId) {
				return depDao.deleteDepartment(DepartmentId);
	}

	public List<Department> getDepartments() {
		
		return depDao.getDepartments();
	}
}


