package ru.bubblemine.npc.main;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.entryset.api.tools.Messager;

public class Utils {

    public static boolean hasPermission(Player player, String permission) {
        if(player.hasPermission(permission)) return true;
        sendMessage(player, "no_permission", true);
        return false;
    }
    public static String getMessage(String message) {
        return Messager.color(Main.config.getString("messages." + message));
    }
    public static void sendMessage(Player player, String message, boolean toPath) {
        if(toPath) {
            player.sendMessage(Main.config.getMessage(message));
            return;
        }
        player.sendMessage(Messager.color(message));
    }
    public static void sendMessage(CommandSender player, String message, boolean toPath) {
        if(toPath) {
            player.sendMessage(Main.config.getMessage(message));
            return;
        }
        player.sendMessage(Messager.color(message));
    }

}
