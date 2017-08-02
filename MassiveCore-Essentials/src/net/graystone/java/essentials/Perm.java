package net.graystone.java.essentials;

public enum Perm
{
	
	SETHOME("default.sethome"),
	HOME("default.home"),
	SPAWN("default.spawn"),
	
	TELEPORT_PLAYER("admin.teleport.player"),
	GAME_MODE("admin.gamemode"),
	HEAL("admin.heal"),
	
	SET_SPAWN("default.uspawn");
	
	private String node = "essentials.";
	Perm(String node)
	{
		this.node += node;
	}
	
	@Override
	public String toString()
	{
		return this.node;
	}
	
}
