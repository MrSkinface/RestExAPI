package org.exite.obj;

public class Entity
{
	public String body;
	public String sign;
	public Entity() {	}
	public Entity(String body,String sign) 
	{	
		this.body=body;
		this.sign=sign;
	}
	@Override
	public String toString() {
		return "Entity [body=" + body + ", sign=" + sign + "]";
	}	
}