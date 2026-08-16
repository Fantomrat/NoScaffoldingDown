package ru.fantomrat.noscaffoldingdown.platform.neoforge;

//? neoforge {

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import ru.fantomrat.noscaffoldingdown.ModMain;
import net.neoforged.fml.common.Mod;
import ru.fantomrat.noscaffoldingdown.config.ModConfigScreen;

@Mod(ModMain.MOD_ID)
public class NeoforgeEntrypoint {

	public NeoforgeEntrypoint(ModContainer container) {
		ModMain.onInitialize();

		if (ModList.get().isLoaded("cloth_config")) {
			container.registerExtensionPoint(
					IConfigScreenFactory.class,
					(mc, parent) -> ModConfigScreen.create(parent)
			);
		} else {
			ModMain.LOGGER.warn("[No Scaffolding Down] Cloth Config is missing. The config screen will be unavailable.");
		}
	}
}
//?}
