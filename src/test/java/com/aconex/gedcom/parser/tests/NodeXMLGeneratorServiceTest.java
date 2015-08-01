package com.aconex.gedcom.parser.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aconex.gedcom.beans.Node;
import com.aconex.gedcom.xml.generator.services.IXMLGeneratorService;
import com.aconex.gedcom.xml.generator.services.XMlGeneratorServiceFactory;

public class NodeXMLGeneratorServiceTest {
	private static final String BASIC_ROOT_NODE_XML = "<gedcom>\n</gedcom>";
	private static final String BASIC_ID_NODE_XML = "\n<indi id=\"@ID1@\">\n</indi>";
	private static final String BASIC_ELEM_NODE_XML = "\n<sex>M</sex>";
	private static final String BASIC_VAL_NODE_XML = "\n<name value=\"Jamis Gordon\">\n<surn>Buck</surn>\n</name>";
	private static final String BASIC_ALL_XML = "<gedcom>"
			+ "\n<indi id=\"@ID1@\">"
			+ "\n<name value=\"Jamis Gordon\">"
			+ "\n<surn>Buck</surn>"
			+ "\n<givn>Jamis Gordon</givn>"
			+ "\n</name>"
			+ "\n<sex>M</sex>"
			+ "\n</indi>"
			+ "\n</gedcom>";
	@Test
	public void testBasicRootXML() {
		Node rootNode = new Node(-1, "gedcom", null);
		
		IXMLGeneratorService rooNodeXMLGenerator = XMlGeneratorServiceFactory.getXMLGeneratorService(rootNode);
		
		assertEquals(BASIC_ROOT_NODE_XML,rooNodeXMLGenerator.generateXML(rootNode));
	}
	
	@Test
	public void testBasicIDNodeXML()
	{
		Node idNode = new Node(0,"@ID1@","indi");
		IXMLGeneratorService rooNodeXMLGenerator = XMlGeneratorServiceFactory.getXMLGeneratorService(idNode);
		assertEquals(BASIC_ID_NODE_XML,rooNodeXMLGenerator.generateXML(idNode));
		
	}
	
	@Test
	public void testBasicElemNodeXML()
	{
		Node elemNode = new Node(1,"sex","M");
		IXMLGeneratorService rooNodeXMLGenerator = XMlGeneratorServiceFactory.getXMLGeneratorService(elemNode);
		assertEquals(BASIC_ELEM_NODE_XML,rooNodeXMLGenerator.generateXML(elemNode));
	}
	
	@Test
	public void testBasicValueNodeXML()
	{
		Node valueNode = new Node(1,"name","Jamis Gordon");
		Node childNode = new Node(2,"surn","Buck");
		
		valueNode.addChildNode(childNode);
		IXMLGeneratorService rooNodeXMLGenerator = XMlGeneratorServiceFactory.getXMLGeneratorService(valueNode);
		assertEquals(BASIC_VAL_NODE_XML,rooNodeXMLGenerator.generateXML(valueNode));
		
	}
	
	@Test
	public void testBasicAllTest()
	{
		Node rootNode = new Node(-1, "gedcom", null);
		Node idNode = new Node(0,"@ID1@","indi");
		
		Node valueNode = new Node(1,"name","Jamis Gordon");
		Node valueChildNode1 = new Node(2,"surn","Buck");
		Node valueChildNode2 = new Node(2,"givn","Jamis Gordon");
		
		valueNode.addChildNode(valueChildNode1);
		valueNode.addChildNode(valueChildNode2);
		
		Node elemNode = new Node(1,"sex","M");
		idNode.addChildNode(valueNode);
		idNode.addChildNode(elemNode);
		
		rootNode.addChildNode(idNode);
		
		IXMLGeneratorService rooNodeXMLGenerator = XMlGeneratorServiceFactory.getXMLGeneratorService(rootNode);
		
		assertEquals(BASIC_ALL_XML,rooNodeXMLGenerator.generateXML(rootNode));
		
	}

}
