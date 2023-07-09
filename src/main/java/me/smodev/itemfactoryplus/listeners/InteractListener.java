package me.smodev.itemfactoryplus.listeners;

import me.smodev.itemfactoryplus.item.FactoryItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener {

    private final FactoryItem factoryItem;

    public InteractListener(FactoryItem factoryItem) {
        this.factoryItem = factoryItem;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack clickedItem = event.getItem();

        if (clickedItem != null && clickedItem.equals(factoryItem.getItemStack())) {
            factoryItem.getItemInteractHandler().handleInteract(event);
        }
    }

}
