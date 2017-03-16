package org.exite.RestExAPI;

import java.io.UnsupportedEncodingException;

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
