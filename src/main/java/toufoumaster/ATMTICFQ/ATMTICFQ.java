package toufoumaster.ATMTICFQ;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class ATMTICFQ implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint {
    public static final String MOD_ID = "atmticfq";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public final VintageQuestingATMTICFQPlugin VQPlugin = new VintageQuestingATMTICFQPlugin();
    @Override
    public void onInitialize() {
        LOGGER.info("atmticfq initialized.");
    }

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {
		VQPlugin.initializePlugin();
		Minecraft.getMinecraft().mainMenuBackground.deleteTextures();
	}
}
