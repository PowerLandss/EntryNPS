package ru.bubblemine.npc.npc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.bubblemine.npc.main.Main;
import ru.bubblemine.npc.npc.uuid.UUIDManager;

import java.io.IOException;

public class NpcConfig {
    private String name;

    public NpcConfig(String name) {
        this.name = name;
    }
    public void create(String displayName, String type, Location location, String skin) {
        try {
            YamlConfiguration configuration = Main.base.getConfiguration();
            configuration.set("npc." + name + ".displayname", displayName);
            configuration.set("npc." + name + ".skin", skin);
            configuration.set("npc." + name + ".type", type);
            configuration.set("npc." + name + ".uuid", UUIDManager.generateRandomUUID(name).toString());
            configuration.set("npc." + name + ".location.world", location.getWorld().getName());
            configuration.set("npc." + name + ".location.x", location.getX());
            configuration.set("npc." + name + ".location.y", location.getY());
            configuration.set("npc." + name + ".location.z", location.getZ());
            configuration.set("npc." + name + ".location.yaw", location.getYaw());
            configuration.set("npc." + name + ".location.pitch", location.getPitch());
            configuration.save(Main.baseFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void edit(String displayName, String type, Location location, String skin) {
        try {
            YamlConfiguration configuration = Main.base.getConfiguration();
            ConfigurationSection section = configuration.getConfigurationSection("npc." + name);
            section.set("displayname", displayName);
            section.set("skin", skin);
            section.set("type", type);
            section.set("uuid", UUIDManager.getUUIDtoName(name).toString());
            section.set("location.world", location.getWorld().toString());
            section.set("location.x", location.getX());
            section.set("location.y", location.getY());
            section.set("location.z", location.getZ());
            section.set("location.yaw", location.getYaw());
            section.set("location.pitch", location.getPitch());
            configuration.save(Main.baseFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void remove(){
        try {
            YamlConfiguration configuration = Main.base.getConfiguration();
            configuration.set("npc." + name, null);
            configuration.save(Main.baseFile);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean hasNpc() {
        if(Main.base.getConfiguration().isSet("npc." + name)) return true;
        return false;
    }

    public String getName() {
        return name;
    }
    public String getString(String path) {
        return Main.base.getString("npc."+name+"."+path);
    }
    public Boolean getBoolean(String path) {
        return Main.base.getBoolean("npc."+name+"."+path);
    }
    public Double getDouble(String path) {
        return Main.base.getDouble("npc."+name+"."+path);
    }
    public Float getFloat(String path) {
        return (float)Main.base.getDouble("npc."+name+"."+path);
    }
    public Location getLocation() {
        Location location = new Location(
                Bukkit.getWorld(getString("location.world")),
                getDouble("location.x"),
                getDouble("location.y"),
                getDouble("location.z")
        );
        location.setYaw(getFloat("location.yaw"));
        location.setPitch(getFloat("location.pitch"));
        return location;
    }

}
