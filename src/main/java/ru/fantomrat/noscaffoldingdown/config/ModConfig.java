package ru.fantomrat.noscaffoldingdown.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.toml.TomlFormat;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ModConfig {
	private static final String FILE_NAME = "modtemplate.toml";

	private static final float DEFAULT_LOOK_DOWN_ANGLE = 70.0F;
	private static final float MIN_LOOK_DOWN_ANGLE = -90.0F;
	private static final float MAX_LOOK_DOWN_ANGLE = 90.0F;

	private static float lookDownAngle = DEFAULT_LOOK_DOWN_ANGLE;

	private ModConfig() {
	}

	public static void load(Path configDirectory) {
		try {
			Files.createDirectories(configDirectory);

			Path path = configDirectory.resolve(FILE_NAME);

			CommentedFileConfig config = CommentedFileConfig.builder(
							path,
							TomlFormat.instance()
					)
					.preserveInsertionOrder()
					.build();

			config.load();

			Object rawValue = config.get("lookDownAngle");

			float value;

			if (rawValue instanceof Number number) {
				value = number.floatValue();
			} else {
				value = DEFAULT_LOOK_DOWN_ANGLE;
			}

			if (value < MIN_LOOK_DOWN_ANGLE || value > MAX_LOOK_DOWN_ANGLE) {
				value = DEFAULT_LOOK_DOWN_ANGLE;
			}

			config.set("lookDownAngle", value);

			config.setComment(
					"lookDownAngle",
					"Minimum X rotation required to be considered looking down. " +
							"0 = any downward rotation, 90 = looking straight down."
			);

			config.save();
			config.close();

			lookDownAngle = value;

		} catch (Exception e) {
			lookDownAngle = DEFAULT_LOOK_DOWN_ANGLE;

			System.err.println(
					"[ModTemplate] Failed to load config, using default value."
			);
			e.printStackTrace();
		}
	}

	public static float getLookDownAngle() {
		return lookDownAngle;
	}
}
