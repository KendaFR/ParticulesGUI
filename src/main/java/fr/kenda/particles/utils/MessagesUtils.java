package fr.kenda.particles.utils;

import fr.kenda.particles.Particles;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class MessagesUtils {

    private static final FileConfiguration CONFIG = Particles.getInstance().getConfig();

    /**
     * Get the prefix in configuration file
     *
     * @return String
     */
    public static String getPrefix() {
        return CONFIG.getString("prefix").replace("&", "§");
    }

    /**
     * Get the string in path and replace with arguments (no need replace & by §)
     *
     * @param path path of string in config file
     * @param args args to replace (first in replace in config, and second is replace value)
     * @return string
     */
    public static String getStringFromConfig(String path, String... args) {
        String prefix = getPrefix();
        if (path.isEmpty()) {
            Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.RED + "path can be empty in replace state");
            return "";
        }
        if (args.length % 2 != 0) {
            Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.RED + "an error was occured in replace arguments");
            return "";
        }
        String message = CONFIG.getString("messages." + path).replace("&", "§").replace("%prefix%", prefix);
        if (args.length > 1) {
            int size = args.length;
            for (int i = 0; i < size; i += 2)
                message = message.replace(args[i], args[i + 1]);
            return message;
        }
        if (message.equalsIgnoreCase(prefix)) {
            Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.RED + "an error was occured in replacement method. Path invalid");
        }
        return message;
    }

    /**
     * Get Permission in config file
     *
     * @param path path in permission section in config
     * @return String of permission
     */
    public static String getPermission(String path) {
        return CONFIG.getString("permission." + path);
    }


    public static String getShortcutParticles(String particles) {
        return CONFIG.getString("particles." + particles + ".shortcut");
    }

    /**
     * Get material in particles section in config
     *
     * @param particles particles
     * @return Material
     */

    public static Material getMaterial(String particles) {
        Material material = Material.getMaterial(CONFIG.getString("particles." + particles + ".material"));
        if (material != null)
            return material;
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "an error was occured. Material type in particles." + particles + ".material is not valid");
        return Material.STONE;
    }

    public static String getNameParticles(String particles) {
        return CONFIG.getString("particles." + particles + ".name").replace("&", "§");
    }


    public static List<String> getLores(String particles) {
        return CONFIG.getStringList("particles." + particles + ".lores");
    }
}
