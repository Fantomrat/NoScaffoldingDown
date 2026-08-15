package ru.fantomrat.noscaffoldingdown.platform.forge;

//? forge {

import net.minecraftforge.fml.common.Mod;
import ru.fantomrat.noscaffoldingdown.ModMain;

@Mod(ModMain.MOD_ID)
public class ForgeEntrypoint {

	public ForgeEntrypoint() {
		ModMain.onInitialize();
	}
}
//?}
