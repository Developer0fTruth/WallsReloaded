package com.thundergemios10.walls.commands;

import org.bukkit.entity.Player;
import com.thundergemios10.walls.GameManager;

public class AddWall implements SubCommand {
	public boolean onCommand(Player player, String[] args)
	{
		if(player.hasPermission(permission())){
			GameManager.getInstance().setWallFromSelected(player, args[0]);
		}
		return true;
	}

	public String help(Player p) {
		return "/w setwall <gameid> <wallid> - set a wall for an arena";
	}

	@Override
	public String permission() {
		return "walls.arena.setwall";
	}
}