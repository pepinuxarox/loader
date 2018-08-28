import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Controller.Ctrol;
import DTO.DOBDTO;
import DTO.EntityDTO;
import Model.DOB;
import Model.Entity;
import Model.GWL;

public class Execute {

	private static String nombreLista = null;
	private static Date fechaInicio;
	private static Date fechaFin;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (args[0] != null) {
				nombreLista = args[0];
			}
//			nombreLista="EDD";
			fechaInicio = new Date();
			System.out.println(fechaInicio + " Started...");

			Ctrol ctrol = new Ctrol();
			ctrol.SP_Historicos(nombreLista);

			File file = new File("C:\\Users\\Usuario\\Documents\\ENTITY.XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(GWL.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			GWL gwl = (GWL) jaxbUnmarshaller.unmarshal(file);

			System.out.println("Init Process");
			for (Entity e : gwl.getEntities().getEntity()) {
				EntityDTO eDTO = new EntityDTO();
				eDTO.setEntity(e);
				eDTO.setListType(nombreLista);

				ctrol.SP_entity(eDTO);
				if (e.getDobs() != null) {
					for (DOB dob : e.getDobs().getDob()) {
						DOBDTO dobDTO= new DOBDTO();
						dobDTO.setDob(dob);
						dobDTO.setId(Integer.toString(e.getId()));
						dobDTO.setListType(nombreLista);
						ctrol.SP_dob(dobDTO);
				}
				}
			}

			System.out.println("Fin del proceso");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
