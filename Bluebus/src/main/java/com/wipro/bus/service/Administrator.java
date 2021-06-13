package com.wipro.bus.service;
import com.wipro.bus.dao.ScheduleDAO;


import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;

public class Administrator {
	public String addSchedule(ScheduleBean scheduleBean)
	{
		ScheduleDAO b=new ScheduleDAO();
		String cg="";
		String res;
		if(scheduleBean.getSource()==scheduleBean.getDestination())
		{
			return "Source and Destination Same";
		}
		
		else
		{
			cg=b.generateID(scheduleBean.getSource(),scheduleBean.getDestination());
			scheduleBean.setScheduleId(cg);
			 res=b.createSchedule(scheduleBean) ;
		}
		return res;
	}
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination)
	{
		
		ScheduleDAO sd=new ScheduleDAO();
		ArrayList<ScheduleBean> arr=sd.viewSchedule(source,destination);
		return arr;
		
		
		
	}
}
