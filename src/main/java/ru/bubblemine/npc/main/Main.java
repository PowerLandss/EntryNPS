package ru.bubblemine.npc.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.bubblemine.npc.commands.NpcCommand;
import ru.entryset.api.configuration.Config;
import ru.entryset.api.configuration.Configuration;
import ru.entryset.api.tools.Messager;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Config config;
    public static Configuration base;
    public static File baseFile;
    public static Messager messager;

    @Override
    public void onEnable() {
        instance = this;

        config = new Config(this, "config.yml");
        base = new Configuration(this, "base.yml");
        baseFile = new File(getDataFolder().getAbsolutePath() + "/base.yml");
        messager = new Messager(config);

        Bukkit.getServer().getPluginCommand("enpc").setExecutor(new NpcCommand());
    }

    public static Main getInstance() {
        return instance;
    }
}
