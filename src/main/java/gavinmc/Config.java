package main.java.gavinmc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class Config {
	
	private GavinMC plugin = GavinMC.getPlugin(GavinMC.class);
	private Properties config = new Properties();
	
	public Config() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		File configFile = new File(plugin.getDataFolder(), "config.properties");
		
		if (configFile.exists()) {
			try (FileInputStream fis = new FileInputStream(configFile)){
				config.load(fis);
			} catch (IOException e) {
				plugin.getLogger().log(Level.SEVERE, "Couldn't read config file!");
			}		
		} else {
			plugin.getLogger().info("No config file found. Using defaults.");
		}
	}
	
	public String getURL() {
		String url = config.getProperty("url");
		return url == null ? "http://localhost:6970/chat_bot/" : url;
	}
	
	public String getNoResponseString() {
		String response = config.getProperty("error_string");
		return response == null ? "I have no idea" : response;
	}

}