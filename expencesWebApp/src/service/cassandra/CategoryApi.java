package service.cassandra;

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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.cassandra.CategDao;
import dao.cassandra.IRepository;

//The class registers its methods for the HTTP GET request using the @GET annotation.
//Using the @Produces annotation, it defines that it can deliver several MIME types,
//text, XML and HTML.

//The browser requests per default the HTML MIME type.

@Path("/cassandra")
public class CategoryApi {

	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)

	public String GetAllCats() {
		IRepository<Category> fixture = new CategDao();
		List<Category> lc = fixture.getAll();
		List<String> result = new ArrayList<String>();
		String t = null;
		for (Iterator iterator = lc.iterator(); iterator.hasNext();) {
			Category category = (Category) iterator.next();
			t = "{ \"ref\": \"" + category.getId() + "\", \"label\": \"" + category.getLabel() + "\", \"type\": \""
					+ category.getType() + "\", \"desc\": \"" + category.getDescription() + "\" }";
			result.add(t);
		}
		System.out.println(result);
		return result.toString();
	}

	@POST
	@Path("/category/{type}/{description}/{modified}/{label}")
	@Produces(MediaType.APPLICATION_JSON)
	public String InsertCat(@PathParam("type") String type, @PathParam("modified") String modified,
			@PathParam("description") String description, @PathParam("label") String label) {
		Category model = new Category();
		model.setType(type);

		model.setModifiedIn(TimeUtil.getDay(modified));
		model.setLabel(label);
		model.setDescription(description);
		IRepository<Category> fixture = new CategDao();

		fixture.insert(model);
		return "{ \"msg\" : \"cat_created\" }";
	}

	@POST
	@Path("/category/update/{type}/{description}/{modified}/{label}")
	@Produces(MediaType.APPLICATION_JSON)
	public String UpdateCat(@PathParam("type") String type, @PathParam("modified") String modified,
			@PathParam("description") String description, @PathParam("label") String label

	) {

		Category model = new Category();
		model.setType(type);
		model.setModifiedIn(TimeUtil.getDay(modified));
		model.setLabel(label);
		model.setDescription(description);
		IRepository<Category> fixture = new CategDao();

		fixture.insert(model);
		return "{ \"msg\" : \"cat_updated\" }";
	}

	@DELETE
	@Path("/category/{type}/{description}/{modified}/{label}")
	@Produces(MediaType.APPLICATION_JSON)
	public String DeleteCat(@PathParam("type") String type, @PathParam("modified") String modified,
			@PathParam("description") String description, @PathParam("label") String label) {
		Category model = new Category();
		model.setType(type);
		model.setModifiedIn(TimeUtil.getDay(modified));
		model.setLabel(label);
		model.setDescription(description);
		IRepository<Category> fixture = new CategDao();

		fixture.delete(model);
		return "{ \"msg\" : \"cat_deleted\" }";
	}

	/*
	 * @GET
	 * 
	 * @Path("/category/{type}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public String find(
	 * 
	 * @PathParam("type") String cat ) { List<Category> m = new
	 * ArrayList<Category>(); IRepository<Category> fixture = new CatDao(); m =
	 * fixture.fetch(cat);
	 * 
	 * return m.toString(); }
	 * 
	 * 
	 * @GET
	 * 
	 * @Path("/category/first")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public String FirstCat() {
	 * IRepository<Category> fixture = new CatDao();
	 * 
	 * String m= fixture.getOne(); return m; }
	 * 
	 */

}