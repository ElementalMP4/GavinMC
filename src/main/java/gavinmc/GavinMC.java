package main.java.gavinmc;

import java.util.Objects;

import org.bukkit.plugin.java.JavaPlugin;

public class GavinMC extends JavaPlugin {
    @Override
    public void onEnable() {
    	Objects.requireNonNull(getCommand("askgavin")).setExecutor(new AskGavinCommand());
        getLogger().info("Gavin is alive");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("Gavin has been slaughtered");
    }
}