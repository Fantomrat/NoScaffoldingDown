package ru.fantomrat.scaffoldingnodown.platform.fabric;

//? fabric {

import ru.fantomrat.scaffoldingnodown.ModMain;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		ModMain.onInitialize();
	}
}
//?}
