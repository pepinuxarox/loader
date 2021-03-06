package controller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ConnectDatabase;
import dto.DOBDTO;
import dto.EntityDTO;
import main.Execute;

public class Ctrol {


	private StringBuilder filter= new StringBuilder();
	
	
	public boolean spHistoricos(String listName) {
		ConnectDatabase connect = new ConnectDatabase();
		Statement state = null;
		boolean out = false;

		try {
			state = connect.getConnection().createStatement();
			filter.setLength(0);
			filter.append(" @type_list ='").append(listName).append("'");
			state.executeUpdate("SP_historicos".concat(filter.toString()));
			
		}catch (Exception e) {
			Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, e);
		} finally {
			if (state != null) {
				try {
					state.close();
					connect.connection.close();
					out =true;
				} catch (SQLException ex) {
					Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, ex);
				}
			}
		}		
		return out;		
	}
	
	public boolean spEntity(EntityDTO eDTO) {
		ConnectDatabase connect = new ConnectDatabase();
		Statement state = null;
		boolean out = false;

		try {
			state = connect.getConnection().createStatement();
			filter = new StringBuilder();
			filter.setLength(0);
			filter.append(" @Id ='").append(eDTO.getEntity().getId()).append("'");
			filter.append(",@Version ='").append(eDTO.getEntity().getVersion()).append("'");
			filter.append(",@Name ='").append(eDTO.getEntity().getName().replaceAll("'","")).append("'");
			filter.append(",@ListId ='").append(eDTO.getEntity().getListId()).append("'");
			filter.append(",@ListCode ='").append(eDTO.getEntity().getListCode().replaceAll("'","")).append("'");
			filter.append(",@EntityType ='").append(eDTO.getEntity().getEntityType()).append("'");		
			filter.append(",@CreatedDate ='").append(eDTO.getEntity().getCreatedDate().replaceAll("'","")).append("'");		
			filter.append(",@LastUpdateDate ='").append(eDTO.getEntity().getLastUpdateDate().replaceAll("'","")).append("'");		
			filter.append(",@Source ='").append(eDTO.getEntity().getSource().replaceAll("'","")).append("'");		
			filter.append(",@OriginalSource ='").append(eDTO.getEntity().getOriginalSource()).append("'");
			filter.append(",@list_type ='").append(eDTO.getListType()).append("'");
			state.executeQuery("SP_entity ".concat(filter.toString()));
							
		}catch (Exception e) {
			Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, e);
		} finally {
			if (state != null) {
				try {
					state.close();
					connect.connection.close();
					out =true;
				} catch (SQLException ex) {
					Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, ex);
				}
			}
		}		
		return out;		
	}
	
	public boolean spDob(DOBDTO dobDTO) {
		ConnectDatabase connect = new ConnectDatabase();
		Statement state = null;
		boolean out = false;

		try {
			state = connect.getConnection().createStatement();

			filter.setLength(0);
			filter.append(" @Id ='").append(dobDTO.getId()).append("'");
			filter.append(",@Dob ='").append(dobDTO.getDob().getValue()).append("'");
			filter.append(",@Dob_A ='").append(dobDTO.getDob().getA()).append("'");
			filter.append(",@Dob_D ='").append(dobDTO.getDob().getD()).append("'");
			filter.append(",@Dob_M ='").append(dobDTO.getDob().getM()).append("'");
			filter.append(",@Dob_Y ='").append(dobDTO.getDob().getY()).append("'");	
			filter.append(",@list_type ='").append(dobDTO.getListType()).append("'");
			state.executeQuery("SP_dob".concat(filter.toString()));
			
		}catch (Exception e) {
			Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, e);
		} finally {
			if (state != null) {
				try {
					state.close();
					connect.connection.close();
					out =true;
				} catch (SQLException ex) {
					Logger.getLogger(Execute.class.getName()).log(Level.SEVERE,null, ex);}
				
			}
		}		
		return out;		
	}
	
}
