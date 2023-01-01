package ru.bubblemine.npc.npc.uuid;

import java.util.HashMap;
import java.util.UUID;

public class UUIDManager {

    public static HashMap<String, UUID> uuidHashMap = new HashMap<>();
    public static HashMap<UUID, String> nameHashMap = new HashMap<>();

    public static UUID generateRandomUUID(String name) {
        UUID uuid = UUID.randomUUID();
        uuidHashMap.put(name, uuid);
        nameHashMap.put(uuid, name);
        return uuid;
    }
    public static UUID getUUIDtoName(String name) {
        return uuidHashMap.get(name);
    }
}
