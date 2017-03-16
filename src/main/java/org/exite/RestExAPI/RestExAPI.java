package org.exite.RestExAPI;

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
