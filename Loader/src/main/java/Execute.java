import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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

			
			System.out.println("Inicia el proceso");
			for (Entity e : gwl.getEntities().getEntity()) {
				System.out.println(e.getName());
			}


			System.out.println("Fin del proceso");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
