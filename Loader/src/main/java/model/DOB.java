package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


public class DOB {

	
	private String value;
	private String a;
	private String d;
	private String m;
	private String y;
	
	
	
	public String getValue() {
		return value;
	}
	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}
	public String getA() {
		return a;
	}
	@XmlAttribute(name="A")
	public void setA(String a) {
		this.a = a;
	}
	public String getD() {
		return d;
	}
	@XmlAttribute(name="D")
	public void setD(String d) {
		this.d = d;
	}
	public String getM() {
		return m;
	}
	@XmlAttribute(name="M")
	public void setM(String m) {
		this.m = m;
	}
	public String getY() {
		return y;
	}
	@XmlAttribute(name="Y")
	public void setY(String y) {
		this.y = y;
	}
	
	
	
}
