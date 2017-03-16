package org.exite.RestExAPI;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public final class Http 
{
	public static Object post(String address,Object obj,Class<? extends Object> c)
	{		
		try 
		{
			HttpResponse<JsonNode> jsonResponse = Unirest.post(address)
					.header("accept", "application/json")
					.body(Utils.toJson(obj).getBytes("UTF-8"))
					.asJson();
			return Utils.fromJson(jsonResponse.getBody().toString(), c);
		} catch (UnsupportedEncodingException e) 
		{			
			e.printStackTrace();
		} catch (UnirestException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
class Request
{
	public String varToken;
	
	public Request() {}
	public Request(String varToken) 
	{
		this.varToken=varToken;
	}	
	@Override
	public String toString() {
		return "Request [varToken=" + varToken +"]";
	}	
}
class Response
{	
	public String varMessage;
	public int intCode;	
	@Override
	public String toString() {
		return "Response [varMessage=" + varMessage + ", intCode=" + intCode + "]";
	}	
}
class CompanyInfoRequest extends Request
{
	public String identifier;
	
	public CompanyInfoRequest() {	}
	public CompanyInfoRequest(String varToken, String identifier) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;		
	}
	@Override
	public String toString() {
		return "ConpanyInfoRequest [identifier=" + identifier + ", varToken=" + varToken + "]";
	}	
}
class CompanyInfoResponse extends Response
{
	public List<Company>COMPANIES;
	public CompanyInfoResponse() {	}
	@Override
	public String toString() {
		return "ConpanyInfoResponse [COMPANIES=" + COMPANIES + ", varMessage=" + varMessage + ", intCode=" + intCode
				+ "]";
	}	
}
class Company
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
class Guid
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
class TimeLineRequest extends Request
{
	public String timefrom;
	public String timeto;
	
	public TimeLineRequest() {	}
	public TimeLineRequest(String varToken, String timefrom,String timeto) 
	{	
		this.varToken=varToken;
		this.timefrom=timefrom;
		this.timeto=timeto;
	}
	@Override
	public String toString() {
		return "TimeLineRequest [timefrom=" + timefrom + ", timeto=" + timeto + "]";
	}	
}
class TimeLineResponse extends Response
{
	public List<Event>timeline;
	public TimeLineResponse() {	}
	@Override
	public String toString() {
		return "TimeLineResponse [timeline=" + timeline + ", varMessage=" + varMessage + ", intCode=" + intCode + "]";
	}	
}
class Event
{
	public String document_id;
	public String event_date;
	public String event_id;
	public String event_status;
	public String recipient_id;
	public String sender_id;
	public boolean need_reply_reciept;	
	public Event() {	}
	@Override
	public String toString() {
		return "Event [document_id=" + document_id + ", event_date=" + event_date + ", event_id=" + event_id
				+ ", event_status=" + event_status + ", recipient_id=" + recipient_id + ", sender_id=" + sender_id
				+ ", need_reply_reciept=" + need_reply_reciept + "]";
	}	
}
