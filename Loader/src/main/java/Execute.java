import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Controller.Ctrol;
import DTO.EntityDTO;
import Model.Entity;
import Model.GWL;

public class Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			File file = new File("C:\\Users\\Usuario\\Documents\\ENTITY.XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(GWL.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			GWL gwl = (GWL) jaxbUnmarshaller.unmarshal(file);

			Ctrol ctrol= new Ctrol();
			System.out.println("Inicia el proceso");
			for (Entity e : gwl.getEntities().getEntity()) {
				EntityDTO eDTO= new EntityDTO();
				eDTO.setEntity(e);
				eDTO.setListType("EDD");
				
				ctrol.SP_entity(eDTO);
				
				System.out.println("Guardando"+e.getName());
			}


			System.out.println("Fin del proceso");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
