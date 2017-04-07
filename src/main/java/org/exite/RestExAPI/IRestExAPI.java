package org.exite.RestExAPI;

import java.util.List;

import org.exite.obj.*;

public interface IRestExAPI 
{
	/**
	 * 
	 * @param login
	 * 			Exite login
	 * @param pass
	 * 			Exite pass
	 * @return
	 * 			string authorize token
	 * @throws RestExAPIEcxeption
	 * 			if authorization fails
	 */
	public String authorize(String login, String pass) throws RestExAPIEcxeption;	
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param varGln
	 * 			GLN for which info we want to receive
	 * @return
	 * 			List of Company
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'varGln', bad 'authToken']
	 */
	public List<Company>getCompanies(String authToken,String varGln) throws RestExAPIEcxeption;	
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param timeFrom
	 * 			time from [YYYY-MM-dd HH:mm:ss]
	 * @param timeTo
	 * 			time to [YYYY-MM-dd HH:mm:ss]
	 * @return
	 * 			List of Event 
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'timeFrom', bad 'timeTo']
	 */
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param timeFrom
	 * 			time from [YYYY-MM-dd HH:mm:ss]
	 * @param timeTo
	 * 			time to [YYYY-MM-dd HH:mm:ss]
	 * @param mode
	 * 			one of EventListMode
	 * @return
	 * 			List of Event 
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'timeFrom', bad 'timeTo']
	 */
	public List<Event> getEvents(String authToken, String timeFrom, String timeTo, EventListMode mode) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param docId
	 * 			docId
	 * @return
	 * 			Entity
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'docId']
	 */
	public Entity getContent(String authToken, String docId) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param identifier
	 * 			identifier
	 * @param signer_fname
	 * 			signer_fname
	 * @param signer_sname
	 * 			signer_sname
	 * @param signer_position
	 * 			signer_position
	 * @param signer_inn
	 * 			signer_inn
	 * @return
	 * 			base64 string of xml-ticket
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'identifier']
	 */
	public String generateTicket(String authToken,String identifier,String signer_fname,String signer_sname,String signer_position,String signer_inn) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param docId
	 * 			docId
	 * @param docBody
	 * 			base64 string of xml-ticket
	 * @param signBody
	 * 			base64 string of digital signature
	 * @return
	 * 			integer code (200 == O.K., otherwise RestExAPIEcxeption will be thrown)
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'docId', bad 'docBody', bad 'signBody']
	 */
	public int sendTicket(String authToken, String docId, String docBody, String signBody) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param identifier
	 * 			identifier
	 * @return
	 * 			base64 string of PDF print data
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'identifier']
	 */
	public String getPDFPrint(String authToken,String identifier) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param identifier
	 * 			identifier
	 * @return
	 * 			DocumentInfo
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'identifier']
	 */
	public DocumentInfo getDocInfo(String authToken,String identifier) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param docBody
	 * 			base64 string of xml-ticket
	 * @param signBody
	 * 			base64 string of digital signature
	 * @param docType
	 * 			one of [ON_SCHFDOPPR, ON_KORSCHFDOPPR, ON_SFAKT, ON_KORSFAKT, DP_OTORG12, DP_IAKTPRM]
	 * @return
	 * 			integer code (200 == O.K., otherwise RestExAPIEcxeption will be thrown)
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'docType', bad 'docBody', bad 'signBody']
	 */
	public int sendDocument(String authToken, String docBody, String signBody, DocumentType docType) throws RestExAPIEcxeption;
	/**
	 * 
	 * @param authToken
	 * 			authorize token
	 * @param identifier
	 * 			identifier
	 * @param signer_fname
	 * 			signer_fname
	 * @param signer_sname
	 * 			signer_sname
	 * @param signer_position
	 * 			signer_position
	 * @param signer_inn
	 * 			signer_inn
	 * @param rec_sodoper
	 * 			rec_sodoper
	 * @param signer_osnpoln
	 * 			signer_osnpoln
	 * @param signer_oblpoln
	 * 			signer_oblpoln
	 * @param signer_status
	 * 			signer_status
	 * @return
	 * 			base64 string of xml-ticket
	 * @throws RestExAPIEcxeption
	 * 			if something goes wrong [bad 'authToken', bad 'identifier']
	 */
	public String generateUPDAnswer(String authToken, 
			String identifier, 
			String signer_fname, 
			String signer_sname,
			String signer_position, 
			String signer_inn, 
			String rec_sodoper,
			String signer_osnpoln,
			int signer_oblpoln, 
			int signer_status) throws RestExAPIEcxeption;
}
