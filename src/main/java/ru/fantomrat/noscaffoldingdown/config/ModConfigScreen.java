package ru.fantomrat.noscaffoldingdown.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import static ru.fantomrat.noscaffoldingdown.config.ModConfig.DEFAULT_LOOK_DOWN_ANGLE;
import static ru.fantomrat.noscaffoldingdown.config.ModConfig.MAX_LOOK_DOWN_ANGLE;
import static ru.fantomrat.noscaffoldingdown.config.ModConfig.MIN_LOOK_DOWN_ANGLE;

public final class ModConfigScreen {

	private ModConfigScreen() {
	}

	public static Screen create(Screen parent) {
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(Component.translatable(
						"noscaffoldingdown.config.title"
				));

		ConfigCategory general = builder.getOrCreateCategory(
				Component.translatable(
						"noscaffoldingdown.config.category.general"
				)
		);

		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		general.addEntry(
				entryBuilder.startFloatField(
								Component.translatable(
										"noscaffoldingdown.config.look_down_angle"
								),
								ModConfig.getLookDownAngle()
						)
						.setDefaultValue(DEFAULT_LOOK_DOWN_ANGLE)
						.setMin(MIN_LOOK_DOWN_ANGLE)
						.setMax(MAX_LOOK_DOWN_ANGLE)
						.setTooltip(
								Component.translatable(
										"noscaffoldingdown.config.look_down_angle.tooltip"
								)
						)
						.setSaveConsumer(ModConfig::setLookDownAngle)
						.build()
		);

		builder.setSavingRunnable(ModConfig::save);

		return builder.build();
	}
}
