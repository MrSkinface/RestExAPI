package org.exite.obj;

public class UPDSign
{
	public String type;
	public String body;
	public UPDSign() {	}
	public UPDSign(String sign) 
	{	
		this.type="6";
		this.body=sign;
	}
	@Override
	public String toString() {
		return "UPDSign [type=" + type + ", body=" + body + "]";
	}	
}