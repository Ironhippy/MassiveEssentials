package net.graystone.java.essentials.command;

import com.massivecraft.massivecore.command.MassiveCommand;

import net.graystone.java.essentials.entity.MPlayer;

public class EssentialCommand extends MassiveCommand
{
	
	protected MPlayer player;
	
	@Override
	public void senderFields(boolean set)
	{
		super.senderFields(set);
		
		this.player = set ? MPlayer.get(sender) : null;
	}
	
}
