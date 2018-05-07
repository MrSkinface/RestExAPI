package org.exite.RestExAPI;

import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.exite.obj.*;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class Http 
{
	public static Object post(String address,Object obj,Class<? extends Object> c)
	{
		try
		{
			HttpResponse<JsonNode> jsonResponse;
			if(RestExAPI.proxy != null){
				Unirest.setProxy(RestExAPI.proxy);
			}
			if(RestExAPI.trustAllCertificate){
				Unirest.setHttpClient(getTrustedClient());
			}
			jsonResponse = Unirest.post(address)
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
	private static CloseableHttpClient getTrustedClient(){
		try{
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					System.out.println("getAcceptedIssuers");
					return null;
				}
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
					System.out.println("checkClientTrusted");
				}
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
					System.out.println("checkServerTrusted");
				}
			} };
			SSLContext sslcontext = SSLContext.getInstance("SSL");
			sslcontext.init(null, trustAllCerts, null);
			HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			return httpclient;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
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
	public EventListMode mode;
	
	public TimeLineRequest() {	}
	public TimeLineRequest(String varToken, String timefrom,String timeto) 
	{	
		this.varToken=varToken;
		this.timefrom=timefrom;
		this.timeto=timeto;
	}
	public TimeLineRequest(String varToken, String timefrom,String timeto, EventListMode mode) 
	{	
		this.varToken=varToken;
		this.timefrom=timefrom;
		this.timeto=timeto;
		this.mode=mode;
	}
	@Override
	public String toString() {
		return "TimeLineRequest [timefrom=" + timefrom + ", timeto=" + timeto + ", mode=" + mode + ", varToken="
				+ varToken + "]";
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
class GetContentFNSTRANSRequest extends GetContentRequest 
{
	public GetContentFNSTRANSRequest() 
	{
		super();
	}
	public GetContentFNSTRANSRequest(String varToken, String identifier) 
	{
		super(varToken, identifier);
	}		
}
class GetContentFNSTRANSResponse extends Response	
{	
	public String body;
	public List<FnsTransSign> sign;
	public GetContentFNSTRANSResponse() {	}
	@Override
	public String toString() {
		return "GetContentFNSTRANSResponse [body=" + body + ", sign=" + sign + ", varMessage=" + varMessage
				+ ", intCode=" + intCode + "]";
	}		
}
class FnsTransSign
{
	public String body;
	public String type;
	@Override
	public String toString() {
		return "FnsTransSign [body=" + body + ", type=" + type + "]";
	}	
}
class CreateTicketRequest extends Request
{
	public String identifier;
	public String signer_fname;
	public String signer_sname;
	public String signer_position;
	public String signer_inn;
	public String comment;
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
	public CreateTicketRequest(String varToken,String identifier,String signer_fname,String signer_sname,String signer_position,String signer_inn,String comment) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;
		this.signer_fname=signer_fname;
		this.signer_sname=signer_sname;
		this.signer_position=signer_position;
		this.signer_inn=signer_inn;
		this.comment=comment;
	}
	@Override
	public String toString() {
		return "CreateTicketRequest [identifier=" + identifier + ", signer_fname=" + signer_fname + ", signer_sname="
				+ signer_sname + ", signer_position=" + signer_position + ", signer_inn=" + signer_inn + ", comment="
				+ comment + ", varToken=" + varToken + "]";
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
class CreateAnswerRequest extends Request
{
	public String identifier;
	public AnswerData answer_data;
	public CreateAnswerRequest() {	}
	public CreateAnswerRequest(String varToken, 
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
			String signer_patronymic) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;		
		this.answer_data=new AnswerData(signer_fname, signer_sname, signer_position, signer_inn, signer_patronymic, rec_date, rec_fname, rec_patronymic, rec_position, rec_sname);
	}
	@Override
	public String toString() {
		return "CreateAnswerRequest [identifier=" + identifier + ", answer_data=" + answer_data + ", varToken="
				+ varToken + "]";
	}	
}
class CreateAnswerResponse extends CreateTicketResponse {	}

class EnqueueTicketRequest extends Request
{
	public String identifier;
	public String xml;
	public String sign;
	public EnqueueTicketRequest() {	}
	public EnqueueTicketRequest(String varToken,String identifier,String xml,String sign) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;
		this.xml=xml;
		this.sign=sign;
	}
	@Override
	public String toString() {
		return "EnqueueTicketRequest [identifier=" + identifier + ", xml=" + xml + ", sign=" + sign
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
class SendUPDRequest extends Request
{
	public String body;
	public List<UPDSign> sign;
	public DocumentType doc_type;
	
	public SendUPDRequest() {	}
	public SendUPDRequest(String varToken, String body, DocumentType doc_type) 
	{	
		this.varToken=varToken;
		this.body=body;		
		this.doc_type=doc_type;	
	}
	public SendUPDRequest(String varToken, String body, String sign, DocumentType doc_type) 
	{	
		this.varToken=varToken;
		this.body=body;
		this.sign=new LinkedList<UPDSign>();
		this.sign.add(new UPDSign(sign));
		this.doc_type=doc_type;	
	}	
	@Override
	public String toString() {
		return "SendUPDRequest [body=" + body + ", sign=" + sign + ", doc_type=" + doc_type + "]";
	}	
}
class CreateUPDAnswerRequest extends Request
{
	public String identifier;
	public AnswerData answer_data;
	public CreateUPDAnswerRequest() {	}
	public CreateUPDAnswerRequest(String varToken,
			String identifier,
			String signer_fname,
			String signer_sname,
			String signer_position,
			String signer_inn,
			String rec_sodoper,	
			String signer_osnpoln,
			int signer_oblpoln,
			int signer_status) 
	{	
		this.varToken=varToken;
		this.identifier=identifier;
		this.answer_data=new AnswerData(signer_fname, signer_sname, signer_position, signer_inn, rec_sodoper, signer_osnpoln, signer_oblpoln, signer_status);
	}
	@Override
	public String toString() {
		return "CreateUPDAnswerRequest [identifier=" + identifier + ", answer_data=" + answer_data + ", varToken="
				+ varToken + "]";
	}		
}
class CreateUPDAnswerRsponse extends CreateTicketResponse 
{
	public CreateUPDAnswerRsponse() {	}
	@Override
	public String toString() {
		return "CreateUPDAnswerRsponse [content=" + content + ", varMessage=" + varMessage + ", intCode=" + intCode
				+ "]";
	}		
}

