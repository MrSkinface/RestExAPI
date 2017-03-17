package org.exite.RestExAPI;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.exite.obj.*;

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
class AuthorizeRequest
{
	public String varLogin;
	public String varPassword;
	
	public AuthorizeRequest() {	}
	public AuthorizeRequest(String varLogin, String varPassword) 
	{
		this.varLogin=varLogin;
		this.varPassword=varPassword;
	}
	@Override
	public String toString() {
		return "AuthorizeRequest [varLogin=" + varLogin + ", varPassword=" + varPassword + "]";
	}	
}
class AuthorizeResponse extends Response
{
	public String varToken;
	
	public AuthorizeResponse() {	}	
	@Override
	public String toString() {
		return "AuthorizeResponse [varToken=" + varToken + ", varMessage=" + varMessage + ", intCode=" + intCode + "]";
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
class GetContentRequest extends Request
{
	public String identifier;
	public GetContentRequest() {	}
	public GetContentRequest(String varToken, String identifier) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;
	}
	@Override
	public String toString() {
		return "GetContentRequest [identifier=" + identifier + ", varToken=" + varToken + "]";
	}	
}
class GetContentResponse extends Response	
{	
	public String body;
	public String sign;
	public GetContentResponse() {	}
	@Override
	public String toString() {
		return "GetContentResponse [body=" + body + ", sign=" + sign + ", varMessage=" + varMessage + ", intCode="
				+ intCode + "]";
	}	
}
class CreateTicketRequest extends Request
{
	public String identifier;
	public String signer_fname;
	public String signer_sname;
	public String signer_position;
	public String signer_inn;
	public CreateTicketRequest() {	}
	public CreateTicketRequest(String varToken,String identifier,String signer_fname,String signer_sname,String signer_position,String signer_inn) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;
		this.signer_fname=signer_fname;
		this.signer_sname=signer_sname;
		this.signer_position=signer_position;
		this.signer_inn=signer_inn;
	}
	@Override
	public String toString() {
		return "CreateTicketRequest [identifier=" + identifier + ", signer_fname=" + signer_fname + ", signer_sname="
				+ signer_sname + ", signer_position=" + signer_position + ", signer_inn=" + signer_inn + ", varToken="
				+ varToken + "]";
	}	
}
class CreateTicketResponse extends Response	
{
	public String content;
	public CreateTicketResponse() {	}
	@Override
	public String toString() {
		return "CreateTicketResponse [content=" + content + ", varMessage=" + varMessage + ", intCode=" + intCode + "]";
	}	
}
class EnqueueTicketRequest extends Request
{
	public String identifier;
	public String docBody;
	public String signBody;
	public EnqueueTicketRequest() {	}
	public EnqueueTicketRequest(String varToken,String identifier,String docBody,String signBody) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;
		this.docBody=docBody;
		this.signBody=signBody;
	}
	@Override
	public String toString() {
		return "EnqueueTicketRequest [identifier=" + identifier + ", docBody=" + docBody + ", signBody=" + signBody
				+ ", varToken=" + varToken + "]";
	}	
}
class EnqueueTicketResponse extends Response	{	}
class GetPDFRequest extends Request
{
	public String identifier;
	public GetPDFRequest() {	}
	public GetPDFRequest(String varToken,String identifier) 
	{
		this.varToken=varToken;
		this.identifier=identifier;
	}
	@Override
	public String toString() {
		return "GetPDFRequest [identifier=" + identifier + ", varToken=" + varToken + "]";
	}	
}
class GetPDFResponse extends Response
{
	public String form;
}
class GetDocInfoRequest extends Request
{
	public String identifier; 
	public GetDocInfoRequest() {	}
	public GetDocInfoRequest(String varToken,String identifier) 
	{
		this.varToken=varToken;
		this.identifier=identifier;
	}
	@Override
	public String toString() {
		return "GetDocInfoRequest [identifier=" + identifier + ", varToken=" + varToken + "]";
	}	
}
class GetDocInfoResponse extends Response
{
	public DocumentInfo document;
	public GetDocInfoResponse() {	}
	@Override
	public String toString() {
		return "GetDocInfoResponse [document=" + document + ", varMessage=" + varMessage + ", intCode=" + intCode + "]";
	}	
}
class SendDocRequest extends Request
{
	public String body;
	public String sign;
	public DocumentType doc_type;
	
	public SendDocRequest() {	}
	public SendDocRequest(String varToken,String body,String sign,DocumentType doc_type) 
	{	
		this.varToken=varToken;
		this.body=body;
		this.sign=sign;
		this.doc_type=doc_type;
	}
	@Override
	public String toString() {
		return "SendDocRequest [body=" + body + ", sign=" + sign + ", doc_type=" + doc_type + ", varToken=" + varToken
				+ "]";
	}		
}
class SendDocResponse extends Response {	}

