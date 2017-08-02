package net.graystone.java.essentials.command.moderation;

import java.util.List;

import org.bukkit.Bukkit;

import com.massivecraft.massivecore.MassiveCore;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.util.MUtil;
import com.massivecraft.massivecore.util.Txt;

import net.graystone.java.essentials.command.EssentialCommand;
import net.graystone.java.essentials.entity.MConf;

public class CmdVersion extends EssentialCommand
{
	
	private static CmdVersion i = new CmdVersion();
	public static CmdVersion get() { return CmdVersion.i; }
	
	private String lineSep = "\n";
	
	@Override
	public void perform() 
			throws MassiveException
	{
		String header = "<gold>_____________.[ <green>Server Information <gold>]._____________"+lineSep;
		String name = "<aqua>Server Name: <pink>"+MConf.get().getServerName()+lineSep;
		String desc = "<aqua>Server Description: "+Bukkit.getServer().getMotd()+lineSep;
		String mineVersion = "<aqua>Minecraft Version: <silver>"+Bukkit.getServer().getVersion()+lineSep;
		String bukkitVersion = "<aqua>Bukkit Version: <i>"+Bukkit.getServer().getBukkitVersion()+lineSep;
		String mcoreVersion = "<pink>MassiveCore <aqua>Version: <lime>"+MassiveCore.get().getDescription().getVersion();
		
		String versionMessage = Txt.parse(header+name+desc+mineVersion+bukkitVersion+mcoreVersion);
		
		message(versionMessage);
	}
	
	@Override
	public List<String> getAliases()
	{
		return MUtil.list("version");
	}
	
}
