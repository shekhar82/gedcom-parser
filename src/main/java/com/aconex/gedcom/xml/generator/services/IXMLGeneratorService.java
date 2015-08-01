/**
 * 
 */
package com.aconex.gedcom.xml.generator.services;

import com.aconex.gedcom.beans.Node;

/**
 * @author gupsh09
 *
 */
public interface IXMLGeneratorService {

	public String generateXML(Node node);

	default public String processChildNodes(Node node) {
		StringBuilder sb = new StringBuilder();
		node.getChildNodes()
				.forEach(
						childNode -> {
							IXMLGeneratorService genService = XMlGeneratorServiceFactory
									.getXMLGeneratorService(childNode);
							sb.append(genService.generateXML(childNode));
						});

		return sb.toString();

	}
}
