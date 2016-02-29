package service;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import model.User;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.RequestWrapper;

import dao.IUserDao;
import dao.UserDao;

//The class registers its methods for the HTTP GET request using the @GET annotation.
//Using the @Produces annotation, it defines that it can deliver several MIME types,
//text, XML and HTML.

//The browser requests per default the HTML MIME type.

@Path("/data")
public class UserApi {

	static int tries;

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)

	public String GetAllUsers() {
		IUserDao fixture = (IUserDao) new UserDao();
		String result = fixture.getAll();
		return result;
	}

	@POST
	@Path("/user/{fname}/{lname}/{login}/{passwd}/{mail}/{role}/{tel}")
	@Produces(MediaType.APPLICATION_JSON)
	public String InsertUser(@PathParam("fname") String fname, @PathParam("lname") String lname,
			@PathParam("login") String login, @PathParam("passwd") String passwd, @PathParam("mail") String mail,
			@PathParam("role") String role, @PathParam("tel") String tel) {
		User model = new User();
		model.setFname(fname);
		model.setLname(lname);
		model.setLogin(login);
		model.setMail(mail);
		model.setPasswd(passwd);
		model.setRole(role);
		model.setTel(Integer.parseInt(tel));
		IUserDao fixture = (IUserDao) new UserDao();

		fixture.insert(model);
		return "user_created";
	}

	@POST
	@Path("/user/update/{fname}/{lname}/{login}/{passwd}/{mail}/{role}/{tel}")
	@Produces(MediaType.APPLICATION_JSON)
	public String UpdateUser(@PathParam("fname") String fname, @PathParam("lname") String lname,
			@PathParam("login") String login, @PathParam("passwd") String passwd, @PathParam("mail") String mail,
			@PathParam("role") String role, @PathParam("tel") String tel) {
		User model = new User();
		model.setFname(fname);
		model.setLname(lname);
		model.setLogin(login);
		model.setMail(mail);
		model.setPasswd(passwd);
		model.setRole(role);
		model.setTel(Integer.parseInt(tel));
		IUserDao fixture = (IUserDao) new UserDao();

		fixture.update(model);
		return "user_updated";
	}

	@DELETE
	@Path("/user/{fname}/{lname}/{login}/{passwd}/{mail}/{role}/{tel}")
	@Produces(MediaType.APPLICATION_JSON)
	public String DeleteUser(@PathParam("fname") String fname, @PathParam("lname") String lname,
			@PathParam("login") String login, @PathParam("passwd") String passwd, @PathParam("mail") String mail,
			@PathParam("role") String role, @PathParam("tel") String tel) {
		User model = new User();
		model.setFname(fname);
		model.setLname(lname);
		model.setLogin(login);
		model.setMail(mail);
		model.setPasswd(passwd);
		model.setRole(role);
		model.setTel(Integer.parseInt(tel));
		IUserDao fixture = (IUserDao) new UserDao();

		fixture.delete(model);
		return "user_deleted";
	}

	@GET
	@Path("/login/{login}/{passwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String Login(@PathParam("login") String login, @PathParam("passwd") String passwd) {
		IUserDao fixture = (IUserDao) new UserDao();

		String m = fixture.login(login, passwd);
		System.out.println(m.toString());
		return m.toString();
	}

	@GET
	@Path("/log")
	@Produces(MediaType.APPLICATION_JSON)

	public String Login1(@QueryParam("login") String login, @QueryParam("passwd") String passwd) {
		IUserDao fixture = (IUserDao) new UserDao();

		String m = fixture.login(login, passwd);
		if (m.isEmpty()) {
			System.out.println("gfhfdds");
			return "{ \"msg\" : \"error\" }";
		} else {
			System.out.println(m.toString());
			return m.toString();
		}
	}

	@GET
	@Path("/logger")
	@Produces(MediaType.APPLICATION_JSON)

	public Response Login3(@QueryParam("login") String login, @QueryParam("passwd") String passwd) {
		IUserDao fixture = (IUserDao) new UserDao();
		System.out.println(login);
		System.out.println(passwd);
		String m = fixture.login(login, passwd);
		System.out.println(m);
		if (m.isEmpty()) {
			System.out.println("gfhfdds");
			return Response.status(500).entity(m).build();
		} else {

			return Response.status(200).entity(m).build();
		}
	}

	@GET
	@Path("/loggerr")
	@Produces(MediaType.TEXT_HTML)

	public String Login2(@QueryParam("login") String login, @QueryParam("passwd") String passwd)
			throws URISyntaxException {
		IUserDao fixture = (IUserDao) new UserDao();
		System.out.println(login);
		System.out.println(passwd);
		String m = fixture.login(login, passwd);
		System.out.println("jhk" + m + "jjhh");
		if (m.isEmpty() || m.equals("")) {
			// tries ++;
			System.out.println("gfhfdds");

			// System.out.println(tries);
			java.net.URI location;
			/* if(tries==4){ */
			location = new java.net.URI("../index.html?msg=Try_again&nbtries=" + tries);
			/*
			 * }else{ location = new
			 * java.net.URI("../error.html?msg=please_register&nbtries="+tries);
			 * }
			 */
			// return Response.temporaryRedirect(location).status(500).build();

			// return "<html> " + "<title>" + "Error Jersey" + "</title>" +
			// "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";

			return "error";

		} else {
			// tries=0;
			java.net.URI location = new java.net.URI("../index2.html?msg=Welcome_manager");

			System.out.println(location);
			Response r = Response.temporaryRedirect(location).status(200).build();
			// return r;

			// return "<html> " + "<title>" + "Hello Jersey" + "</title>" +
			// "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
			// return
			// Response.temporaryRedirect(location).status(200).entity(m).build();
			// return Response.status(200).entity(m).build();
			return "ok";

		}
	}

	@GET
	@Path("/user/first")
	@Produces(MediaType.APPLICATION_JSON)
	public String FirstUser() {
		IUserDao fixture = (IUserDao) new UserDao();

		String m = fixture.getOne();
		return m;
	}

}