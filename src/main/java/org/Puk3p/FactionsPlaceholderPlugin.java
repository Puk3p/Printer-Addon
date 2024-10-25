package org.Puk3p;

import org.bukkit.plugin.java.JavaPlugin;

public class FactionsPlaceholderPlugin extends JavaPlugin {

    private HistoryManager historyManager;

    @Override
    public void onEnable() {
        historyManager = new HistoryManager(this);
        historyManager.createHistoryFile();

        getServer().getPluginManager().registerEvents(new FactionEventsListener(this, historyManager), this);

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new FactionsPlaceholderExpansion(this).register();
        }
    }

    @Override
    public void onDisable() {}

    public HistoryManager getHistoryManager() {
        return historyManager;
    }
}
