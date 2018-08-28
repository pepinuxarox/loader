package Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


public class DOB {

	
	private String value;
	private String A;
	private String D;
	private String M;
	private String Y;
	
	
	
	public String getValue() {
		return value;
	}
	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}
	public String getA() {
		return A;
	}
	@XmlAttribute(name="A")
	public void setA(String a) {
		A = a;
	}
	public String getD() {
		return D;
	}
	@XmlAttribute(name="D")
	public void setD(String d) {
		D = d;
	}
	public String getM() {
		return M;
	}
	@XmlAttribute(name="M")
	public void setM(String m) {
		M = m;
	}
	public String getY() {
		return Y;
	}
	@XmlAttribute(name="Y")
	public void setY(String y) {
		Y = y;
	}
	@Override
	public String toString() {
		return "DOB [value=" + value + ", A=" + A + ", D=" + D + ", M=" + M + ", Y=" + Y + "]";
	}
	
	
	
}
