package com.tablist.fr;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.confuser.barapi.BarAPI;

public class Tablist extends JavaPlugin implements Listener{
	
	FileConfiguration config;
	
	public void onEnable() 
	{
		System.out.println("Le plugin IS-Tablist c'est lancer !");
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		config = getConfig();
	}
	
	public void onDisable() {
		System.out.println("Le plugin IS-Tablist c'est désactiver !");
	}

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		
		BarAPI.setMessage(config.getString("BossMessage").replace("&", "§").replace("{pseudo}", getName()));

		if(p.hasPermission("perms.admin"))
		{
			p.setPlayerListName(config.getString("Admin").replace("&", "§") + p.getName());
		} 
		else if(p.hasPermission("perms.vip"))
		{
			p.setPlayerListName(config.getString("VIP").replace("&", "§") + p.getName());
		}
		else if(p.hasPermission("perms.builder"))
		{
			p.setPlayerListName(config.getString("Builder").replace("&", "§") + p.getName());
		}
		else
		{
			p.setPlayerListName(config.getString("Joueur").replace("&", "§") + p.getName());
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		Player p = (Player) sender;
		if(p.hasPermission("is.reload"))
		{
			if(label.equalsIgnoreCase("isr"))
			{
				Bukkit.getPluginManager().disablePlugin(this);
				Bukkit.getPluginManager().enablePlugin(this);
				p.sendMessage("§aIS-Tablist reload !");
			}
		}
		else
		{
			p.sendMessage("§4Vous n'avez pas la permission.");
		}
		
		return false;
	}
	
}
