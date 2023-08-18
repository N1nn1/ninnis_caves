package com.ninni.ninnis_caves;

import com.google.common.reflect.Reflection;
import com.ninni.ninnis_caves.registry.*;
import net.fabricmc.api.ModInitializer;

public class NinnisCaves implements ModInitializer {
	public static final String MOD_ID = "ninnis_caves";

	@Override
	public void onInitialize() {
		Reflection.initialize(
				NCBlocks.class,
				NCItems.class,
				NCCreativeModeTab.class,
				NCFeatures.class
		);

		NCVanillaIntegration.serverInit();
	}
}