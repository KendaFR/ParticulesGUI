package fr.kenda.particles.particles;

import fr.kenda.particles.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class FlyParticles implements IParticles {

    private final Material icon;
    private final String name;
    private final List<String> lores;
    private final String permission;

    public FlyParticles(Material icon, String name, List<String> lores, String permission) {
        this.icon = icon;
        this.name = name;
        this.lores = lores;
        this.permission = permission;
    }

    @Override
    public Material getIcon() {
        return icon;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    @Override
    public ArrayList<String> getLore() {
        ArrayList<String> lores = new ArrayList<>();
        List<String> loresLines = this.lores;
        loresLines.forEach(line -> lores.add(line.replace("&", "§")));
        return lores;
    }

    @Override
    public ItemStack getItem() {
        return new ItemBuilder(icon).setName(name).setLore(getLore()).toItemStack();
    }

    @Override
    public void Show() {

    }
}
