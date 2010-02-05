package org.ddth.knob;

import org.ddth.knob.bo.appconfig.AppConfigKey;

/**
 * Applcation configuration constants for Knob.
 * 
 * @author Thanh Ba Nguyen <btnguyen2k@gmail.com>
 * 
 */
public class KnobAppConfigConstants {
	public final static AppConfigKey CONFIG_PAGE_NAME = AppConfigKey
			.createAppConfigKey("SITE", "NAME");

	public final static AppConfigKey CONFIG_PAGE_TITLE = AppConfigKey
			.createAppConfigKey("SITE", "TITLE");

	public final static AppConfigKey CONFIG_PAGE_KEYWORDS = AppConfigKey
			.createAppConfigKey("SITE", "KEYWORDS");

	public final static AppConfigKey CONFIG_PAGE_DESCRIPTION = AppConfigKey
			.createAppConfigKey("SITE", "DESCRIPTION");
}
