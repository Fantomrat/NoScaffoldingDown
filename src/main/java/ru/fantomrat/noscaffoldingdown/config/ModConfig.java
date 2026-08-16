package ru.fantomrat.noscaffoldingdown.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.toml.TomlFormat;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ModConfig {
	public static final String FILE_NAME = "noscaffoldingdown.toml";

	public static final float DEFAULT_LOOK_DOWN_ANGLE = 70.0F;
	public static final float MIN_LOOK_DOWN_ANGLE = -90.0F;
	public static final float MAX_LOOK_DOWN_ANGLE = 90.0F;

	private static float lookDownAngle = DEFAULT_LOOK_DOWN_ANGLE;
	private static Path configPath;

	private ModConfig() {
	}

	public static void load(Path configDirectory) {
		try {
			Files.createDirectories(configDirectory);

			configPath = configDirectory.resolve(FILE_NAME);

			CommentedFileConfig config = CommentedFileConfig.builder(
							configPath,
							TomlFormat.instance()
					)
					.preserveInsertionOrder()
					.build();

			config.load();

			Object rawValue = config.get("lookDownAngle");

			float value = rawValue instanceof Number number
					? number.floatValue()
					: DEFAULT_LOOK_DOWN_ANGLE;

			value = clamp(value);

			config.set("lookDownAngle", value);

			config.setComment(
					"lookDownAngle",
					"Minimum downward look angle required to descend from scaffolding. " +
							"0 = looking straight ahead, 90 = looking straight down."
			);

			config.save();
			config.close();

			lookDownAngle = value;

		} catch (Exception e) {
			lookDownAngle = DEFAULT_LOOK_DOWN_ANGLE;

			System.err.println(
					"[NoScaffoldingDown] Failed to load config, using default value."
			);
			e.printStackTrace();
		}
	}

	public static float getLookDownAngle() {
		return lookDownAngle;
	}

	public static void setLookDownAngle(float value) {
		lookDownAngle = clamp(value);
	}

	public static void save() {
		if (configPath == null) {
			return;
		}

		try {
			CommentedFileConfig config = CommentedFileConfig.builder(
							configPath,
							TomlFormat.instance()
					)
					.preserveInsertionOrder()
					.build();

			config.load();

			config.set("lookDownAngle", lookDownAngle);

			config.setComment(
					"lookDownAngle",
					"Minimum downward look angle required to descend from scaffolding. " +
							"0 = looking straight ahead, 90 = looking straight down."
			);

			config.save();
			config.close();

		} catch (Exception e) {
			System.err.println(
					"[NoScaffoldingDown] Failed to save config."
			);
			e.printStackTrace();
		}
	}

	private static float clamp(float value) {
		return Math.max(
				MIN_LOOK_DOWN_ANGLE,
				Math.min(MAX_LOOK_DOWN_ANGLE, value)
		);
	}
}
