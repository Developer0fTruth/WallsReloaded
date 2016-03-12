package com.thundergemios10.walls.commands;

import org.bukkit.entity.Player;
import com.thundergemios10.walls.GameManager;
import com.thundergemios10.walls.SettingsManager;



public class LeaveQueue implements SubCommand{

    public boolean onCommand(Player player, String[] args) {
        GameManager.getInstance().removeFromOtherQueues(player, -1);
        return true;
    }

    public String help(Player p) {
        return "/w lq - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.leavequeue", "Leave the queue for any queued games");
    }

	public String permission() {
		return null;
	}

}
