package com.linkedin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet(urlPatterns = "/CatalogServlet", asyncSupported = true)
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(request.getParameter("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AsyncContext asyncContext = request.startAsync();
	asyncContext.start(new Runnable () {

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
				System.out.println("print the response");
				System.out.println("Response returned by:"+Thread.currentThread().getName());
				returnResponse(request,response);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  //End catch
            catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // End run 
		
	});
	System.out.println("Response returned by :"+Thread.currentThread().getName());
	}
	
	public void returnResponse(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");
		String sku = request.getParameter("sku");
		Catalog.addItem(new CatalogItem(name,manufacturer, sku));
		
		
		response.setHeader("someheader", "someHeaderValue");
		response.addCookie(new Cookie("someCookie","someCookieValue"));
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<table>");
		for (CatalogItem item   : Catalog.getItems()) {
			out.println("<tr>");
			out.println("<td>");
			out.println(item.getName());
			out.println("</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>"); 
	}

}
