package com.thundergemios10.walls.commands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import com.thundergemios10.walls.Game;
import com.thundergemios10.walls.GameManager;
import com.thundergemios10.walls.LobbyManager;
import com.thundergemios10.walls.MessageManager;
import com.thundergemios10.walls.SettingsManager;
import com.thundergemios10.walls.MessageManager.PrefixType;



public class DelArena implements SubCommand{

    public boolean onCommand(Player player, String[] args) {
        if (!player.hasPermission(permission()) && !player.isOp()){
            MessageManager.getInstance().sendFMessage(PrefixType.ERROR, "error.nopermission", player);
            return true;
        }
        
        if(args.length != 1){
            MessageManager.getInstance().sendFMessage(PrefixType.ERROR, "error.notspecified", player, "input-Arena");
            return true;
        }
        
        FileConfiguration s = SettingsManager.getInstance().getSystemConfig();
        //FileConfiguration spawn = SettingsManager.getInstance().getSpawns();
        int arena = Integer.parseInt(args[0]);
        Game g = GameManager.getInstance().getGame(arena);
        
        if(g == null){
            MessageManager.getInstance().sendFMessage(PrefixType.ERROR, "error.gamedoesntexist", player, "arena-" + arena);
            return true;
        }
        
        g.disable();
        s.set("walls-system.arenas."+arena+".enabled", false);
        s.set("walls-system.arenano", s.getInt("walls-system.arenano") - 1);
        //spawn.set("spawns."+arena, null);
        MessageManager.getInstance().sendFMessage(PrefixType.INFO, "info.deleted", player, "input-Arena");
        SettingsManager.getInstance().saveSystemConfig();
        GameManager.getInstance().hotRemoveArena(arena);
        LobbyManager.getInstance().clearAllSigns();
        return true;
    }

    public String help (Player p) {
        return "/w delarena <id> - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.delarena", "Delete an arena");
    }

	public String permission() {
		return "walls.admin.deletearena";
	}   
}