package it.geosolutions.geostore.services.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SessionToken {
	String token_type;
	String access_token;
	String refresh_token;
	
	Integer expires; 
	
	
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires() {
		return expires;
	}
	public void setExpires(Integer expires) {
		this.expires = expires;
	}
	public void setRefresh_Token(String refreshToken) {
		// TODO Auto-generated method stub
		
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
}
