package com.ninni.ninnis_caves;

import com.ninni.ninnis_caves.registry.NCVanillaIntegration;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class NinnisCavesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		NCVanillaIntegration.clientInit();
	}
}