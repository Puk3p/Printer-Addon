package org.Puk3p;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FactionsPlaceholderExpansion extends PlaceholderExpansion {

    private final FactionsPlaceholderPlugin plugin;

    public FactionsPlaceholderExpansion(FactionsPlaceholderPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "factionclaim";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Puk3p";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (player == null) {
            return "";
        }

        if (identifier.equals("in_own_claim")) {
            return "true";
        }

        return null;
    }
}