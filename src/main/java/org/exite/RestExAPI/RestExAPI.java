package org.exite.RestExAPI;

import java.util.List;

import org.exite.obj.*;

public class RestExAPI implements IRestExAPI
{
	private final String url="https://api-service.edi.su/Api/Dixy/";	
	
	@Override
	public String authorize(String login, String pass) throws RestExAPIEcxeption
	{
		AuthorizeRequest req=new AuthorizeRequest(login, pass);
		AuthorizeResponse resp=(AuthorizeResponse)Http.post(url+"Index/Authorize", req , AuthorizeResponse.class);	
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.varToken;
	}	
	@Override
	public List<Company> getCompanies(String authToken, String varGln) throws RestExAPIEcxeption
	{		
		CompanyInfoRequest req=new CompanyInfoRequest(authToken, varGln);		
		CompanyInfoResponse resp=(CompanyInfoResponse)Http.post(url+"CompanyInfo/getData", req, CompanyInfoResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.COMPANIES;
	}
	@Override
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo) throws RestExAPIEcxeption
	{		
		TimeLineRequest req=new TimeLineRequest(authToken, timeFrom, timeTo);
		TimeLineResponse resp=(TimeLineResponse)Http.post(url+"TimeLine/GetTimeLine", req, TimeLineResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.timeline;
	}
	@Override
	public Entity getContent(String authToken, String docId) throws RestExAPIEcxeption
	{
		GetContentRequest req=new GetContentRequest(authToken, docId);
		GetContentResponse resp=(GetContentResponse)Http.post(url+"Content/GetBoth", req, GetContentResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return new Entity(resp.body, resp.sign);
	}
	@Override
	public String generateTicket(String varToken, 
			String identifier, 
			String signer_fname, 
			String signer_sname,
			String signer_position, 
			String signer_inn) throws RestExAPIEcxeption
	{
		CreateTicketRequest req=new CreateTicketRequest(varToken, identifier, signer_fname, signer_sname, signer_position, signer_inn);
		CreateTicketResponse resp=(CreateTicketResponse)Http.post(url+"Ticket/Generate", req, CreateTicketResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.content;
	}
	@Override
	public int sendTicket(String authToken, String docId, String docBody, String signBody) throws RestExAPIEcxeption
	{
		EnqueueTicketRequest req =new EnqueueTicketRequest(authToken, docId, docBody, signBody);
		EnqueueTicketResponse resp=(EnqueueTicketResponse)Http.post(url+"Ticket/Enqueue", req, EnqueueTicketResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.intCode;
	}
	@Override
	public String getPDFPrint(String varToken, String identifier) throws RestExAPIEcxeption 
	{
		GetPDFRequest req=new GetPDFRequest(varToken, identifier);
		GetPDFResponse resp=(GetPDFResponse)Http.post(url+"PrintForm/Generate", req, GetPDFResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.form;
	}
	@Override
	public DocumentInfo getDocInfo(String varToken, String identifier) throws RestExAPIEcxeption 
	{
		GetDocInfoRequest req = new GetDocInfoRequest(varToken, identifier);
		GetDocInfoResponse resp=(GetDocInfoResponse)Http.post(url+"TimeLine/GetDocData", req, GetDocInfoResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.document;
	}
	@Override
	public int sendDocument(String varToken, String docBody, String signBody, DocumentType docType)	throws RestExAPIEcxeption 
	{
		SendDocRequest req=new SendDocRequest(varToken, docBody, signBody, docType);
		SendDocResponse resp=(SendDocResponse)Http.post(url+"Document/Send", req, SendDocResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.intCode;
	}
	
}

