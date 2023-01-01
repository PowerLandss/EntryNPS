package ru.bubblemine.npc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.bubblemine.npc.main.Main;
import ru.bubblemine.npc.main.Utils;

public class NpcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Utils.sendMessage(sender, "console", true);
            return true;
        }
        Player player = (Player) sender;
        if(!Utils.hasPermission(player, Main.config.getPermission("admin"))) {
            return true;
        }
        if(args.length == 0) {
            Utils.sendMessage(sender, "help", true);
            return true;
        }
        String sub = args[0];
        switch (sub) {
            case "reload":
                new ReloadCommand(player);
                break;
            case "create":
                new CreateCommand(player, args);
                break;
            case "remove":
                new RemoveCommand(player, args);
                break;
        }
        return false;
    }
}
