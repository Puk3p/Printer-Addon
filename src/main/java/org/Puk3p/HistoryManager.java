package org.Puk3p;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryManager {

    private final FactionsPlaceholderPlugin plugin;
    private File historyFile;
    private FileConfiguration historyConfig;

    private final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public HistoryManager(FactionsPlaceholderPlugin plugin) {
        this.plugin = plugin;
    }

    public void createHistoryFile() {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        historyFile = new File(dataFolder, "history.yml");
        if (!historyFile.exists()) {
            try {
                historyFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        historyConfig = YamlConfiguration.loadConfiguration(historyFile);
    }

    public void saveHistory(Player player, String faction, String world, double x, double y, double z) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        String formattedX = decimalFormat.format(x);
        String formattedY = decimalFormat.format(y);
        String formattedZ = decimalFormat.format(z);

        String entry = player.getName() + " : " + faction + " : " + world + ":" + formattedX + " ," + formattedY + ", " + formattedZ + " : " + timestamp;

        int index = historyConfig.getKeys(false).size() + 1;
        historyConfig.set("history." + index, entry);
        try {
            historyConfig.save(historyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
