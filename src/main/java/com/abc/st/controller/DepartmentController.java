package com.abc.st.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.st.model.Department;
import com.abc.st.service.DepartmentManager;
import com.abc.st.util.JsonResponse;






@Controller
@RequestMapping("/department*")
public class DepartmentController {
	@Autowired
	private DepartmentManager depManager;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(final @RequestParam(required = false, value = "q") String query) {
        final Model model = new ExtendedModelMap();
        List<Department> department=depManager.getDepartments();
        model.addAttribute("pagetitle", "Department");
        return model;

    }
	 @RequestMapping(method = RequestMethod.GET, value = "/getAvailabledepartmentDetails")
	    @ResponseBody
	    public List<Department> getAvailabledepartmentDetails(final HttpServletRequest request) throws ServletRequestBindingException {

	        
	        final List<Department> departmentDetailList =depManager.getDepartments();
	       
	       
	        return departmentDetailList;
	 
	 }

 @RequestMapping(value = "/getDepartmentDetailDataById/{id}", method = RequestMethod.GET)
 @ResponseBody
 public  Department getDepatrmentDetailById(@PathVariable("id") final Integer id, final HttpServletRequest request) {
	final Department department=depManager.getDepatrmentDetailById(id)	;
	return department;
	}
	@RequestMapping(value = "/getDepartmentDetailDataByCode/{code}", method = RequestMethod.GET)
 @ResponseBody
 public Department getDepatrmentDetailByCode(@PathVariable("code") final String code, final HttpServletRequest request){
		final Department department=depManager.getDepatrmentDetailByCode(code);
		return department;
	}
	 @RequestMapping(method = RequestMethod.POST, produces = "application/json")
	    @ResponseBody
	    public JsonResponse onSubmit(Department department, final BindingResult errors, final HttpServletRequest request
	    ) throws ServletRequestBindingException {
		 final JsonResponse res = new JsonResponse(); 
		 final boolean isNew = department.getId()== null;
		 try{
		 if(isNew)
	    	{
	    	 depManager.saveDepartment(department);
	    	 res.setResult(depManager.getDepartments());
	    	 res.setStatus("SUCCESS");
	    	 res.setMessage("successfully saved");
	      
	     	 
	    	}
		 else{
   		  final Department existingDepartmentDetail = depManager.getDepatrmentDetailById(department.getId());
   	  existingDepartmentDetail.setName(department.getName());
   	  existingDepartmentDetail.setDepartmentcode(department.getDepartmentcode());
   	  depManager.updateDepartment(existingDepartmentDetail);
   	  res.setStatus("SUCCESS");
   	  res.setResult(depManager.getDepartments());
   	  res.setMessage("successfully saved");
  
    }}
		 catch (Exception e) {
	         res.setStatus("FAIL");
	         String messageKey = isNew ? "department save failed" : "department edit failed";
	        
	         res.setMessage(messageKey);
	        
	         return res;
	     }
		 return res;
		 
	 }
}
