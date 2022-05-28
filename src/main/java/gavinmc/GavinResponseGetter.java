package main.java.gavinmc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.json.JSONObject;

public class GavinResponseGetter {
	
	private static GavinMC plugin = GavinMC.getPlugin(GavinMC.class);
	private static Config config = new Config();

	private static String smackTheServer(String message) {
		try {
			
			String url = config.getURL();
			String payload = new JSONObject().put("data", message).toString();
			URL requestURL = new URL(url);
			HttpURLConnection con = (HttpURLConnection) requestURL.openConnection();
			
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setDoOutput(true);
			con.setRequestProperty("Accept", "application/json");
			
			OutputStream os = con.getOutputStream();
			byte[] input = payload.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));			
			String output = in.lines().collect(Collectors.joining());
			con.disconnect();
			
			return output;
			
		} catch (Exception e1) {
			plugin.getLogger().severe(e1.getMessage());
		}
		return config.getNoResponseString();
	}
	
	public static String GetGavinResponse(String message) {
		return smackTheServer(message);
	}

}
