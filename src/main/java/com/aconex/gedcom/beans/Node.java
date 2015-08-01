/**
 * 
 */
package com.aconex.gedcom.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Base node class that represents either id node, value node or an 
 * element node
 * @author gupsh09
 *
 */
public class Node {

	private int tagLevel;
	private String tagOrId;
	private String data;
	List<Node> childNodes = null;

	public Node(int level, String tagOrId, String data) {
		this.tagLevel = level;
		this.tagOrId = tagOrId;
		this.data = data;
		childNodes = new ArrayList<Node>();
	}

	public int getTagLevel() {
		return tagLevel;
	}

	public void setTagLevel(int tagLevel) {
		this.tagLevel = tagLevel;
	}

	public String getTagOrId() {
		return tagOrId;
	}

	public void setTagOrId(String tagOrId) {
		this.tagOrId = tagOrId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Node> getChildNodes() {
		return childNodes;
	}
	
	public void addChildNode(Node node)
	{
		this.childNodes.add(node);
	}

}
