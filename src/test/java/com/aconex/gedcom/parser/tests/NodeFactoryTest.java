package com.aconex.gedcom.parser.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aconex.gedcom.beans.Node;
import com.aconex.gedcom.exceptions.FileParsingException;
import com.aconex.gedcom.parser.NodeFactory;

public class NodeFactoryTest {

	private final static String ID_TEXT = "0 @I0001@ INDI";
	private final static String ELEM_TXT = "1 SEX F";
	private final static String TEXT_WITHOUT_DATA = "1 BIRT";
	private final static String WRONG_LEVEL_TXT = "HELLO NAME SHEKHAR";
	private final static String NO_TAG = "2";
	
	
	@Test
	public void testNodeFactoryForIDNode() throws FileParsingException
	{
		Node node = NodeFactory.getNode(ID_TEXT);
		assertNotNull(node);
		assertEquals(0,node.getTagLevel());
		assertEquals( "@I0001@",node.getTagOrId());
		assertEquals("INDI",node.getData());
	}
	
	@Test
	public void testNodeFactoryForELEMNode() throws FileParsingException
	{
		Node node = NodeFactory.getNode(ELEM_TXT);
		assertNotNull(node);
		assertEquals(1,node.getTagLevel());
		assertEquals( "SEX",node.getTagOrId());
		assertEquals("F",node.getData());
	}
	
	@Test
	public void testNodeFactoryForNodeWithoutData() throws FileParsingException
	{
		Node node = NodeFactory.getNode(TEXT_WITHOUT_DATA);
		assertNotNull(node);
		assertEquals(1,node.getTagLevel());
		assertEquals( "BIRT",node.getTagOrId());
		assertEquals("",node.getData());
	}
	
	@Test
	public void testNodeFactoryForNodeWrongLevelData() 
	{
		try {
			Node node = NodeFactory.getNode(WRONG_LEVEL_TXT);
			assertFalse("File parsing exception was expected", true);
		} catch (FileParsingException e) {
			assertTrue(true);
		}
		
		
	}
	
	@Test
	public void testNodeFactoryForNodeWrongData() 
	{
		try {
			Node node = NodeFactory.getNode(NO_TAG);
			assertFalse("File parsing exception was expected", true);
		} catch (FileParsingException e) {
			assertTrue(true);
		}
		
		
	}

}
