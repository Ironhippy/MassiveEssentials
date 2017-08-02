package net.graystone.java.essentials.command;

import java.util.List;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.ps.PS;
import com.massivecraft.massivecore.util.MUtil;
import com.massivecraft.massivecore.util.Txt;

import net.graystone.java.essentials.Perm;
import net.graystone.java.essentials.entity.MConf;

public class CmdUniverseSpawn extends EssentialCommand
{
	
	private static CmdUniverseSpawn i = new CmdUniverseSpawn();
	public static CmdUniverseSpawn get() { return CmdUniverseSpawn.i; } 
	
	public CmdUniverseSpawn()
	{
		this.setDesc("teleport to universal spawn location");
		
		this.addRequirements(RequirementIsPlayer.get(), RequirementHasPerm.get(Perm.SPAWN.toString()));
	}
	
	@Override
	public void perform() 
			throws MassiveException
	{
		String universe = player.getUniverse();
		
		if (MConf.get().getSpawn(universe)==null) { message(Txt.parse("<rose>This universe does not have a universal spawn location set.")); return; }
		
		PS spawnLocation = MConf.get().getSpawn(universe);
		
		player.teleport(spawnLocation);
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("uspawn");
	}
	
}
