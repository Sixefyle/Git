package com.skyuhc.fr.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.skyuhc.fr.GameStats;
import com.skyuhc.fr.runnable.LobbyRunnable;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		if(!GameStats.isState(GameStats.LOBBY))
		{
			return;
		}
		player.setGameMode(GameMode.ADVENTURE);
		player.getInventory().clear();
		
		if(Bukkit.getOnlinePlayers().size() >= 2 && LobbyRunnable.start == false)
		{
			LobbyRunnable.start = true;
			LobbyRunnable.getInstance().startTimer();
		}
	
	}
}
