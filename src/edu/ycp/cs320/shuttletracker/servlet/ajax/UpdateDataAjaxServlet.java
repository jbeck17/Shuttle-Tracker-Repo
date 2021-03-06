package edu.ycp.cs320.shuttletracker.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.ajax.JSON;

import edu.ycp.cs320.shuttletracker.controller.ShuttleTrackerController;

public class UpdateDataAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	private void doRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			String result;
		
			//ShuttleTracker model = new ShuttleTracker();
			ShuttleTrackerController controller = new ShuttleTrackerController();
			controller.getData();
			
			//result = Double.toString(controller.getLatitude());
			//result += " " + Double.toString(controller.getLongitude());
			result = controller.getLastLocations();
			//result = "{\"shuttle\":[{\"lat:\":123.123, \"lon:\"321.321}]}";
			
			//resp.setAttribute("locations", controller.getLastLocations());
			
			
			System.out.println("UpdateMap AJAX Reply: "+ result);
			resp.setContentType("text/plain");
			resp.getWriter().println(result);
	}
}