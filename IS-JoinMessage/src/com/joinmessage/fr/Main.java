package com.joinmessage.fr;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	FileConfiguration config;
	
	public void onEnable() {
		System.out.println("IS-JoinMessage activer");
		getServer().getPluginManager().registerEvents((Listener) this, this);
		saveDefaultConfig();
		config = getConfig();
	}
	
	public void onDisable() {
				
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{		
		Player p = e.getPlayer();
		e.setJoinMessage(config.getString("JoinMessage").replace("&", "§").replace("[pseudo]", p.getName()));
	}
}