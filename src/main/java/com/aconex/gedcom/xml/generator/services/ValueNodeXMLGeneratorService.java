/**
 * 
 */
package com.aconex.gedcom.xml.generator.services;

import com.aconex.gedcom.beans.Node;

/**
 * @author gupsh09
 *
 */
public class ValueNodeXMLGeneratorService implements IXMLGeneratorService {

	@Override
	public String generateXML(Node node) {
		StringBuilder nodeXml = new StringBuilder();
		nodeXml.append("\n<").append(node.getTagOrId());
		nodeXml.append(" value=\"").append(node.getData()).append("\">");
		nodeXml.append(processChildNodes(node));
		nodeXml.append("\n</").append(node.getTagOrId()).append(">");
		return nodeXml.toString();
	}

}
