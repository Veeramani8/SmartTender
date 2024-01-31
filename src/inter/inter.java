package inter;


import bean.acceptbean;
import bean.contractorbean;
import bean.departbean;
import bean.departreport;
import bean.detailbean;
import bean.publiccom;
import bean.requestbean;
import bean.uploadbean;

public interface inter {
	public int dreg(departbean db);
	
	public boolean dlog(departbean lb);
	
	public int upload(uploadbean ub);
	
    public int detail(detailbean d);
    
    public int con(contractorbean cb);
	
    public boolean clog(contractorbean c);
    
    public int request(requestbean rb);

    public int accept(acceptbean ab);
    
    public int pub(publiccom pb);
    
    public int report(departreport dp);
}
