package com.abc.st.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abc.st.model.Department;

@WebService
@Path("/departments")
public interface DepartmentManager {
	@GET
    @Path("getDepartmentDetailDataById/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
 Department getDepatrmentDetailById(final @PathParam("id") Integer id);
 
    @GET
    @Path("getDepartmentDetailDataByCode/{code}")
    @Produces({MediaType.APPLICATION_JSON})
 Department getDepatrmentDetailByCode(final @PathParam("code") String code);
 @POST
 int saveDepartment(Department department);
 @POST
 void updateDepartment(Department d);
 @DELETE
 int deleteDepartmentDetail(Integer DepartmentId);
 @GET
 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  List<Department> getDepartments();
}
