package main.java.gavinmc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class AskGavinCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) return false;
		String message = String.join(" ", args);
		String response = GavinResponseGetter.GetGavinResponse(message);
		Bukkit.broadcastMessage(sender.getName() + ChatColor.GREEN + " asked Gavin: " + ChatColor.YELLOW + message + "\n" +
				ChatColor.GREEN + "Gavin said: " + ChatColor.YELLOW + response);
		return true;
	}

}
