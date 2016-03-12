package com.thundergemios10.walls.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.thundergemios10.walls.LobbyManager;
import com.thundergemios10.walls.SettingsManager;



public class SetLobbyWall implements SubCommand{

    public boolean onCommand(Player player, String[] args) {
    	//player.sendMessage(ChatColor.RED+"This command has been replaced by /sg addwall <arenaid>");
    	return true;/*
        if(!player.hasPermission("walls.admin.setlobby") && !player.isOp()){
            player.sendMessage(ChatColor.RED+"No Permission");
            return true;
        }
        else if(args.length<1){
        	player.sendMessage("Please Specify a gameid");
        	return true;
        }
       LobbyManager.getInstance().setLobbySignsFromSelection(player, Integer.parseInt(args[0]));
       return true;*/
    }

    public String help(Player p) {
        return "/w setlobbywall <id> - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.setlobbywall", "Add a lobby stats wall for Arena <id>");
    }

	public String permission() {
		return "walls.admin.setlobby";
	}

    //TODO: TAKE A W.E SELECTIONA AND SET THE LOBBY. ALSO SET LOBBY WALL
}