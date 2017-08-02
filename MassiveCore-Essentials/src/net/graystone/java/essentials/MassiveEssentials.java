package net.graystone.java.essentials;

import com.massivecraft.massivecore.MassivePlugin;

import net.graystone.java.essentials.command.CmdSpawn;
import net.graystone.java.essentials.command.CmdUniverseSpawn;
import net.graystone.java.essentials.command.moderation.CmdHeal;
import net.graystone.java.essentials.command.moderation.CmdSetspawn;
import net.graystone.java.essentials.command.moderation.CmdTeleportEntity;
import net.graystone.java.essentials.command.moderation.CmdVersion;
import net.graystone.java.essentials.engine.ConnectionEngine;
import net.graystone.java.essentials.entity.MConfColl;
import net.graystone.java.essentials.entity.MPlayerColl;

public class MassiveEssentials extends MassivePlugin
{
	
	private static MassiveEssentials i;
	public MassiveEssentials() { MassiveEssentials.i = this; }
	public static MassiveEssentials get() { return MassiveEssentials.i; }
	
	@Override
	public void onEnableInner()
	{
		this.activate(MConfColl.get(),
				      MPlayerColl.get(),
				      
				      CmdTeleportEntity.get(),
				      CmdSetspawn.get(),
				      
				      CmdHeal.get(),
				      
				      CmdUniverseSpawn.get(),
				      CmdSpawn.get(),
				      
				      CmdVersion.get(),
				      
				      ConnectionEngine.get());
	}
}
