package com.solitudecraft.solitudecore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import java.util.ArrayList;

/**
 * Created by nolan on 6/17/2017.
 */

public class MessageFramework {

    public ArrayList<HelpMenu> menus;

    public void showHelpMenu(Player player, HelpMenu menu) {
        player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + menu.title);

        for(HelpMenuItem item : menu.items) {
            player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + ">>" + ChatColor.RESET + " " +
                    ChatColor.GREEN + "/" + item.command + ChatColor.WHITE + " " + item.subCommand +
                    ChatColor.GRAY + " - " + item.explanation);
        }
    }

    public void showErrorMessage(Player player, ErrorType type) {
        String prefix;
        prefix = (ChatColor.DARK_RED + "" + ChatColor.BOLD + ">>" + ChatColor.RESET + " " + ChatColor.GOLD);

        switch(type) {
            case CommandFormat: player.sendMessage(prefix + "Invalid command arguments.");
                break;
            case PlayerNotFound: player.sendMessage(prefix + "Target could not be found.");
                break;
            case LocationNotFound: player.sendMessage(prefix + "Target location could not be found.");
                break;
            case PageNotFound: player.sendMessage(prefix + "Page could not be found.");
                break;

        }
    }

    public HelpMenu getHelpMenu(String menuTitle) {
        for(HelpMenu menu : menus) {
            if (menu.title.toUpperCase() == menuTitle.toUpperCase()) {
                return menu;
            }
        }
        return  null;
    }

    public void broadcastMessage(String message) {
        String prefix;
        prefix = (ChatColor.GREEN + "" + ChatColor.BOLD + ">>" + ChatColor.RESET + " " + ChatColor.WHITE);

        Bukkit.broadcastMessage(prefix + message);
    }

    public void sendUserMessage(Player player, String message) {
        String prefix;
        prefix = (ChatColor.GREEN + "" + ChatColor.BOLD + ">>" + ChatColor.RESET + " " + ChatColor.AQUA);
        player.sendMessage(prefix + message);
    }

    public void sendPrivateMessage(Player sender, Player reciever, String message) {
        String sentPrefix;
        String recievedPrefix;
        sentPrefix = (ChatColor.RED + "" + ChatColor.BOLD + "To " + reciever.getDisplayName().toString() + " >>" + ChatColor.RESET + " " + ChatColor.WHITE);
        recievedPrefix = (ChatColor.GREEN + "" + ChatColor.BOLD + "From " + sender.getDisplayName().toString() + " >>" + ChatColor.RESET + " " + ChatColor.WHITE);
        sender.sendMessage(sentPrefix + message);
        reciever.sendMessage(recievedPrefix + message);
    }

    public void sendMessageSpy(Player mod, Player sender, Player reciever, String message) {
        String prefix;
        prefix = (ChatColor.GOLD + "" + sender.getDisplayName().toString() + ChatColor.YELLOW + " > " + ChatColor.GOLD + reciever.getDisplayName().toString() + ":" + ChatColor.RESET + " " + ChatColor.YELLOW);
        mod.sendMessage(prefix + message);
    }
}
