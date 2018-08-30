package model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dobs")
public class DOBS {
	
	private List<DOB> dob;
	
	public List<DOB> getDob() {
		return dob;
	}

	public void setDob(List<DOB> dob) {
		this.dob = dob;
	}
	
	

}
