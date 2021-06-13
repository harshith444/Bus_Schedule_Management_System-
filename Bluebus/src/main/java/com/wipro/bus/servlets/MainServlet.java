package com.wipro.bus.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		if(operation.equals("newSchedule"))
		{
			String res;
			res=addSchedule(request);
			if(res.equals("SUCCESS"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("errorInserting.html");
				rd.forward(request, response);
			}
		}
		
		if(operation.equals("viewSchedule"))
		{
//			viewSchedule(request);	
			ArrayList<ScheduleBean> arr=new ArrayList<ScheduleBean>();
			arr = viewSchedule(request);
			if(!arr.isEmpty())
			{
				request.setAttribute("data", arr);
				RequestDispatcher rd = request.getRequestDispatcher("displaySchedule.jsp");
				rd.forward(request, response);
			}
			else
			{
				PrintWriter out =response.getWriter();
				out.println("No matching schedules exists! Please try again!");
			}
			
		}
		
		
	}
	
	public String addSchedule(HttpServletRequest request) {
		String res;
		ScheduleBean scheduleBean=new ScheduleBean();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String st=request.getParameter("st");
		String at=request.getParameter("at");
		
		scheduleBean.setSource(source);
		scheduleBean.setDestination(destination);
		scheduleBean.setStartTime(st);
		scheduleBean.setArrivalTime(at);
		
		
		Administrator admin=new Administrator();
		res= admin.addSchedule(scheduleBean);
		
		return res;
		}
	
	public ArrayList<ScheduleBean> viewSchedule(HttpServletRequest request)
	{
		Administrator admin=new Administrator();
		ArrayList<ScheduleBean> arr=new ArrayList<ScheduleBean>();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		arr= (admin.viewSchedule(source,destination));
		return arr;
		
		
	}

}
