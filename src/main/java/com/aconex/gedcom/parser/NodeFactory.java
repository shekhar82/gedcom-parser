/**
 * 
 */
package com.aconex.gedcom.parser;

import java.io.FileNotFoundException;

import com.aconex.gedcom.beans.Node;
import com.aconex.gedcom.exceptions.FileParsingException;

/**
 * Factory class that would create Id Node,
 *  Value node or Element node based on passed value of string from GEDCOM file
 * @author gupsh09
 *
 */
public class NodeFactory {

	public static Node getNode(String gedcomLine) throws FileParsingException {
		String[] strs = gedcomLine.split("\\s+", 3);
		Integer level = null;
		String tagOrIdStr = null;
		String valueStr = "";
		if (strs.length >= 1)
		{
			try {
				level = new Integer(strs[0]);
			} catch (NumberFormatException e) {
				throw new FileParsingException("Tag level is not defined correctly", e);
			}
		}
		if (strs.length >= 2)
			tagOrIdStr = strs[1];
		if (strs.length >= 3)
			valueStr = strs[2];
		
		if (level == null || tagOrIdStr == null)
			throw new FileParsingException("Parsing exception : " + gedcomLine);
		Node node = new Node(level,tagOrIdStr, valueStr);
		return node;
	}

}
