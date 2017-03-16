package org.exite.RestExAPI;

import java.util.List;

public class RestExAPI implements IRestExAPI
{
	private final String url="https://api-service.edi.su/Api/Dixy/";	
	
	@Override
	public String authorize(String login, String pass) 
	{
		AuthorizeRequest req=new AuthorizeRequest(login, pass);
		AuthorizeResponse resp=(AuthorizeResponse)Http.post(url+"Index/Authorize", req , AuthorizeResponse.class);				
		return resp.varToken;
	}
	@Override
	public List<Company> getCompanies(String authToken, String varGln) 
	{		
		CompanyInfoRequest req=new CompanyInfoRequest(authToken, varGln);		
		CompanyInfoResponse resp=(CompanyInfoResponse)Http.post(url+"CompanyInfo/getData", req, CompanyInfoResponse.class);
		return resp.COMPANIES;
	}
	@Override
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo) 
	{		
		TimeLineRequest req=new TimeLineRequest(authToken, timeFrom, timeTo);
		TimeLineResponse resp=(TimeLineResponse)Http.post(url+"TimeLine/GetTimeLine", req, TimeLineResponse.class);
		return resp.timeline;
	}
	@Override
	public Entity getContent(String authToken, String docId) 
	{
		GetContentRequest req=new GetContentRequest(authToken, docId);
		GetContentResponse resp=(GetContentResponse)Http.post(url+"Content/GetBoth", req, GetContentResponse.class);		
		return new Entity(resp.body, resp.sign);
	}
	@Override
	public String generateTicket(String varToken, 
			String identifier, 
			String signer_fname, 
			String signer_sname,
			String signer_position, 
			String signer_inn) 
	{
		CreateTicketRequest req=new CreateTicketRequest(varToken, identifier, signer_fname, signer_sname, signer_position, signer_inn);
		CreateTicketResponse resp=(CreateTicketResponse)Http.post(url+"Ticket/Generate", req, CreateTicketResponse.class);
		return resp.content;
	}
	@Override
	public int sendTicket(String authToken, String docId, String docBody, String signBody) 
	{
		EnqueueTicketRequest req =new EnqueueTicketRequest(authToken, docId, docBody, signBody);
		EnqueueTicketResponse resp=(EnqueueTicketResponse)Http.post(url+"Ticket/Enqueue", req, EnqueueTicketResponse.class);
		return resp.intCode;
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
