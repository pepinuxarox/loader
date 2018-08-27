package Controller;

import java.io.BufferedWriter;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ConnectDatabase;
import DTO.EntityDTO;

public class Ctrol {

	private ConnectDatabase connect = new ConnectDatabase();

	//private List<Case> caseList = new ArrayList<Case>();
	private StringBuilder filter= new StringBuilder();
	private BufferedWriter log;
	
	public boolean SP_entity(EntityDTO eDTO) {
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
			filter.append(",@OriginalSource ='").append(eDTO.getEntity().getOriginalSource().replaceAll("'","")).append("'");
			filter.append(",@list_type ='").append(eDTO.getListType()).append("'");
			state.executeQuery("SP_entity ".concat(filter.toString()));
			//logDet.write("SP_entity".concat(filter.toString()));
							
		}catch (Exception e) {
			//logDet.write("Error: " + e.getMessage());  
			System.out.println("error: " + e + "\n\n\n");
//			Logger.getLogger(QueryCasesServices.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			if (state != null) {
				try {
					state.close();
					connect.connection.close();
					out =true;
				} catch (SQLException ex) {
//					Logger.getLogger(QueryCasesServices.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}		
		return out;		
	}
	
	
	
}
