/**
 * 
 */
package com.aconex.gedcom.parser;

import java.util.Stack;

import com.aconex.gedcom.beans.Node;

/**
 * This is object that would be outcome of GEDCOM file parsing. It will have a
 * root element and all children item would come from parsing the file content
 * 
 * @author gupsh09
 *
 */
public class XMLTree {

	private Node rootNode = new Node(-1, "gedcom",null);

	private Stack<Node> nodesStack = new Stack<Node>();

	public Node getRootNode() {
		return rootNode;
	}

	public XMLTree() {
		this.nodesStack.push(rootNode);
	}

	public void buildXMLTree(Node node) {
		Node parentNode = this.nodesStack.peek();

		if (node.getTagLevel() > parentNode.getTagLevel()) {
			parentNode.addChildNode(node);
			this.nodesStack.push(node);
		} else {
			this.nodesStack.pop();
			buildXMLTree(node);
		}

	}
}
