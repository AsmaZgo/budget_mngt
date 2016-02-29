package servlets;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String message = "Budget mngt - Home";
		req.setAttribute("message", message); // This will be available as
												// ${message}
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, res);

	}
}
