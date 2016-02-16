package com.skyuhc.fr.runnable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.util.permissions.BroadcastPermissions;

import com.skyuhc.fr.SkyUHC;

public class LobbyRunnable {
	
	static LobbyRunnable instance = new LobbyRunnable();
	private LobbyRunnable(){}
	public static LobbyRunnable getInstance()
	{
		return instance;
	}
	
	public static boolean start = false;
	
	private int task;
	private int timer = 60; //CountDown timer
	
	public void startTimer()
	{
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyUHC.getPlugin(), new Runnable() 
		{
			@Override
			public void run() {
				if(timer == 90 || timer == 60 || timer == 30 || timer == 10 || timer <= 5)
				{
					Bukkit.broadcastMessage(ChatColor.AQUA + "La partie commence dans " + timer + getSeconde());
				}			
			timer--;
			
		}
		}, 0L, 20L);
	}
	private String getSeconde()
	{
		if(timer == 1)return " seconde";
		return " secondes";
	}
}
