package com.ninni.ninnis_caves;

import com.ninni.ninnis_caves.registry.NCVanillaIntegration;
import net.fabricmc.api.ClientModInitializer;

public class NinnisCavesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		NCVanillaIntegration.clientInit();
	}
}