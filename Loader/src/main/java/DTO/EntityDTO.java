package DTO;

import Model.Entity;

public class EntityDTO {
	
	
	private Entity entity;
	private String listType;
	
	public EntityDTO() {
		super();
	}
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	
	

}
