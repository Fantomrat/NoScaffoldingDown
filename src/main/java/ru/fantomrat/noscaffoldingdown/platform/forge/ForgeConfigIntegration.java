package ru.fantomrat.noscaffoldingdown.platform.forge;
//? forge {
/*import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import ru.fantomrat.noscaffoldingdown.ModMain;
import ru.fantomrat.noscaffoldingdown.config.ModConfigScreen;

@Mod.EventBusSubscriber(
		modid = ModMain.MOD_ID,
		bus = Mod.EventBusSubscriber.Bus.MOD,
		value = Dist.CLIENT
)
public class ForgeConfigIntegration {

	private ForgeConfigIntegration() {
	}

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		if (ModList.get().isLoaded("cloth_config")) {
			ModLoadingContext.get().registerExtensionPoint(
					ConfigScreenHandler.ConfigScreenFactory.class,
					() -> new ConfigScreenHandler.ConfigScreenFactory(
							(mc, parent) -> ModConfigScreen.create(parent)
					)
			);
		} else {
			ModMain.LOGGER.warn("[No Scaffolding Down] Cloth Config is missing. The config screen will be unavailable.");
		}
	}
}
*///?}
