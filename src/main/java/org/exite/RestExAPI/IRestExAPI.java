package org.exite.RestExAPI;

import java.util.List;

public interface IRestExAPI 
{
	public String authorize(String login, String pass);	
	public List<Company>getCompanies(String authToken,String varGln); 
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo);
}
