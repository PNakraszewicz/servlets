package pl.jwd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionServlet
 */

//login:adam_gr
//haslo: Kursjava
@WebServlet("/sessionServlet")
public class sessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		User user = (User) session.getAttribute("user");
		if(user == null || user.getName()==null || user.getSurname() ==null){
			user = new User();
			String name =request.getParameter("name");
			String surname =request.getParameter("surname");
			user.setName(name);
			user.setSurname(surname);
			session.setAttribute("user", user);
		}
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<h1>Test sesji</h1>");
		if (user.getName() != null && user.getSurname() != null){
			writer.println("<div>Witaj "+user.getName()+ " " +user.getSurname()+"</div>");
		}
		else{
			writer.println("Witaj nieznajomy");
		}
			
		writer.println("</html></body>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
