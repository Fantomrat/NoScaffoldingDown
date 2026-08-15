package ru.fantomrat.noscaffoldingdown.platform.fabric;

//? fabric {

import ru.fantomrat.noscaffoldingdown.ModMain;
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
