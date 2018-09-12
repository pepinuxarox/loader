package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

public class Execute {

	public static void main(String[] args) {
		try {

			LineIterator it = IOUtils
					.lineIterator(new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\RELEASENOTES.TXT")));
			int count=0;
			List<String> ids=new ArrayList<String>();
			for (int lineNumber = 0; it.hasNext(); lineNumber++) {
				String line = (String) it.next();
				if (line.contains("Changes:"))
					
				for(int i=lineNumber+1; it.hasNext(); i++) {
					
					 line = (String) it.next();
					 
					String id=line.split("-")[0];
					if(!id.equals("Deletes:"))
						ids.add(id);
				}
			}
			
			

		} catch (Exception e) {
			Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
