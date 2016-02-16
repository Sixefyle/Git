package com.skyuhc.fr.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventsManager 
{

	Plugin plugin;
	
	public EventsManager(Plugin plugin)
	{
		this.plugin = plugin;
	}
	
	public void registerEvents()
	{
		PluginManager pm = Bukkit.getPluginManager();
	}
	
}
