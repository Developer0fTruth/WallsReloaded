package me.thundergemios10.walls.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import me.thundergemios10.walls.Game;



public class PlayerLeaveArenaEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
    private Player player;
    private Game game;

    public PlayerLeaveArenaEvent(Player p, Game g) {
        player = p;
        game = g;
    }

    public Player getPlayer() {
        return player;
    }
    
    public Game getGame() {
    	return game;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}