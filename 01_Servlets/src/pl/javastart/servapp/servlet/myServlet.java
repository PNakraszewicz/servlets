package pl.javastart.servapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * Servlet implementation class myServlet
 */

public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public myServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String[]> parameterMap=request.getParameterMap();
		for (String key : parameterMap.keySet()){
			System.out.println(key);
			for (String value : parameterMap.get(key)){
				System.out.println(" -"+value);
			}
		}
	}

}
