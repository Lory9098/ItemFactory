package me.smodev.itemfactoryplus.item;

import com.google.common.collect.Maps;
import lombok.Getter;
import me.smodev.itemfactoryplus.ItemFactoryPlus;
import me.smodev.itemfactoryplus.item.interfaces.ItemClickHandler;
import me.smodev.itemfactoryplus.item.interfaces.ItemInteractHandler;
import me.smodev.itemfactoryplus.listeners.ClickListener;
import me.smodev.itemfactoryplus.listeners.InteractListener;
import me.smodev.itemfactoryplus.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class FactoryItem {

    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private List<String> lore;

    private ItemClickHandler clickHandler;
    private ItemInteractHandler itemInteractHandler;
    private Listener clickListener;
    private Listener interactListener;



    public FactoryItem(Material material, int amount) {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public FactoryItem(Material material) {
        this((Material)material, (int)1);
    }

    public FactoryItem(Material material, short damage) {
        this.itemStack = new ItemStack(material, 1, damage);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public FactoryItem(ItemStack items) {
        this.itemStack = items;
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public FactoryItem(ItemStack items, int amount) {
        this.itemStack = items;
        if (amount > 64 || amount < 0) {
            amount = 64;
        }

        this.itemStack.setAmount(amount);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public FactoryItem setName(String name){
        itemMeta.setDisplayName(ChatUtil.color(name));
        return this;
    }

    public FactoryItem setCustomModelData(int id) {
        this.itemMeta.setCustomModelData(id);
        return this;
    }

    public FactoryItem setLore(List<String> lore){
        itemMeta.setLore(ChatUtil.color(lore));
        return this;
    }

    public FactoryItem addLore(String lore){
        this.lore.add(ChatUtil.color(lore));
        return this;
    }

    public FactoryItem addLore(List<String> lore){
        this.lore.addAll(ChatUtil.color(lore));
        return this;
    }

    public FactoryItem removeLore(String lore){
        this.lore.remove(ChatUtil.color(lore));
        return this;
    }

    public FactoryItem removeLore(List<String> lore){
        this.lore.removeAll(ChatUtil.color(lore));
        return this;
    }

    public FactoryItem clearLore(){
        this.lore.clear();
        return this;
    }

    public FactoryItem setLoreLine(int line, String lore){
        this.lore.set(line, ChatUtil.color(lore));
        return this;
    }

    public FactoryItem addLoreLine(int line, String lore){
        this.lore.add(line, ChatUtil.color(lore));
        return this;
    }

    public FactoryItem removeLoreLine(int line){
        this.lore.remove(line);
        return this;
    }

    public FactoryItem clearLoreLine(int line){
        this.lore.set(line, "");
        return this;
    }

    public FactoryItem clearLoreLines(int start, int end){
        for(int i = start; i < end; i++){
            this.lore.set(i, "");
        }
        return this;
    }

    public FactoryItem clearLoreLines(int start){
        for(int i = start; i < this.lore.size(); i++){
            this.lore.set(i, "");
        }
        return this;
    }

    public List<String> getLore(){
        return lore;
    }

    public FactoryItem setDurability(short durability){
        itemStack.setDurability(durability);
        return this;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        Map<Enchantment, Integer> values = Maps.newHashMap();
        values.putAll(this.itemMeta.getEnchants());
        return values;
    }

    public FactoryItem setFlags(ItemFlag... flags) {
        ItemFlag[] var2 = flags;
        int var3 = flags.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ItemFlag flag = var2[var4];
            this.itemMeta.addItemFlags(new ItemFlag[]{flag});
        }

        return this;
    }

    public FactoryItem addEnchant(Enchantment ench, int level) {
        this.itemMeta.addEnchant(ench, level, true);
        return this;
    }

    public FactoryItem setSkull(String value) {
        SkullMeta meta = (SkullMeta)this.itemMeta;
        meta.setOwner(value);
        this.itemMeta = meta;
        return this;
    }

    public FactoryItem setPlayerSkull(String playerName) {
        SkullMeta meta = (SkullMeta)this.itemMeta;
        meta.setOwner(playerName);
        this.itemMeta = meta;
        return this;
    }

    public FactoryItem spawner(EntityType entityType) {
        BlockStateMeta blockMeta = (BlockStateMeta)this.itemMeta;
        BlockState blockState = blockMeta.getBlockState();
        CreatureSpawner spawner = (CreatureSpawner)blockState;
        spawner.setSpawnedType(entityType);
        blockMeta.setBlockState(spawner);
        this.itemStack.setItemMeta(blockMeta);
        this.itemMeta = this.itemStack.getItemMeta();
        return this;
    }

    public FactoryItem setLeatherColor(int red, int green, int blue) {
        LeatherArmorMeta im = (LeatherArmorMeta)this.itemMeta;
        im.setColor(Color.fromRGB(red, green, blue));
        return this;
    }

    public FactoryItem setMeta(ItemMeta meta) {
        this.itemMeta = meta;
        return this;
    }

    public FactoryItem setAmount(int amount){
        this.itemStack.setAmount(amount);

        return this;
    }

    public FactoryItem setActionWhenClick(ItemClickHandler clickHandler) {
        this.clickHandler = clickHandler;
        if(this.clickListener == null) this.clickListener = new ClickListener(this);

        return this;
    }

    public FactoryItem setActionWhenInteract(ItemInteractHandler itemInteractHandler) {
        this.itemInteractHandler = itemInteractHandler;
        if(this.interactListener == null) this.interactListener = new InteractListener(this);

        return this;
    }


    public FactoryItem registerClickListener(JavaPlugin javaPlugin) {
        if(clickListener != null) Bukkit.getPluginManager().registerEvents(this.clickListener, javaPlugin);
        return this;
    }


    public FactoryItem registerInteractListener(JavaPlugin javaPlugin) {
        if(clickListener != null) Bukkit.getPluginManager().registerEvents(this.interactListener, javaPlugin);
        return this;
    }




    public ItemStack build() {
        this.itemMeta.setLore(lore);
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }



}
