package me.bush.instantdeepslate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class InstantDeepslate extends JavaPlugin {
    public static final Logger logger = LogManager.getLogger("InstantDeepslate");
    private TweakRegistry tweakRegistry;

    @Override
    public void onLoad() {
        this.tweakRegistry = new TweakRegistry();
    }

    @Override
    public void onEnable() {
        tweakRegistry.enableTweaks();
    }

    @Override
    public void onDisable() {
        tweakRegistry.disableTweaks();
    }
}
