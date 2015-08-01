package com.aconex.gedcom.parser.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.aconex.gedcom.beans.Node;
import com.aconex.gedcom.parser.XMLTree;
import com.aconex.gedcom.xml.generator.GedcomXMLProducer;

public class GedcomXMLProducerTest {

	private static final String BASIC_ROOT_NODE_XML = "<gedcom>\n</gedcom>";
	private static final String BASIC_ALL_XML = "<gedcom>"
			+ "\n<indi id=\"@ID1@\">"
			+ "\n<name value=\"Jamis Gordon\">"
			+ "\n<surn>Buck</surn>"
			+ "\n<givn>Jamis Gordon</givn>"
			+ "\n</name>"
			+ "\n<sex>M</sex>"
			+ "\n</indi>"
			+ "\n</gedcom>";
	private GedcomXMLProducer xmlProducer = null;
	
	@Before
	public void setUp() throws Exception
	{
		XMLTree xmlTree = new XMLTree();
		xmlProducer = new GedcomXMLProducer(xmlTree);
	}

	@Test
	public void testEmptyXMLTree() 
	{
		String gedcomXML = this.xmlProducer.getGedcomXML();
		assertEquals(BASIC_ROOT_NODE_XML,gedcomXML);
	}
	
	@Test
	public void testBasicAllNodesTest()
	{
		Node idNode = new Node(0,"@ID1@","indi");
		
		Node valueNode = new Node(1,"name","Jamis Gordon");
		Node valueChildNode1 = new Node(2,"surn","Buck");
		Node valueChildNode2 = new Node(2,"givn","Jamis Gordon");
		
		valueNode.addChildNode(valueChildNode1);
		valueNode.addChildNode(valueChildNode2);
		
		Node elemNode = new Node(1,"sex","M");
		idNode.addChildNode(valueNode);
		idNode.addChildNode(elemNode);
		
		this.xmlProducer.getXmlTree().buildXMLTree(idNode);
		String gedcomXML = this.xmlProducer.getGedcomXML();
		assertEquals(BASIC_ALL_XML, gedcomXML);
	}

}
