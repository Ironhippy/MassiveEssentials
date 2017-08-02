package net.graystone.java.essentials.command.moderation;

import java.util.List;

import org.bukkit.entity.Player;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.util.MUtil;
import com.massivecraft.massivecore.util.Txt;

import net.graystone.java.essentials.Perm;
import net.graystone.java.essentials.command.EssentialCommand;

public class CmdHeal extends EssentialCommand
{
	
	private static CmdHeal i = new CmdHeal();
	public static CmdHeal get() { return CmdHeal.i; }
	
	public CmdHeal()
	{
		this.setDesc("heal the player");
		
		this.addRequirements(RequirementIsPlayer.get(), RequirementHasPerm.get(Perm.HEAL.toString()));
	}
	
	@Override
	public void perform() 
			throws MassiveException
	{
		Player targetPlayer = player.getPlayer();
		
		targetPlayer.setHealth(targetPlayer.getHealthScale());
		targetPlayer.setFoodLevel(20);
		
		message(Txt.parse("<i>You have been <pink>healed<i>."));
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("heal");
	}
	
}
