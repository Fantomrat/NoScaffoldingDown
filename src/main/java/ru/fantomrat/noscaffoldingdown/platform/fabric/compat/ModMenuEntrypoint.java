package ru.fantomrat.noscaffoldingdown.platform.fabric.compat;

//? if fabric {
/*import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;
import ru.fantomrat.noscaffoldingdown.ModMain;
import ru.fantomrat.noscaffoldingdown.config.ModConfigScreen;

public final class ModMenuEntrypoint implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		if (!FabricLoader.getInstance().isModLoaded("cloth-config")) {
			ModMain.LOGGER.warn("[No Scaffolding Down] Mod Menu is installed, but Cloth Config is missing. The config screen will be unavailable.");
			return null;
		}

		return ModConfigScreen::create;
	}
}
*///?}
