package ru.fantomrat.scaffoldingnodown.platform.fabric;

//? fabric {

import ru.fantomrat.scaffoldingnodown.ModMain;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ModMain.onInitializeClient();
	}

}
//?}
