package com.knoldus.student;

import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/student")
public class StudentResource {

    /**
     * Injecting student repository.
     */
    @Inject
    StudentRepository repository;

    /**
     * Get student by id
     * @param id the id
     * @return student
     */
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        Student student = repository.findById(new ObjectId(id));
        return Response.ok(student).build();
    }

    /**
     * get all students
     * @return list of all students
     */
    @GET
    public Response get() {
        return Response.ok(repository.listAll()).build();
    }

    /**
     * add student
     * @param student the students
     * @return added student
     * @throws URISyntaxException
     */
    @POST
    public Response create(Student student) throws URISyntaxException {
        repository.persist(student);
        return Response.created(new URI("/" + student.id)).build();
    }

    /**
     * Delete student
     * @param id the id
     * @return no content response
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        Student student = repository.findById(new ObjectId(id));
        repository.delete(student);
        return Response.noContent().build();
    }
}
