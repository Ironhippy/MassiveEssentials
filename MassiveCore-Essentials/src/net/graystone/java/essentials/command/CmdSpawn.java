package net.graystone.java.essentials.command;

import java.util.List;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.mixin.MixinTeleport;
import com.massivecraft.massivecore.mixin.TeleporterException;
import com.massivecraft.massivecore.ps.PS;
import com.massivecraft.massivecore.teleport.Destination;
import com.massivecraft.massivecore.teleport.DestinationSimple;
import com.massivecraft.massivecore.util.MUtil;

import net.graystone.java.essentials.Perm;
import net.graystone.java.essentials.entity.MConf;

public class CmdSpawn extends EssentialCommand
{
	
	private static CmdSpawn i = new CmdSpawn();
	public static CmdSpawn get() { return CmdSpawn.i; } 
	
	public CmdSpawn()
	{
		this.setDesc("teleport to world spawn location");
		
		this.addRequirements(RequirementIsPlayer.get(), RequirementHasPerm.get(Perm.SPAWN.toString()));
	}
	
	@Override
	public void perform() throws MassiveException
	{
		PS spawnLocation = PS.valueOf(player.getLocation().asBukkitWorld().getSpawnLocation());
		
		Destination destinationSpawn = new DestinationSimple(spawnLocation);
		
		try {
			MixinTeleport.get().teleport(player.getPlayer(), destinationSpawn, MConf.get().getTeleportDelay());
		} catch (TeleporterException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("spawn");
	}
	
}
