package net.graystone.java.essentials.command.moderation;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.command.type.enumeration.TypeGameMode;
import com.massivecraft.massivecore.command.type.sender.TypePlayer;
import com.massivecraft.massivecore.util.MUtil;
import com.massivecraft.massivecore.util.Txt;

import net.graystone.java.essentials.Perm;
import net.graystone.java.essentials.command.EssentialCommand;

public class CmdGameMode extends EssentialCommand
{
	
	private static CmdGameMode i = new CmdGameMode();
	public static CmdGameMode get() { return CmdGameMode.i; }
	
	public CmdGameMode()
	{
		this.setDesc("change a user's game mode");
		
		this.addRequirements(RequirementIsPlayer.get(), RequirementHasPerm.get(Perm.GAME_MODE.toString()));
		this.addParameter(TypeGameMode.get(), "gamemode");
		this.addParameter(TypePlayer.get(), "playerName", "you");
	}
	
	
	@Override
	public void perform() throws MassiveException
	{
		GameMode set = this.readArg();
		Player targetPlayer = this.readArg(me);
		GameMode prev = targetPlayer.getGameMode();
		
		targetPlayer.setGameMode(set);
		
		String from = Txt.upperCaseFirst(prev.name().toLowerCase());
		String to = Txt.upperCaseFirst(set.name());
		
		if (me.getName().equalsIgnoreCase(targetPlayer.getName()))
		{
			message(Txt.parse("<i>Your GameMode has been <pink>updated <i>from <aqua>"+from
			        +" <i>to <aqua>"+to+"<i>."));
			
			return;
		}
		
		message(Txt.parse("<i>You have changed <white>"+targetPlayer.getName()+"'s <i>GameMode from <aqua>"+from
				+" <i>to <aqua>"+to+"<i>."));
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("gamemode", "gm");
	}
	
}
