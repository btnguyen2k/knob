package org.ddth.knob.controller;

import org.ddth.mls.LanguageFactory;
import org.springframework.web.servlet.mvc.AbstractController;

public abstract class BaseController extends AbstractController {
	
	private LanguageFactory languageFactory;

	public LanguageFactory getLanguageFactory() {
		return languageFactory;
	}

	public void setLanguageFactory(LanguageFactory languageFactory) {
		this.languageFactory = languageFactory;
	}
		
	/*
	 * @Override protected ModelAndView handleRequestInternal(HttpServletRequest
	 * request, HttpServletResponse response) throws Exception { // TODO
	 * Auto-generated method stub return null; }
	 */
}
