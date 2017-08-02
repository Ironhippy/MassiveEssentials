package net.graystone.java.essentials.command.arguments;

import java.util.Collection;

import org.bukkit.command.CommandSender;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.type.TypeAbstract;
import com.massivecraft.massivecore.util.MUtil;
import com.massivecraft.massivecore.util.Txt;

public class TypeSpawn extends TypeAbstract<String>
{
	
	private static TypeSpawn i = new TypeSpawn();
	public static TypeSpawn get() { return TypeSpawn.i; }
	
	public TypeSpawn()
	{
		super(String.class);
	}
	
	@Override
	public String read(String arg, CommandSender sender)
			throws MassiveException
	{
		if (!this.getTabList(sender, arg).contains(arg)) return null;
		
		return Txt.upperCaseFirst(arg.toLowerCase());
	}

	@Override
	public Collection<String> getTabList(CommandSender sender, String arg)
	{
		return MUtil.list("world", "universe");
	}
	
}
