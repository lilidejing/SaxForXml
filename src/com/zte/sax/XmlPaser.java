package com.zte.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.zte.entity.Userinfo;

public class XmlPaser extends DefaultHandler {

	Userinfo user;
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		user=new Userinfo();
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	String tagName=null;
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		if(tagName!=null){
			
			if("username".equals(tagName)){
				
				String username=new String(ch,start,length);
				user.setUsername(username);
			}
			else if("age".equals(tagName)){
				String age=new String(ch,start,length);
				user.setAge(Integer.parseInt(age));
			}
			else if("sex".equals(tagName)){
			
				String sex=new String(ch,start,length);
				user.setSex(sex);
			}
			else if("email".equals(tagName)){
				
				String email=new String(ch,start,length);
				user.setEmail(email);
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		tagName=null;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		tagName=localName;
		if("user".equals(tagName)){
			
			String id=attributes.getValue(0);
			user.setUid(id);
			String no=attributes.getValue(1);
			user.setStuNo(no);
		}
	}

}
