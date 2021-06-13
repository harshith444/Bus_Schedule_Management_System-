package com.wipro.bus.dao;
import com.wipro.bus.util.DBUtil;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wipro.bus.bean.ScheduleBean;

public class ScheduleDAO {
	public String createSchedule(ScheduleBean scheduleBean)
	{
		DBUtil da= new DBUtil();
		try {
			Connection con=da.getDBConnection();
			String s="insert into SCHEDULE_TBL values(?,?,?,?,?)";
			Statement stmt=con.createStatement();
			stmt.executeUpdate("update sequence set id=LAST_INSERT_ID(id+1)");
			PreparedStatement pstmt=da.getDBConnection().prepareStatement(s);
			pstmt.setString(1, scheduleBean.getScheduleId());
			pstmt.setString(2, scheduleBean.getSource());
			pstmt.setString(3, scheduleBean.getDestination());
			pstmt.setString(4, scheduleBean.getStartTime());
			pstmt.setString(5, scheduleBean.getArrivalTime());
			
			if(pstmt.executeUpdate()!= 0)
			{
				return "SUCCESS";
			}
			
		} catch (SQLException e) {
	       System.out.println(e);
	       
		}
		return "Not inserted try again";		
	}
	public String generateID(String source, String destination)
	{
		DBUtil da= new DBUtil();
		String k="";
		String s1=source.substring(0,2);
		String s2=destination.substring(0,2);
        k=s1.toUpperCase()+s2.toUpperCase();
		String sql="SELECT id FROM sequence ORDER BY id DESC LIMIT 1";
		
		try {
			Statement stmt=da.getDBConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Hi");
			int c=0;
			
			while(rs.next())
			{
				c=rs.getInt(1);
			}
;			
		
			k+=String.valueOf(c);
			System.out.println(k);
			return k;
		} catch (SQLException e) {
			System.out.println("Seq error");
			return "";
		}
		
	}
	
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination)
	{
		DBUtil db= new DBUtil();
		System.out.println(source+destination);
		
		ArrayList<ScheduleBean> arr=new ArrayList<ScheduleBean>();
		String sql="select * from schedule_tbl where source=? and destination=?";
		try {
			Connection con=db.getDBConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			//System.out.println("hi");
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				
				ScheduleBean sb =new ScheduleBean();
				sb.setScheduleId(rs.getString(1));
				sb.setSource(rs.getString(2));
				sb.setDestination(rs.getString(3));
				sb.setStartTime(rs.getString(4));
				sb.setArrivalTime(rs.getString(5));
				arr.add(sb);
			}
		}
		catch(Exception e)
		{
			System.out.println("error at SchdeuleDAO not records found");
		}
		return arr;
	}


}