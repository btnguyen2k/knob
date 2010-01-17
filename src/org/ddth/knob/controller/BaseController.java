package org.ddth.knob.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ddth.knob.KnobConstants;
import org.ddth.mls.Language;
import org.ddth.mls.LanguageFactory;
import org.ddth.mls.utils.MlsException;
import org.ddth.panda.PandaConstants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public abstract class BaseController extends AbstractController {

	private final static Log LOGGER = LogFactory.getLog(BaseController.class);

	private HttpServletRequest httpRequest;

	private HttpServletResponse httpResponse;

	public final static String MODEL_LANGUAGE = "language";

	/**
	 * Gets the current Http request object.
	 * 
	 * @return HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {
		return this.httpRequest;
	}

	/**
	 * Gets the current Http response object.
	 * 
	 * @return HttpServletResponse
	 */
	protected HttpServletResponse getResponse() {
		return this.httpResponse;
	}

	/**
	 * Gets the Http Session object.
	 * 
	 * @return httpSession
	 */
	protected HttpSession getSession() {
		return getRequest().getSession(true);
	}

	/**
	 * Gets the LanguageFactory instance.
	 * 
	 * @return LanguageFactory
	 */
	protected LanguageFactory getLanguageFactory() {
		return getApplicationContext().getBean(
				KnobConstants.BEAN_LANGUAGE_FACTORY, LanguageFactory.class);
	}

	/**
	 * Gets the language object.
	 * 
	 * @return Language
	 */
	protected Language getLanguage() {
		HttpSession session = getSession();
		Language language = (Language) session
				.getAttribute(PandaConstants.SESSION_LANGUAGE);
		if (language == null) {
			LanguageFactory lf = getLanguageFactory();
			try {
				language = lf.getLanguage(PandaConstants.DEFAULT_LANGUAGE_NAME);
			} catch (MlsException e) {
				LOGGER.error("Can not retrieve language pack ["
						+ PandaConstants.DEFAULT_LANGUAGE_NAME + "]", e);
				return null;
			}
			session.setAttribute(PandaConstants.SESSION_LANGUAGE, language);
			session.setAttribute(PandaConstants.SESSION_LANGUAGE_NAME, language
					.getName());
		}
		return language;
	}

	/**
	 * Subclass must implement this method to return the view name.
	 * 
	 * @return String
	 */
	protected abstract String getViewName();

	/**
	 * Sets the Language model.
	 * 
	 * @param mav
	 *            ModelAndView
	 */
	protected void modelLanguage(ModelAndView mav) {
		mav.addObject(MODEL_LANGUAGE, getLanguage());
	}

	/**
	 * Subclass overrides this method to set its models.
	 * 
	 * @param mav
	 *            ModelAndView
	 */
	protected void modelInternal(ModelAndView mav) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.httpRequest = request;
		this.httpResponse = response;
		ModelAndView mav = new ModelAndView(getViewName());
		modelInternal(mav);
		return mav;
	}
}
