package net.graystone.java.essentials.command.moderation;

import java.util.List;

import org.bukkit.Location;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.util.MUtil;

import net.graystone.java.essentials.Perm;
import net.graystone.java.essentials.command.EssentialCommand;
import net.graystone.java.essentials.command.arguments.TypeSpawn;
import net.graystone.java.essentials.entity.MConf;

public class CmdSetspawn extends EssentialCommand
{
	
	private static CmdSetspawn i = new CmdSetspawn();
	public static CmdSetspawn get() { return CmdSetspawn.i; } 
	
	public CmdSetspawn()
	{
		this.setDesc("set the universe or global spawn location");
		
		this.addRequirements(RequirementIsPlayer.get(), RequirementHasPerm.get(Perm.SET_SPAWN.toString()));
		
		this.addParameter(TypeSpawn.get(), "spawnType");
	}
	
	@Override
	public void perform() 
			throws MassiveException
	{
		String spawnType = this.readArg();
		
		if (spawnType.equalsIgnoreCase("world"))
		{
			Location spawnLocation = player.getLocation().asBukkitLocation();
			spawnLocation.getWorld().setSpawnLocation(spawnLocation.getBlockX(), spawnLocation.getBlockY(), spawnLocation.getBlockZ());
			
			return;
		}
		String universe = player.getUniverse();
		MConf.get().setSpawn(universe, player.getLocation());
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("setspawn");
	}
	
}
