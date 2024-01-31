package imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import dbcon.Database;





import bean.acceptbean;
import bean.contractorbean;
import bean.departbean;
import bean.departreport;
import bean.detailbean;
import bean.publiccom;
import bean.requestbean;
import bean.uploadbean;
import inter.inter;

public class imple implements  inter {
	Connection con;
	@Override
	public int dreg(departbean db) {
		int u=0;
		try{
		con=Database.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO contract.departreg VALUES(id,?,?,?,?)");
		ps.setString(1, db.getName());
		ps.setString(2, db.getDepartment());
		ps.setString(3, db.getPass());
		ps.setString(4, db.getConpass());

		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
}
	@Override
	public boolean dlog(departbean lb) {
		boolean b=false;
		try
		{
		
			con=Database.create();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM contract.departreg where name=? and department=? and password=?");
			ps.setString(1, lb.getName());
			ps.setString(2, lb.getDepartment());
			ps.setString(3, lb.getPass());
			
			ResultSet rs=ps.executeQuery();
			b=rs.next();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	@Override
	public int upload(uploadbean ub) {
		int u=0;
		try{
		con=Database.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO contract.upload VALUES(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, ub.getDepartment());
		ps.setString(2, ub.getDate());
		ps.setString(3, ub.getZone());
		  ps.setString(4,ub.getFilekey());
		ps.setString(5, ub.getFilename());
	    
	  
		ps.setString(6, ub.getFiletype());
		ps.setString(7, ub.getFilesize());
		ps.setString(8, ub.getFilecontent());
		ps.setString(9, ub.getEncrypt());
		ps.setString(10, ub.getDecrypt());
	
		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
}
	@Override
	public int detail(detailbean d) {
		int u=0;
		try{
		con=Database.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO `contract`.`govupload` VALUES(id,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, d.getDepartment());
		ps.setString(2,d.getDate());
		ps.setString(3, d.getZone());
		ps.setString(4, d.getAmount());
		ps.setString(5,d.getEdate()); 
		  ps.setString(6,d.getFilename());
		ps.setString(7, d.getFilekey());
	    
	  
		ps.setString(8, d.getProcessing());
		ps.setString(9, d.getApoint());
	
		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
}
	@Override
	public int con(contractorbean cb) {
		// TODO Auto-generated method stub
		int u=0;
	
		try{
			con=Database.create();	
			PreparedStatement ps = con.prepareStatement("INSERT INTO contract.contarctors  VALUES(id,?,?,?,?,?,?,?,?)");
			ps.setString(1, cb.getCname());
			ps.setString(2, cb.getEmail());
			ps.setString(3, cb.getNumber());
			ps.setString(4, cb.getPassword());
			ps.setString(5, cb.getConpassword()); 
			ps.setString(6, cb.getAddress());
			ps.setString(7, cb.getFilename());
			ps.setString(8, "Not Activate");
			u=ps.executeUpdate();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return u;
	}
	@Override
	public boolean clog(contractorbean c) {
		boolean b=false;
		try
		{
		
			con=Database.create();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `contract`.`contarctors` where companyname=? and pass=? and status=?" );
			ps.setString(1, c.getCname());;
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getStatus());
			ResultSet rs=ps.executeQuery();
			b=rs.next();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	@Override
	public int request(requestbean rb) {int u=0;
	
	try{
		con=Database.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO `contract`.`request` VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, rb.getId());
		ps.setString(2, rb.getDepart());
		ps.setString(3, rb.getDate());
		ps.setString(4, rb.getZone());
		ps.setString(5, rb.getAamount());
		ps.setString(6, rb.getDuration());
		ps.setString(7, rb.getRequest());
		ps.setString(8, rb.getCompanyname());
		ps.setString(9, "Requested");
		ps.setString(10, rb.getFilename());
		ps.setString(11, rb.getFiletype());
		ps.setString(12, rb.getFilesize());
		ps.setString(13, rb.getFilecontent());
		ps.setString(14, rb.getPhash());
		ps.setString(15, rb.getAhash());
		ps.setString(16, rb.getMail());
		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;

	}
	@Override
	public int accept(acceptbean ab) {
		int u=0;
		
		try{
			con=Database.create();	
			PreparedStatement ps = con.prepareStatement("INSERT INTO contract.reponse  VALUES(id,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, ab.getCname());
			ps.setString(2, ab.getDepert());
			ps.setString(3, ab.getAlocate());
			ps.setString(4, ab.getAsked());
			ps.setString(5, "Appointed");
			ps.setString(6, "waiting");
			ps.setString(7, ab.getPhash());
		    ps.setString(8, ab.getAhash());
		    ps.setString(9, ab.getMail());
		
			u=ps.executeUpdate();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return u;
	}
	@Override
	public int pub(publiccom pb) {
int u=0;
		
		try{
			con=Database.create();	
			PreparedStatement ps = con.prepareStatement("INSERT INTO contract.publiccom  VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pb.getCname());
			ps.setString(2, pb.getEmail());
			ps.setString(3, pb.getAddress());
			ps.setString(4, pb.getCompliantdate());
			ps.setString(5, pb.getMobile());
			ps.setString(6, pb.getZone());
			ps.setString(7, pb.getDepartment());
		    ps.setString(8, pb.getCtype());
		    ps.setString(9, pb.getStreet());
		    ps.setString(10, pb.getDescription());
		    ps.setString(11, pb.getFilename());
		    ps.setString(12, "Compliant");
		
			u=ps.executeUpdate();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return u;
	}
	@Override
	public int report(departreport dp) {
		int u=0;
		try{
		con=Database.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO contract.departde VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, dp.getEmail());
		ps.setString(2, dp.getRdate());
		ps.setString(3, dp.getZone());
		ps.setString(4, dp.getAddress());           
		ps.setString(5,dp.getDepartment());
	    ps.setString(6, dp.getCtype());
	    ps.setString(7,dp.getStatus());
	    ps.setString(8,dp.getDescription());
		ps.setString(9, dp.getFilename());
	    ps.setString(10, dp.getFiletype());
		ps.setString(11, dp.getFilesize());
		ps.setString(12, dp.getFilecontent());
		ps.setString(13, dp.getEncrypt());
		ps.setString(14, dp.getDecrypt());
		ps.setString(15, dp.getEstimate());
		ps.setString(16, dp.getDuration());
		ps.setString(17, dp.getAllocatedate());
		ps.setString(18, dp.getStatuss());
		ps.setString(19, dp.getCompanyname());
		ps.setString(20, dp.getRequestamt());
		ps.setString(21, dp.getPhash());
		ps.setString(22, dp.getAhash());
		ps.setString(23, dp.getUuid());
		
		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
}
}