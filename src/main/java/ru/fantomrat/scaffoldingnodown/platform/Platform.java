package ru.fantomrat.scaffoldingnodown.platform;

import java.nio.file.Path;

public interface Platform {
	boolean isModLoaded(String modId);

	ModLoader loader();

	String mcVersion();

	boolean isDevelopmentEnvironment();

	default boolean isDebug() {
		return isDevelopmentEnvironment();
	}

	Path configDir();

	enum ModLoader {
		FABRIC, NEOFORGE, FORGE, QUILT
	}
}
