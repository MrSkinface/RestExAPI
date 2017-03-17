package org.exite.RestExAPI;

import java.util.List;

import org.exite.obj.*;

public interface IRestExAPI 
{
	/* @params:
	 * login	- 
	 * pass 	- 
	 * */
	public String authorize(String login, String pass) throws RestExAPIEcxeption;
	/* @params:
	 * authToken	- 
	 * varGln	 	- 
	 * */
	public List<Company>getCompanies(String authToken,String varGln) throws RestExAPIEcxeption; 
	/* @params:
	 * authToken	- 
	 * timeFrom	 	- 
	 * timeTo	 	- 
	 * */
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo) throws RestExAPIEcxeption;
	/* @params:
	 * authToken	- 
	 * docId	 	- 
	 * */
	public Entity getContent(String authToken, String docId) throws RestExAPIEcxeption;
	/* @params:
	 * authToken		- 
	 * identifier	 	- 
	 * signer_fname	 	- 
	 * signer_sname	 	- 
	 * signer_position	- 
	 * signer_inn	 	- 
	 * */
	public String generateTicket(String authToken,String identifier,String signer_fname,String signer_sname,String signer_position,String signer_inn) throws RestExAPIEcxeption;
	/* @params:
	 * authToken	- 
	 * docId	 	- 
	 * docBody	 	- 
	 * signBody	 	- 
	 * */
	public int sendTicket(String authToken, String docId, String docBody, String signBody) throws RestExAPIEcxeption;
	/* @params:
	 * authToken	- 
	 * identifier	 	- 
	 * */
	public String getPDFPrint(String authToken,String identifier) throws RestExAPIEcxeption;
	/* @params:
	 * authToken	- 
	 * identifier	 	- 
	 * */
	public DocumentInfo getDocInfo(String authToken,String identifier) throws RestExAPIEcxeption;
	/* @params:
	 * authToken	- 
	 * docBody	 	- 
	 * signBody	 	- 
	 * docType	 	- 
	 * */
	public int sendDocument(String authToken, String docBody, String signBody, DocumentType docType) throws RestExAPIEcxeption;
}
