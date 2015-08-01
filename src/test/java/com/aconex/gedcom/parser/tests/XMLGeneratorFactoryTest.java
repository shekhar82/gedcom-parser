package com.aconex.gedcom.parser.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.aconex.gedcom.beans.Node;
import com.aconex.gedcom.xml.generator.services.ElementNodeXMLGeneratorService;
import com.aconex.gedcom.xml.generator.services.IXMLGeneratorService;
import com.aconex.gedcom.xml.generator.services.IdNodeXMLGeneratorService;
import com.aconex.gedcom.xml.generator.services.RootNodeXMLGeneratorService;
import com.aconex.gedcom.xml.generator.services.ValueNodeXMLGeneratorService;
import com.aconex.gedcom.xml.generator.services.XMlGeneratorServiceFactory;

public class XMLGeneratorFactoryTest {

	@Test
	public void testXMLGeneratorFactoryMethodForRootNode() {
		Node rootNode = new Node(-1,"gencom",null);
		IXMLGeneratorService xmlgenService = XMlGeneratorServiceFactory.getXMLGeneratorService(rootNode);
		assertNotNull(xmlgenService);
		assertTrue("Root XML Generator Service was expected",xmlgenService instanceof RootNodeXMLGeneratorService);
	}
	
	@Test
	public void testXMLGeneratorFactoryMethodForIDNode()
	{
		Node idNode = new Node(1,"@idOrTag@","ID-01");
		IXMLGeneratorService xmlgenService = XMlGeneratorServiceFactory.getXMLGeneratorService(idNode);
		assertNotNull(xmlgenService);
		assertTrue("ID Node XML Generator Service was expected",xmlgenService instanceof IdNodeXMLGeneratorService);
	}
	
	@Test
	public void testXMLGeneratorFactoryMethodForValueNode()
	{
		Node nameNode = new Node(1,"name","full name");
		Node firstNameNode = new Node(2,"firstname","shekhar");
		Node surNameNode = new Node(2, "surname","gupta");
		
		nameNode.addChildNode(firstNameNode);
		nameNode.addChildNode(surNameNode);
		
		IXMLGeneratorService xmlgenService = XMlGeneratorServiceFactory.getXMLGeneratorService(nameNode);
		assertNotNull(xmlgenService);
		assertTrue("Value Node XML Generator Service was expected",xmlgenService instanceof ValueNodeXMLGeneratorService);
	}
	
	@Test
	public void testXMLGeneratorFactoryMethodForElementNode()
	{
		Node elmNode = new Node(1,"sex","M");
		IXMLGeneratorService xmlgenService = XMlGeneratorServiceFactory.getXMLGeneratorService(elmNode);
		assertNotNull(xmlgenService);
		assertTrue("Element Node XML Generator Service was expected",xmlgenService instanceof ElementNodeXMLGeneratorService);
	}

}
