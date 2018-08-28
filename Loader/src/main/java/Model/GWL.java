package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gwl")
public class GWL {

	
	private String version;
	private Entities entities;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Entities getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
	}
	
	
}
