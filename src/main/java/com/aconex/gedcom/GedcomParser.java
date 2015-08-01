package com.aconex.gedcom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import com.aconex.gedcom.parser.GedcomFileParser;
import com.aconex.gedcom.parser.XMLTree;
import com.aconex.gedcom.xml.generator.GedcomXMLProducer;

/**
 * 
 */

/**
 * @author gupsh09
 *
 */
public class GedcomParser {

	/**
	 * This is main class that should run convert Gedcom data into
	 * corresponding XML.
	 * 
	 * Gedcom file path can be passed from outside as command paramter.
	 * If no file would be provided, this program would use GEDCOM.txt
	 * file in resource folder
	 * @param args
	 */
	public static void main(String[] args) {
		String gedcomFilePath = null;
		if (args != null && args.length > 1)
			gedcomFilePath = args[0].trim();

		GedcomFileParser gedcomFileParser = null;

		try {
			if (gedcomFilePath != null)
				gedcomFileParser = new GedcomFileParser(gedcomFilePath);
			else
				gedcomFileParser = new GedcomFileParser();
			
			XMLTree xmlTree = gedcomFileParser.parseFile();
			
			GedcomXMLProducer xmlProducer = new GedcomXMLProducer(xmlTree);
			String gedcomXML = xmlProducer.getGedcomXML();
			
			System.out.println(gedcomXML);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
