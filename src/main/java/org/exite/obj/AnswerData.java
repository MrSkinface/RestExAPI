package org.exite.obj;

public class AnswerData
{
	/**/
	public String rec_date; 
	public String rec_fname;
	public String rec_patronymic; 
	public String rec_position; 
	public String rec_sname; 
	public String signer_patronymic;
	/**/
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
	public AnswerData(String signer_fname,
			String signer_sname,
			String signer_position,
			String signer_inn,
			String signer_patronymic,
			String rec_date,	
			String rec_fname,
			String rec_patronymic,
			String rec_position,
			String rec_sname) 
	{	
		this.signer_fname=signer_fname;
		this.signer_sname=signer_sname;
		this.signer_position=signer_position;
		this.signer_inn=signer_inn;
		this.signer_patronymic=signer_patronymic;
		
		this.rec_date=rec_date;
		this.rec_fname=rec_fname;
		this.rec_patronymic=rec_patronymic;
		this.rec_position=rec_position;
		this.rec_sname=rec_sname;
		
				
	}
	@Override
	public String toString() {
		return "AnswerData [signer_fname=" + signer_fname + ", signer_inn=" + signer_inn + ", signer_position="
				+ signer_position + ", signer_sname=" + signer_sname + ", signer_oblpoln=" + signer_oblpoln
				+ ", signer_status=" + signer_status + ", signer_osnpoln=" + signer_osnpoln + ", rec_sodoper="
				+ rec_sodoper + "]";
	}	
}