package com.aconex.gedcom.parser.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.aconex.gedcom.beans.Node;
import com.aconex.gedcom.parser.XMLTree;

public class XMLTreeTest {

	@Test
	public void testRootElementIntialized()
	{
		XMLTree xmlTree = new XMLTree();
		assertNotNull(xmlTree.getRootNode());
	}
	
	@Test
	public void testRootElementConstructs()
	{
		XMLTree xmlTree = new XMLTree();
		Node node = xmlTree.getRootNode();
		assertEquals(node.getTagLevel(), -1);
		assertEquals(node.getTagOrId(), "gedcom");
		assertNull(node.getData());
	}
	
	@Test
	public void testXMLBuildTreeWithHigherLevelNode()
	{
		XMLTree xmlTree = new XMLTree();
		Node newHigherNodeOne = new Node(0,"name","data1");
		
		xmlTree.buildXMLTree(newHigherNodeOne);
		
		Node newHigherNodeTwo = new Node(1,"firstname", "data2");
		
		xmlTree.buildXMLTree(newHigherNodeTwo);
		
		
		Node rootNode = xmlTree.getRootNode();
		
		assertTrue(rootNode.getChildNodes().size() == 1);
		
		Node childNodeOne = rootNode.getChildNodes().get(0);
		
		assertTrue(childNodeOne.getChildNodes().size() == 1);
		
		
		Node childNodeTwo = childNodeOne.getChildNodes().get(0);
		
		assertTrue(childNodeTwo.getChildNodes().size() == 0);
		
		
		assertEquals(childNodeOne.getTagLevel(), 0);
		assertEquals(childNodeTwo.getTagLevel(), 1);
		
		assertEquals(childNodeOne.getTagOrId(), "name");
		assertEquals(childNodeTwo.getTagOrId(), "firstname");
		
		
		assertEquals(childNodeOne.getData(), "data1");
		assertEquals(childNodeTwo.getData(), "data2");
	}
	
	
	@Test
	public void testXMLBuildTreeWithTwoHigherNodes()
	{
		XMLTree xmlTree = new XMLTree();
		Node newHigherNodeOne = new Node(0,"name","data1");
		
		xmlTree.buildXMLTree(newHigherNodeOne);
		
		Node newHigherNodeTwo = new Node(0,"firstname", "data2");
		
		xmlTree.buildXMLTree(newHigherNodeTwo);
		
		
		Node rootNode = xmlTree.getRootNode();
		
		assertTrue(rootNode.getChildNodes().size() == 2);
		
		
	}

}
