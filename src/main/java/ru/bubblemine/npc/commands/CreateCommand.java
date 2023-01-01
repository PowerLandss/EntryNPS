package ru.bubblemine.npc.commands;

import org.bukkit.entity.Player;
import ru.bubblemine.npc.main.Utils;
import ru.bubblemine.npc.npc.Npc;
import ru.bubblemine.npc.npc.NpcConfig;

public class CreateCommand {
    public CreateCommand(Player player, String[] args) {
        if(args.length != 3) {
            Utils.sendMessage(player, "createhelp", true);
            return;
        }

        String name = args[1];
        NpcConfig config = new NpcConfig(name);
        if(config.hasNpc()) {
            Utils.sendMessage(player, "present", true);
            return;
        }
        Npc npc = new Npc(name);
        npc.loadNpc();
        config.create("DefaultNpc", "PLAYER", player.getLocation(), args[2]);
        Utils.sendMessage(player, "created", true);
    }

}
