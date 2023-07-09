package me.smodev.itemfactoryplus.listeners;

import me.smodev.itemfactoryplus.item.FactoryItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickListener implements Listener {
    private final FactoryItem factoryItem;

    public ClickListener(FactoryItem factoryItem) {
        System.out.println("Nuova istanza di ClickListener");
        this.factoryItem = factoryItem;
    }

    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.equals(factoryItem.getItemStack())) {
            factoryItem.getClickHandler().handleClick(event);
        }
    }
}
