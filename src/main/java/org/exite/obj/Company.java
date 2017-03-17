package org.exite.obj;

import java.util.List;

public class Company
{
	public int intGlnID;
	public String varInnCode;
	public String varName;
	public String varGln;
	public int varRURegion;
	public String varStreet;
	public String varCity;
	public List<Guid>GUIDs;
	public Company() {	}
	@Override
	public String toString() {
		return "Company [intGlnID=" + intGlnID + ", varInnCode=" + varInnCode + ", varName=" + varName + ", varGln="
				+ varGln + ", varRURegion=" + varRURegion + ", varStreet=" + varStreet + ", varCity=" + varCity
				+ ", GUIDs=" + GUIDs + "]";
	}	
}