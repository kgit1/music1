package aServlet;

import java.io.PrintWriter;

public class myServletA extends HttpServlet {

	public void doGet(HttpServlet request, HttpServlet response)
			throws ServletException, IOException {
		
		response.setContentType("text\html";)
		PrintWriter out = response.getWriter();
		
		String message = "If you can read it - It Works!"
				
				out.println("<HTML><BODY>");
			out.println("<H1>" + message + "</H1>");
			out.println("</BODY></HTML>");
			out.close();
			
	}
}
