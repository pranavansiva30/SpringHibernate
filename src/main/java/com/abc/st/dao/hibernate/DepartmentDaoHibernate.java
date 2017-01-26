package com.abc.st.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import com.abc.st.dao.DepartmentDao;
import com.abc.st.model.Department;

@Repository("departmentDao")
public class DepartmentDaoHibernate extends GenericDaoHibernate implements DepartmentDao {

	//method to save department
	
	public int saveDepartment(Department d){
		int i=(Integer)getSession().save(d);
		return i;
	}
	//method to update department
	
	public void updateDepartment(Department d){
		Session session=getSession();
		session.update(d);
	 
	}
	//method to delete department
	
	public int deleteDepartment(Integer departmentid){
		Session session=getSession();
		Query q=session.createQuery("delete from Department where id=:i"); 
		q.setParameter("i",departmentid );
        int x=q.executeUpdate(); 
        return x;
		
   	}
	//method to return one department of given id
	public Department getById(int id){
		
        final Criteria criteria = getSession().createCriteria(Department.class)
                .add(Restrictions.eq("id",id));
        Department d=(Department) criteria.uniqueResult();
       
        
        return d;
	}
	//method to return all department
	public List<Department> getDepartments(){
	    List<Department> list=new ArrayList<Department>();
	    final Criteria criteria = getSession().createCriteria(Department.class);
	    list=criteria.list();
	    return list;
	}
	
	
	public Department getDepartmentBydepartmentCode(String departmentcode){
		 final Criteria criteria = getSession().createCriteria(Department.class)
	                .add(Restrictions.eq("departmentcode",departmentcode));
	        return (Department) criteria.uniqueResult();
		
	}
}
