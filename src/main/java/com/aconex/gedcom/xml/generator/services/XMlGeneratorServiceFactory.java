/**
 * 
 */
package com.aconex.gedcom.xml.generator.services;

import com.aconex.gedcom.beans.Node;

/**
 * Factory class to provide appropriate
 * XML generator services for differnet type of nodes.
 * @author gupsh09
 *
 */
public class XMlGeneratorServiceFactory {

	public static IXMLGeneratorService getXMLGeneratorService(Node node) {
		if (isRootNode(node))
			return new RootNodeXMLGeneratorService();
		if (isIDNode(node))
			return new IdNodeXMLGeneratorService();
		if (isValueNode(node))
			return new ValueNodeXMLGeneratorService();
		if (isElementNode(node))
			return new ElementNodeXMLGeneratorService();
		
		//TODO throw an exception
		return null;
	}
	
	
	private static boolean isRootNode(Node node)
	{
		if (node.getTagLevel() == -1)
			return true;
		return false;
	}
	
	private static boolean isIDNode(Node node)
	{
		if (node.getTagOrId().startsWith("@") && node.getTagOrId().endsWith("@"))
			return true;
		return false;
	}
	
	private static boolean isValueNode(Node node)
	{
		if (node.getChildNodes().size() > 0)
			return true;
		return false;
	}
	
	private static boolean isElementNode(Node node)
	{
		if (node.getChildNodes().size() == 0)
			return true;
		return false;
	}

}
