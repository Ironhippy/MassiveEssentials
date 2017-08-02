package net.graystone.java.essentials.entity;

import java.util.Map;

import com.massivecraft.massivecore.collections.MassiveMap;
import com.massivecraft.massivecore.ps.PS;
import com.massivecraft.massivecore.store.Entity;

public class MConf extends Entity<MConf>
{
	
	protected static transient MConf i;
	public static MConf get() { return MConf.i; }  
	
	private String serverName = "Vanilla Minecraft Server";
	public String getServerName() { return this.serverName; }
	
	private int teleportDelay = 5;
	public int getTeleportDelay() { return this.teleportDelay; }
	
	private int maxHomes = 2;
	public int getMaxHomes() { return this.maxHomes; }  
	
	private Map<String, PS> universeSpawns = new MassiveMap<String, PS>();
	public void setSpawn(String universe, PS ps) { this.universeSpawns.put(universe, ps); this.changed(); }
	public PS getSpawn(String arg0) { return this.universeSpawns.get(arg0); } 
	
}
