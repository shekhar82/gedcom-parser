/**
 * 
 */
package com.aconex.gedcom.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import com.aconex.gedcom.beans.Node;
import com.aconex.gedcom.exceptions.FileParsingException;

/**
 * This class is responsible to read a file line by line
 * It would use some Factory class to create nodes out of these lines.
 * @author gupsh09
 *
 */
public class GedcomFileParser
{
	private File file;
	
	public GedcomFileParser() throws URISyntaxException
	{
		URL resource = this.getClass().getClassLoader().getResource("GEDCOM.txt");
		file = new File(resource.toURI());
	}
	
	public GedcomFileParser(String filePath)
	{
		this.file = new File(filePath);
	}

	public XMLTree parseFile() throws IOException, FileParsingException
	{
		XMLTree xmlTree = new XMLTree();
		FileInputStream fstream = new FileInputStream(this.file);
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(fstream));
		
		String gedcomLine = null;
		while ((gedcomLine = bf.readLine()) != null)
		{
			Node node = NodeFactory.getNode(gedcomLine);
			xmlTree.buildXMLTree(node);
		}
		
		bf.close();
		return xmlTree;
		
	}
}
