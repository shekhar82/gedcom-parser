/**
 * 
 */
package com.aconex.gedcom.xml.generator.services;

import com.aconex.gedcom.beans.Node;

/**
 * @author gupsh09
 *
 */
public class RootNodeXMLGeneratorService implements IXMLGeneratorService {

	/* (non-Javadoc)
	 * @see com.aconex.gedcom.xml.generator.services.IXMLGeneratorService#generateXML(com.aconex.gedcom.beans.Node)
	 */
	@Override
	public String generateXML(Node node) {
		StringBuilder xml = new StringBuilder();
		xml.append("<gedcom>");
		if (node.getChildNodes().size() > 0)
			xml.append(processChildNodes(node));
		xml.append("\n</gedcom>");
		return xml.toString();
	}

}
