package org.exite.RestExAPI;

import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpHost;
import org.exite.obj.*;

public class RestExAPI implements IRestExAPI
{
	private final String url="https://api-service.e-vo.ru/Api/Dixy/";
	public static HttpHost proxy=null; 
	
	public RestExAPI() {	}
	public RestExAPI(HttpHost proxy) 
	{	
		RestExAPI.proxy=proxy;
	}	
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
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo, EventListMode mode) throws RestExAPIEcxeption 
	{
		TimeLineRequest req=new TimeLineRequest(authToken, timeFrom, timeTo, mode);
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
			return getContentFNS_TRANS_DATA(authToken, docId);
		return new Entity(resp.body, resp.sign);
	}
	private Entity getContentFNS_TRANS_DATA(String authToken, String docId) throws RestExAPIEcxeption
	{
		GetContentFNSTRANSRequest req=new GetContentFNSTRANSRequest(authToken, docId);
		GetContentFNSTRANSResponse resp=(GetContentFNSTRANSResponse)Http.post(url+"Content/GetDocWithSignContent", req, GetContentFNSTRANSResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return new Entity(resp.body, resp.sign.get(0).body);
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
	public String generateReject(String authToken, 
			String identifier, 
			String signer_fname, 
			String signer_sname,
			String signer_position, 
			String signer_inn, 
			String comment) throws RestExAPIEcxeption 
	{
		CreateTicketRequest req=new CreateTicketRequest(authToken, identifier, signer_fname, signer_sname, signer_position, signer_inn, comment);
		CreateTicketResponse resp=(CreateTicketResponse)Http.post(url+"Ticket/Generate", req, CreateTicketResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.content;
	}
	@Override
	public String generateAnswer(String varToken, 
			String identifier, 
			String rec_date, 
			String rec_fname,
			String rec_patronymic, 
			String rec_position, 
			String rec_sname, 
			String signer_fname, 
			String signer_sname,
			String signer_position, 
			String signer_inn,
			String signer_patronymic) throws RestExAPIEcxeption 
	{
		CreateAnswerRequest req=new CreateAnswerRequest(varToken, identifier, rec_date, rec_fname, rec_patronymic, rec_position, rec_sname, signer_fname, signer_sname, signer_position, signer_inn,signer_patronymic);
		CreateAnswerResponse resp=(CreateAnswerResponse)Http.post(url+"Ticket/Generate", req, CreateAnswerResponse.class);
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
		Request req;
		if(Arrays.asList(DocumentType.ON_KORSCHFDOPPR,DocumentType.ON_SCHFDOPPR).contains(docType))
			req=new SendUPDRequest(varToken, docBody, signBody, docType);
		else
			req=new SendDocRequest(varToken, docBody, signBody, docType);
		SendDocResponse resp=(SendDocResponse)Http.post(url+"Document/Send", req, SendDocResponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.intCode;
	}
	@Override
	public String generateUPDAnswer(String authToken, 
			String identifier, 
			String signer_fname, 
			String signer_sname,
			String signer_position, 
			String signer_inn, 
			String rec_sodoper,
			String signer_osnpoln,
			int signer_oblpoln, 
			int signer_status) throws RestExAPIEcxeption 
	{
		CreateUPDAnswerRequest req = new CreateUPDAnswerRequest(authToken, identifier, signer_fname, signer_sname, signer_position, signer_inn, rec_sodoper, signer_osnpoln, signer_oblpoln, signer_status);
		CreateUPDAnswerRsponse resp=(CreateUPDAnswerRsponse)Http.post(url+"Ticket/Generate", req, CreateUPDAnswerRsponse.class);
		if(resp.intCode!=200)
			throw new RestExAPIEcxeption(resp.varMessage);
		return resp.content;
	}	
}

