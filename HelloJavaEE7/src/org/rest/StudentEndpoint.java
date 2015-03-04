package org.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.sample.Student;

@RequestScoped
@Path("/students")
public class StudentEndpoint {

	@PersistenceContext EntityManager em;

	@Transactional
	@POST
	@Consumes({ "application/xml", "application/json", "text/plain" })
	public void create(@Min(1) final long id) {
		Student student = new Student(id);
		em.persist(student);
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({ "application/xml", "application/json" })
	public Response findById(@PathParam("id") final Long id) {
		Student student = em.find(Student.class, id);
		if (student == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(student).build();
	}

	@GET
	@Produces("application/xml")
	public Student[] listAll(
			@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		TypedQuery<Student> query = em.createNamedQuery("findAllStudents", Student.class);
		final List<Student> students = query.getResultList();
		return students.toArray(new Student[0]);
	}
}