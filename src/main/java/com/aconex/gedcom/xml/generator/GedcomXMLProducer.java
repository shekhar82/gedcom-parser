/**
 * 
 */
package com.aconex.gedcom.xml.generator;

import com.aconex.gedcom.parser.XMLTree;
import com.aconex.gedcom.xml.generator.services.IXMLGeneratorService;
import com.aconex.gedcom.xml.generator.services.XMlGeneratorServiceFactory;

/**
 * @author gupsh09
 *
 */
public class GedcomXMLProducer {

	private XMLTree xmlTree;

	public GedcomXMLProducer(XMLTree xmlTree) {
		this.xmlTree = xmlTree;
	}

	public void setXmlTree(XMLTree xmlTree) {
		this.xmlTree = xmlTree;
	}

	public String getGedcomXML() {
		IXMLGeneratorService xmlGeneratorService = XMlGeneratorServiceFactory
				.getXMLGeneratorService(xmlTree.getRootNode());
		return xmlGeneratorService.generateXML(xmlTree.getRootNode());
	}

	public XMLTree getXmlTree() {
		return xmlTree;
	}

}
