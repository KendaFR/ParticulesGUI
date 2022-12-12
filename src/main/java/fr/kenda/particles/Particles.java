package fr.kenda.particles;

import fr.kenda.particles.commands.ParticlesCmd;
import fr.kenda.particles.managers.ParticlesManager;
import fr.kenda.particles.utils.MessagesUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Particles extends JavaPlugin {

    private static Particles instance;
    public String prefix = "";
    public static Particles getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        prefix = MessagesUtils.getPrefix();
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Plugin enabled");

        getCommand("particles").setExecutor(new ParticlesCmd());

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.RED + "Plugin stopped");
    }
}
