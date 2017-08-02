package net.graystone.java.essentials.entity;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import com.massivecraft.massivecore.collections.MassiveList;
import com.massivecraft.massivecore.mixin.MixinTeleport;
import com.massivecraft.massivecore.mixin.TeleporterException;
import com.massivecraft.massivecore.ps.PS;
import com.massivecraft.massivecore.store.SenderEntity;
import com.massivecraft.massivecore.teleport.DestinationSimple;

public class MPlayer extends SenderEntity<MPlayer>
{
	
	public static MPlayer get(Object oid) { return MPlayerColl.get().get(oid); }
	
	private PS homeLocation = PS.valueOf(Bukkit.getWorlds().get(0).getSpawnLocation());
	public void setHome(PS ps) { this.homeLocation = ps; this.changed(); }
	public PS getHome() { return this.homeLocation; }
	
	public PS getLocation() { return PS.valueOf(this.getPlayer()); }  
	
	private List<String> ipAddresses = new MassiveList<String>();
	public void addIp(String arg0) { this.ipAddresses.add(arg0); this.changed(); }
	public boolean hasIp(String arg0)
	{
		boolean ret = false;
		
		for (String ips : ipAddresses)
		{
			if (!arg0.equalsIgnoreCase(ips)) continue;
			
			ret = true;
			break;
		}
		
		return ret;
	}
	
	public boolean teleport(PS targetPS)
	{
		try {
			MixinTeleport.get().teleport(this.getPlayer(), new DestinationSimple(targetPS), MConf.get().getTeleportDelay());
		} catch (TeleporterException e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean teleport(Entity targetEntity)
	{
		return teleport(PS.valueOf(targetEntity));
	}
	
	public boolean teleport(Location targetLocation)
	{
		return teleport(PS.valueOf(targetLocation));
	}
	
}
