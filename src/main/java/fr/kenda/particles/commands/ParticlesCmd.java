package fr.kenda.particles.commands;

import fr.kenda.particles.Particles;
import fr.kenda.particles.managers.ParticlesManager;
import fr.kenda.particles.particles.IParticles;
import fr.kenda.particles.utils.MessagesUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParticlesCmd implements CommandExecutor {
    private final String prefix = Particles.getInstance().prefix;
    ParticlesManager pm = new ParticlesManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //check if sender is player
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(prefix + MessagesUtils.getStringFromConfig("no_permission", "%reason%", "sender can't be execute the command"));
            return true;
        }


        Player player = (Player) sender;

        //check is has not args
        if (args.length != 1) {
            sender.sendMessage(ChatColor.GREEN + "====================");
            sender.sendMessage(ChatColor.GREEN + "/particles gui => show the gui of all particles"); //todo
            sender.sendMessage(ChatColor.GREEN + "/particles <name> => active this particle"); //todo
            sender.sendMessage(ChatColor.GREEN + "====================");
            return true;
        }
        //check if args is gui
        if (args[0].equalsIgnoreCase("gui")) {
            if (!player.hasPermission(MessagesUtils.getPermission("open_gui"))) {
                player.sendMessage(MessagesUtils.getStringFromConfig("no_permission", "%reason%", MessagesUtils.getStringFromConfig("permission_insufficient")));
                return true;
            }
            /*
            TODO make gui particle
             */
            player.getInventory().addItem(pm.getParticleByShortcut("fly").getItem());
            return true;
        }

        //get the name of particules shortcut, and show the particles.
        String name = args[0];
        IParticles particles = pm.getParticleByShortcut(name);
        if (particles != null)
            particles.Show();
        else
           player.sendMessage(MessagesUtils.getStringFromConfig("particles.not_exist", "%name%", name));
        return false;
    }
}
