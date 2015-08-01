/**
 * 
 */
package com.aconex.gedcom.xml.generator.services;

import com.aconex.gedcom.beans.Node;

/**
 * @author gupsh09
 *
 */
public class IdNodeXMLGeneratorService implements IXMLGeneratorService {

	@Override
	public String generateXML(Node node) {
		StringBuilder nodeXml = new StringBuilder("\n<" + node.getData() + " id=\"" + node.getTagOrId() + "\">");
		if (node.getChildNodes().size() > 0)
			nodeXml.append(processChildNodes(node));
		nodeXml.append("\n</" + node.getData() + ">");
		return nodeXml.toString();
	}

}
