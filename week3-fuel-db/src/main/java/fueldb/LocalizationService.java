package fueldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LocalizationService {

    private Map<String, String> cache = new HashMap<>();
    private String currentLanguage = "";

    public void loadStrings(String language) {
        if (language.equals(currentLanguage) && !cache.isEmpty()) {
            return;
        }

        cache.clear();
        currentLanguage = language;

        String sql = "SELECT `key`, value FROM localization_strings WHERE language = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, language);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cache.put(rs.getString("key"), rs.getString("value"));
            }

        } catch (SQLException e) {
            System.err.println("Could not load strings for language '" + language + "': " + e.getMessage());
        }
    }

    public String getString(String key) {
        return cache.getOrDefault(key, key);
    }

    public Map<String, String> getAllKeys() {
        return new HashMap<>(cache);
    }
}
