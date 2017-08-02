package net.graystone.java.essentials.entity;

import com.massivecraft.massivecore.store.MStore;
import com.massivecraft.massivecore.store.SenderColl;

import net.graystone.java.essentials.MassiveEssentials;

public class MPlayerColl extends SenderColl<MPlayer>
{
	
	private static MPlayerColl i = new MPlayerColl();
	public static MPlayerColl get() { return MPlayerColl.i; }
	
	public MPlayerColl()
	{
		super("essentials_mplayer", MPlayer.class, MStore.getDb(), MassiveEssentials.get());
	}
	
}
