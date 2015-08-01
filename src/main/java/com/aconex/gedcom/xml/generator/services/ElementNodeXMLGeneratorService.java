/**
 * 
 */
package com.aconex.gedcom.xml.generator.services;

import com.aconex.gedcom.beans.Node;

/**
 * @author gupsh09
 *
 */
public class ElementNodeXMLGeneratorService implements IXMLGeneratorService {

	/* (non-Javadoc)
	 * @see com.aconex.gedcom.xml.generator.services.IXMLGeneratorService#generateXML(com.aconex.gedcom.beans.Node)
	 */
	@Override
	public String generateXML(Node node) {
		String nodeXml = new String("\n<" + node.getTagOrId() + ">" + node.getData() + "</" + node.getTagOrId() + ">");
		return nodeXml;
	}

}
