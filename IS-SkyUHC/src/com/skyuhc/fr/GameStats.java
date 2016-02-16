package com.skyuhc.fr;

public enum GameStats 
{	

	LOBBY(true), PREGAME(false), GAME(false), FINISH(false);
	
	private boolean canJoin;
	
	private static GameStats currentStats;
	
	GameStats(boolean canJoin)
	{
		this.canJoin = canJoin;
	}
	
	public boolean canJoin()
	{
		return canJoin;
	}

	public static void setStats(GameStats state)
	{
		GameStats.currentStats = state;
	}
	
	public static boolean isState(GameStats state)
	{
		return GameStats.currentStats == state;
	}
	
	public static GameStats getState()
	{
		return currentStats;
	}
}
