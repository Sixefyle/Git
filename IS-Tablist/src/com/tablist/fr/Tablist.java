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
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Tablist extends JavaPlugin implements Listener{
	
	FileConfiguration config;
	Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
	Team team = null;
	
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

	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		
		if(p.hasPermission("perms.admin"))
		{
			if(board.getTeam(p.getName()) == null) // si le joueur n'a pas de team alors on en crée une
			{
				team = board.registerNewTeam(p.getName()); // La team se nommera par sont pseudo
			}
			else
			{
				team = board.getTeam(p.getName()); // si non on prend la team avec sont pseudo
			}
			team.setPrefix(config.getString("Admin").replace("&", "§")); // On met en préfix ce que le joueur a mis dans sa config
			team.addPlayer(p); // on ajoute le joueur dans la team
			team.setAllowFriendlyFire(true); // on active le friendlyFire
			
			p.setPlayerListName(config.getString("Admin").replace("&", "§") + p.getName()); // Parreil sauf que c'est dans la TabList
		} 
		else if(p.hasPermission("perms.vip"))
		{
			if(board.getTeam(p.getName()) == null)
			{
				team = board.registerNewTeam(p.getName());
			}
			else
			{
				team = board.getTeam(p.getName());
			}
			team.setPrefix(config.getString("VIP").replace("&", "§"));
			team.addPlayer(p);
			team.setAllowFriendlyFire(true); 
			p.setPlayerListName(config.getString("VIP").replace("&", "§") + p.getName());
		}
		else if(p.hasPermission("perms.builder"))
		{
			if(board.getTeam(p.getName()) == null)
			{
				team = board.registerNewTeam(p.getName());
			}
			else
			{
				team = board.getTeam(p.getName());
			}
			team.setPrefix(config.getString("Builder").replace("&", "§"));
			team.addPlayer(p);
			team.setAllowFriendlyFire(true); 
			p.setPlayerListName(config.getString("Builder").replace("&", "§") + p.getName());
		}
		else
		{
			if(board.getTeam(p.getName()) == null)
			{
				team = board.registerNewTeam(p.getName());
			}
			else
			{
				team = board.getTeam(p.getName());
			}
			team.setPrefix(config.getString("Joueur").replace("&", "§"));
			team.addPlayer(p);
			team.setAllowFriendlyFire(true); 
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
