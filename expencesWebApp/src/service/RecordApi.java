package service;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import model.Category;
import model.Record;
import model.User;
import utils.TimeUtil;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.IRecDao;
import dao.IUserDao;
import dao.RecDao;
import dao.cassandra.UtilDao;

//The class registers its methods for the HTTP GET request using the @GET annotation.
//Using the @Produces annotation, it defines that it can deliver several MIME types,
//text, XML and HTML.

//The browser requests per default the HTML MIME type.

@Path("/data")
public class RecordApi {

	@GET
	@Path("/records")
	@Produces(MediaType.APPLICATION_JSON)

	public String GetAllRecs() {
		IRecDao fixture = (IRecDao) new RecDao();
		String result = fixture.getAll();
		return result;
	}

	@POST
	@Path("/record/{label}/{description}/{ammount}/{category}/{created}")
	@Produces(MediaType.APPLICATION_JSON)
	public String InsertRec(@PathParam("ammount") String ammount, @PathParam("category") String category,
			@PathParam("created") String created, @PathParam("description") String description,
			@PathParam("label") String label) {
		Record model = new Record();
		model.setAmmont(Integer.parseInt(ammount));
		model.setCategory(category);
		model.setCreatedIn(TimeUtil.getDay(created));
		model.setLabel(label);
		model.setDescription(description);
		IRecDao fixture = (IRecDao) new RecDao();

		fixture.insert(model);
		return "{ \"msg\" : \"rec_created\" }";
	}

	@POST
	@Path("/record/update/{label}/{description}/{ammount}/{category}/{created}")
	@Produces(MediaType.APPLICATION_JSON)
	public String UpdateUser(@PathParam("ammount") String ammount, @PathParam("category") String category,
			@PathParam("created") String created, @PathParam("description") String description,
			@PathParam("label") String label) {
		Record model = new Record();
		model.setAmmont(Integer.parseInt(ammount));
		model.setCategory(category);
		model.setCreatedIn(TimeUtil.getDay(created));
		model.setLabel(label);
		model.setDescription(description);
		IRecDao fixture = (IRecDao) new RecDao();

		fixture.update(model);
		return "{ \"msg\" : \"rec_updated\" }";
	}

	@DELETE
	@Path("/record/{label}/{description}/{ammount}/{category}/{created}")
	@Produces(MediaType.APPLICATION_JSON)
	public String DeleteUser(@PathParam("ammount") String ammount, @PathParam("category") String category,
			@PathParam("created") String created, @PathParam("description") String description,
			@PathParam("label") String label) {
		Record model = new Record();
		model.setAmmont(Integer.parseInt(ammount));
		model.setCategory(category);
		model.setCreatedIn(TimeUtil.getDay(created));
		model.setLabel(label);
		model.setDescription(description);
		IRecDao fixture = (IRecDao) new RecDao();

		fixture.delete(model);
		return "{ \"msg\" : \"rec_deleted\" }";
	}

	@GET
	@Path("/record/by_category/{cat}")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchbycat(@PathParam("cat") String cat) {
		Category m = new Category();
		IRecDao fixture = (IRecDao) new RecDao();
		m = fixture.fetch(cat);

		return m.toString();
	}

	@GET
	@Path("/record/first")
	@Produces(MediaType.APPLICATION_JSON)
	public String FirstRec() {
		IRecDao fixture = (IRecDao) new RecDao();

		String m = fixture.getOne();
		return m;
	}

}