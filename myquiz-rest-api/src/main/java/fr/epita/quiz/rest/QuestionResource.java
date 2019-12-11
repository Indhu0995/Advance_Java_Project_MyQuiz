package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.epita.quiz.datamodel.Options;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;

@Path("/questions/")
public class QuestionResource {
	
	
	@Inject
	QuestionDAO dao;
	
	@Inject
	MCQChoiceDAO mcqDAO;
	
	private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);
	
	
	@POST
	@Path("/addQuestion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody Question question) throws URISyntaxException {
		//create a question 
		dao.create(question);
		System.out.println("Respon::"+question);
		System.out.println("Id::"+question.getId());
		return Response.ok(question).build();
	}
	
	@GET
	@Path("getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(@PathParam("id") int id) {
		//create a question 
		
		Question question = dao.getById(id, Question.class);
		
		return Response.ok(question).build();
	}

	
	@GET
	@Path("search/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("qContent") String questionContent) {
		//create a question 
		List<Question> searchList = dao.search(new Question(questionContent));
		return Response.ok(searchList).build();
	}
	  @DELETE
	  @Path("delete/{id}")
	  public Response deleteOrderById(@PathParam("id") int id) {
		System.out.println(id);
		Question question = new Question();
		question.setId(id); 
		dao.delete(question);
	    return Response.ok().build();
	  }
	  
	  
	   @PUT
		@Path("update/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateQuestion(@PathParam("id") int id,@RequestBody Question question) {
			//create a question 
			
			Question  questionUpdate = dao.getById(id, Question.class);
			
			questionUpdate.setQuestionContent(question.getQuestionContent());
			dao.update(questionUpdate);
			return Response.ok().build();
		}
	  
	  @POST
		@Path("/options")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response createOptions(@RequestBody Options options) throws URISyntaxException {
			//create a question 
		    mcqDAO.create(options);
			System.out.println("Respon::"+options);
			System.out.println("Id::"+options.getId());
			return Response.ok(options).build();
		}
	  
	    @GET
		@Path("allQuestions/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response allQuestions() {
			//create a question 
			List<Question> questionList = dao.questionList();
			return Response.ok(questionList).build();
		}
	
	

}
