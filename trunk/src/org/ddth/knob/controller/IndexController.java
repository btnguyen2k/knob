package org.ddth.knob.controller;

/**
 * Controller for action "index".
 * 
 * @author Thanh Ba Nguyen <btnguyen2k@gmail.com>
 * 
 */
public class IndexController extends BaseController {

	private final static String VIEW_NAME = "index";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}
}
