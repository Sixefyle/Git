package com.joinmessage.fr;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class VaultAPI extends JavaPlugin implements Listener{

	FileConfiguration config;
	public static Economy economy = null;
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
		config = getConfig();
	}
	
    private boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    
    @EventHandler
    public void join(PlayerJoinEvent e){
    	
    	if(setupEconomy()){
    		
    		Player p = e.getPlayer();
    		double balance = economy.getBalance(p);
    		
    		if(balance <= 25){
    			p.sendMessage("§eVous n'avez pas d'argent sur votre compte, vous venez de recevoir un bonus de §630 SkillCoins");
    			economy.depositPlayer(p, 30.0);
    		}
    		
    		if(p.hasPlayedBefore() == false)
    		{
    			Bukkit.broadcastMessage(config.getString("FirstJoinMessage").replace("&", "§"));
    			p.sendMessage("§ePour votre premier connection, nous vous offrons §6200 SkillCoins. §eBon jeu sur §lIronSkillz !");
    			economy.depositPlayer(p, 30.0);
    		}
    		
    		
    	}
    	
    }
	
}