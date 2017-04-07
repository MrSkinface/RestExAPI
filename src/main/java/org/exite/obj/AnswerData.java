package org.exite.obj;

public class AnswerData
{
	public String signer_fname;
	public String signer_inn;	
	public String signer_position;
	public String signer_sname;
	public int signer_oblpoln;
	public int signer_status;
	public String signer_osnpoln;
	public String rec_sodoper;		
	
	public AnswerData() {	}
	public AnswerData(String signer_fname,
			String signer_sname,
			String signer_position,
			String signer_inn,
			String rec_sodoper,	
			String signer_osnpoln,
			int signer_oblpoln,
			int signer_status) 
	{	
		this.signer_fname=signer_fname;
		this.signer_sname=signer_sname;
		this.signer_position=signer_position;
		this.signer_inn=signer_inn;
		this.rec_sodoper=rec_sodoper;
		this.signer_osnpoln=signer_osnpoln;
		this.signer_oblpoln=signer_oblpoln;
		this.signer_status=signer_status;
		
				
	}
	@Override
	public String toString() {
		return "AnswerData [signer_fname=" + signer_fname + ", signer_inn=" + signer_inn + ", signer_position="
				+ signer_position + ", signer_sname=" + signer_sname + ", signer_oblpoln=" + signer_oblpoln
				+ ", signer_status=" + signer_status + ", signer_osnpoln=" + signer_osnpoln + ", rec_sodoper="
				+ rec_sodoper + "]";
	}	
}