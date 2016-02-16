package com.skyuhc.fr;

import org.bukkit.plugin.java.JavaPlugin;

import com.skyuhc.fr.events.EventsManager;

public class SkyUHC extends JavaPlugin
{
	private static SkyUHC instance;
	
	public void onEnable() 
	{
		instance = this;
		GameStats.setStats(GameStats.LOBBY);
		new EventsManager(this).registerEvents();
		saveDefaultConfig();
	}
	
	public void onDisable()
	{

	}
	
	public static SkyUHC getPlugin()
	{
		return instance;
	}
	
}
