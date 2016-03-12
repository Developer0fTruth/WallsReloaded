package com.thundergemios10.walls.commands;

import org.bukkit.entity.Player;
import com.thundergemios10.walls.GameManager;
import com.thundergemios10.walls.MessageManager;
import com.thundergemios10.walls.SettingsManager;



public class Leave implements SubCommand {
	
    public boolean onCommand(Player player, String[] args) {
        if (GameManager.getInstance().getPlayerGameId(player) == -1) {
            MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.ERROR, "error.nopermission", player);
        }
        else{
            GameManager.getInstance().removePlayer(player, false);
        }
        return true;
    }

    public String help(Player p) {
        return "/w leave - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.leave", "Leaves the game");
    }

	public String permission() {
		return null;
	}
}
