package me.smodev.itemfactoryplus.item.interfaces;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface ItemInteractHandler {
    void handleInteract(PlayerInteractEvent event);
}
