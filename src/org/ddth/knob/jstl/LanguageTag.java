package org.ddth.knob.jstl;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * JSTL custom tag: language
 * 
 * @author Thanh Ba Nguyen <btnguyen2k@gmail.com>
 * 
 */
public class LanguageTag implements Tag, Serializable {

	private PageContext pc = null;
	private Tag parent = null;
	private String name = null;

	public void setPageContext(PageContext p) {
		pc = p;
	}

	public void setParent(Tag t) {
		parent = t;
	}

	public Tag getParent() {
		return parent;
	}

	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public int doStartTag() throws JspException {
		try {
			if (name != null) {
				pc.getOut().write("Hello " + name + "!");
			} else {
				pc.getOut().write("You didn't enter your name");
				pc.getOut().write(", what are you afraid of ?");
			}

		} catch (IOException e) {
			throw new JspTagException("An IOException occurred.");
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public void release() {
		pc = null;
		parent = null;
		name = null;
	}
}