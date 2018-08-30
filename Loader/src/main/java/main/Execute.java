package main;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import controller.Ctrol;
import dto.DOBDTO;
import dto.EntityDTO;
import model.DOB;
import model.Entity;
import model.GWL;

public class Execute {

	private static String nombreLista = null;
	private static Date fechaInicio=new Date();
	private static Date fechaFin=new Date();

	public static void main(String[] args) {
		try {
//			if (args[0] != null) {
//				nombreLista = args[0];
//			}
			nombreLista = "EDD";
			Ctrol ctrol = new Ctrol();
			ctrol.spHistoricos(nombreLista);

			File file = new File("C:\\Users\\Usuario\\Documents\\ENTITY.XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(GWL.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			GWL gwl = (GWL) jaxbUnmarshaller.unmarshal(file);

			Logger.getLogger(Execute.class.getName()).log(Level.INFO, "Init Process at");
			Logger.getLogger(Execute.class.getName()).log(Level.INFO,null, fechaInicio);
			
			for (Entity e : gwl.getEntities().getEntity()) {
				EntityDTO eDTO = new EntityDTO();
				eDTO.setEntity(e);
				eDTO.setListType(nombreLista);

				ctrol.spEntity(eDTO);
				if (e.getDobs() != null) {
					for (DOB dob : e.getDobs().getDob()) {
						DOBDTO dobDTO= new DOBDTO();
						dobDTO.setDob(dob);
						dobDTO.setId(Integer.toString(e.getId()));
						dobDTO.setListType(nombreLista);
						ctrol.spDob(dobDTO);
					}
				}
			}
			Logger.getLogger(Execute.class.getName()).log(Level.INFO, "Finalized at...");
			Logger.getLogger(Execute.class.getName()).log(Level.INFO, null,fechaFin);
			
		} catch (JAXBException e) {
			Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
