package Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="entity")
public class Entity {

	
	private int id;
	private String version;
	private String name;
	private String listId;
	private String listCode;
	private String entityType;
	private String createdDate;
	private String lastUpdateDate;
	private String source;
	private String OriginalSource;	
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	@XmlElement
	public String getListCode() {
		return listCode;
	}
	public void setListCode(String listCode) {
		this.listCode = listCode;
	}
	@XmlElement
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	@XmlElement
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@XmlElement
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	@XmlElement
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@XmlElement
	public String getOriginalSource() {
		return OriginalSource;
	}
	public void setOriginalSource(String originalSource) {
		OriginalSource = originalSource;
	}
	
	
	
}
