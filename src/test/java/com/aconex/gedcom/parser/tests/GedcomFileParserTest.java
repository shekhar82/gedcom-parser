package com.aconex.gedcom.parser.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import com.aconex.gedcom.exceptions.FileParsingException;
import com.aconex.gedcom.parser.GedcomFileParser;
import com.aconex.gedcom.parser.XMLTree;

public class GedcomFileParserTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testParseFileWithNoFileException() {
		GedcomFileParser gedComParser = new GedcomFileParser("xyz");
		try {
			gedComParser.parseFile();
			assertFalse("Filenotfound exception was expected", true);
		} catch (IOException e) {
			assertTrue( "File not found exception was expected",e instanceof FileNotFoundException);
		} catch (FileParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testParseFile() {

		try {
			GedcomFileParser gedComParser = new GedcomFileParser();
			XMLTree xmlTree = gedComParser.parseFile();
			assertNotNull(xmlTree);
			assertNotNull(xmlTree.getRootNode());
			assertEquals(xmlTree.getRootNode().getTagLevel(), -1);

			assertTrue(xmlTree.getRootNode().getChildNodes().size() > 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
