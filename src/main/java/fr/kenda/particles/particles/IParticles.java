package fr.kenda.particles.particles;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public interface IParticles {

    /**
     * Get the icon of particles
     * @return Material
     */
    public Material getIcon();

    /**
     * Get the name of particles
     * @return String
     */
    public String getName();

    /**
     * Get the permission of particles
     * @return String
     */
    public String getPermission();

    /**
     * Get the lore of particles (gui)
     * @return ArrayList of String
     */
    public ArrayList<String> getLore();

    /**
     * Get the item (gui)
     * @return ItemStack
     */
    public ItemStack getItem();

    /**
     * Showing the particles
     */
    public void Show();
}
