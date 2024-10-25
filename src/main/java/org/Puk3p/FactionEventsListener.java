package org.Puk3p;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.InheritanceNode;
import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;

public class FactionEventsListener implements Listener {

    private final LuckPerms luckPerms;
    private final HistoryManager historyManager;
    private final FactionsPlaceholderPlugin plugin;

    public FactionEventsListener(FactionsPlaceholderPlugin plugin, HistoryManager historyManager) {
        this.luckPerms = LuckPermsProvider.get();
        this.historyManager = historyManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        clearPrinterRole(player);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();

        FLocation fromFLocation = new FLocation(from);
        FLocation toFLocation = new FLocation(to);

        Faction fromFaction = Board.getInstance().getFactionAt(fromFLocation);
        Faction toFaction = Board.getInstance().getFactionAt(toFLocation);

        if (!fromFaction.equals(toFaction)) {
            clearPrinterRole(player);

            String world = to.getWorld().getName();
            double x = to.getX();
            double y = to.getY();
            double z = to.getZ();
            String faction = toFaction.getTag();

            historyManager.saveHistory(player, faction, world, x, y, z);
        }
    }

    private void clearPrinterRole(Player player) {
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        if (user != null) {
            InheritanceNode node = InheritanceNode.builder("printer").build();
            if (user.data().toCollection().contains(node)) {
                user.data().remove(node);
                luckPerms.getUserManager().saveUser(user);
                String title = ChatColor.translateAlternateColorCodes('&', "&c&lPRINTER DEZACTIVAT!");
                String subtitle = ChatColor.translateAlternateColorCodes('&', "&7Zambeste Puk3p te iubeste!");

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendTitle(title, subtitle);
                    }
                }.runTaskLater(plugin, 40L);
            }
        }
    }
}
