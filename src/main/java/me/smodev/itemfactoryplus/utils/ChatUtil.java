package me.smodev.itemfactoryplus.utils;

import org.bukkit.ChatColor;

import java.util.List;

public class ChatUtil {

    public static String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> color(List<String> text){
        for(int i = 0; i < text.size(); i++){
            text.set(i, color(text.get(i)));
        }
        return text;
    }

}
