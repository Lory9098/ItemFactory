package me.smodev.itemfactoryplus.item.interfaces;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface ItemClickHandler {
    void handleClick(InventoryClickEvent event);
}
