package dev.tankpillow.universe.misc;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.tankpillow.universe.TanksUniverse;
import net.minecraft.resources.Identifier;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CapeRegistry {

    private static final Map<UUID, Identifier> CAPE_MAP = new HashMap<>();

    public static void load() {
        try {
            URL url = URI.create("https://raw.githubusercontent.com/tankpillow/tanks-universe/refs/heads/master/capes.json").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            try (InputStream is = connection.getInputStream(); InputStreamReader reader = new InputStreamReader(is)) {
                JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
                for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
                    UUID uuid = UUID.fromString(entry.getKey());
                    Identifier id = Identifier.parse("tanks-universe:cape/" + entry.getValue().getAsString());
                    CAPE_MAP.put(uuid, id);
                }
            }
        } catch (Exception e) {
            TanksUniverse.LOGGER.error("Failed to load capes.json: {}", e.getMessage());
        }
    }

    public static Identifier getCape(UUID uuid) {
        return CAPE_MAP.get(uuid);
    }
}
