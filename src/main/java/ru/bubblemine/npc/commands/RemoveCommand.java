package ru.bubblemine.npc.commands;

import org.bukkit.entity.Player;
import ru.bubblemine.npc.main.Utils;
import ru.bubblemine.npc.npc.NpcConfig;

public class RemoveCommand {
    public RemoveCommand(Player player, String[] args) {
        if(args.length != 2) {
            Utils.sendMessage(player, "removehelp", true);
            return;
        }

        String name = args[1];
        NpcConfig config = new NpcConfig(name);
        if(!config.hasNpc()) {
            Utils.sendMessage(player, "dontpresent", true);
            return;
        }
        config.remove();

        Utils.sendMessage(player, "removed", true);
    }
}
