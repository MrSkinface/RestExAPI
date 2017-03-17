package org.exite.obj;

public class DocumentInfo
{
	public String doc_type;
	public String document_id;
	public String event_date;
	public String event_direction;
	public String file_name;
	public String recipient_id;
	public String sender_id;
	
	public DocumentInfo() {	}

	@Override
	public String toString() {
		return "DocumentInfo [doc_type=" + doc_type + ", document_id=" + document_id + ", event_date=" + event_date
				+ ", event_direction=" + event_direction + ", file_name=" + file_name + ", recipient_id=" + recipient_id
				+ ", sender_id=" + sender_id + "]";
	}	
}