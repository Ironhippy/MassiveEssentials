package net.graystone.java.essentials.engine;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

import com.massivecraft.massivecore.Engine;
import com.massivecraft.massivecore.util.Txt;

public class ConnectionEngine extends Engine
{
	
	private static ConnectionEngine i = new ConnectionEngine();
	public static ConnectionEngine get() { return ConnectionEngine.i; }
	
	@EventHandler
	public void pingMotd(ServerListPingEvent event)
	{
		event.setMotd(Txt.parse(event.getMotd()));
	}
}
