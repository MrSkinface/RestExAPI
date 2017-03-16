package org.exite.RestExAPI;

import java.util.List;

public interface IRestExAPI 
{
	public String authorize(String login, String pass);	
	public List<Company>getCompanies(String authToken,String varGln); 
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo);
	public Entity getContent(String authToken, String docId);
	public String generateTicket(String varToken,String identifier,String signer_fname,String signer_sname,String signer_position,String signer_inn);
	public int sendTicket(String authToken, String docId, String docBody, String signBody);
}
