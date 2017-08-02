package net.graystone.java.essentials.command.moderation;

import java.util.List;

import org.bukkit.entity.Player;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.command.type.sender.TypePlayer;
import com.massivecraft.massivecore.util.MUtil;

import net.graystone.java.essentials.Perm;
import net.graystone.java.essentials.command.EssentialCommand;

public class CmdTeleportEntity extends EssentialCommand
{
	
	private static CmdTeleportEntity i = new CmdTeleportEntity();
	public static CmdTeleportEntity get() { return CmdTeleportEntity.i; }
	
	public CmdTeleportEntity()
	{
		this.setDesc("teleport to a player");
		
		this.addRequirements(RequirementIsPlayer.get(), RequirementHasPerm.get(Perm.TELEPORT_PLAYER.toString()));
		
		this.addParameter(TypePlayer.get(), "playerTo");
	}
	
	@Override
	public void perform() 
			throws MassiveException
	{
		Player targetEntity = this.readArg();
		
		player.teleport(targetEntity);
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("teleport", "tp");
	}
	
}
