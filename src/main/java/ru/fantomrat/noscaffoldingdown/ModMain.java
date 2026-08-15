package ru.fantomrat.noscaffoldingdown;

import ru.fantomrat.noscaffoldingdown.config.ModConfig;
import ru.fantomrat.noscaffoldingdown.platform.Platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import ru.fantomrat.noscaffoldingdown.platform.fabric.FabricPlatform;
//?} neoforge {
/*import ru.fantomrat.noscaffoldingdown.platform.neoforge.NeoforgePlatform;
 *///?} forge {
/*import ru.fantomrat.noscaffoldingdown.platform.forge.ForgePlatform;
 *///?}

@SuppressWarnings("LoggingSimilarMessage")
public class ModMain {

	public static final String MOD_ID = /*$ mod_id*/ "noscaffoldingdown";
	public static final String MOD_VERSION = /*$ mod_version*/ "1.0.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Scaffolding No Down";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_ID, ModMain.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);

		ModConfig.load(xplat().configDir());
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}", MOD_ID, ModMain.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?} forge {
		/*return new ForgePlatform();
		 *///?}
	}
}
