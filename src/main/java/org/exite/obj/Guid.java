package org.exite.obj;

public class Guid
{
	public String varGUID;
	public String varGuid;
	public String varName;
	public String varPrefix;
	public String varInnCode;
	public String varEdrpouCode;
	public Guid() {	}
	@Override
	public String toString() {
		return "Guid [varGUID=" + varGUID + ", varGuid=" + varGuid + ", varName=" + varName + ", varPrefix=" + varPrefix
				+ ", varInnCode=" + varInnCode + ", varEdrpouCode=" + varEdrpouCode + "]";
	}	
}