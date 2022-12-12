package fr.kenda.particles.managers;

import fr.kenda.particles.particles.FlyParticles;
import fr.kenda.particles.particles.IParticles;
import fr.kenda.particles.utils.MessagesUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class ParticlesManager {

    private final HashMap<String, IParticles> particles = new HashMap<>();

    /**
     * Particle manager constructor. Generate and map the shortcut and class of the particle
     */
    public ParticlesManager() {
        particles.put(MessagesUtils.getShortcutParticles("fly"),
                new FlyParticles(MessagesUtils.getMaterial("fly"), MessagesUtils.getNameParticles("fly"),
                        MessagesUtils.getLores("fly"), MessagesUtils.getPermission("particles.fly")));
    }

    /**
     * Get a particle from shortcut
     *
     * @param shortcut shortcut of particle
     * @return particle Class
     */
    public IParticles getParticleByShortcut(String shortcut) {
        return particles.get(shortcut);
    }

    /**
     * Get all particles in map
     *
     * @return ArrayList with all particles
     */
    public ArrayList<IParticles> getAllParticles() {
        ArrayList<IParticles> particles = new ArrayList<>();
        this.particles.forEach((s, iParticles) -> particles.add(iParticles));
        return particles;
    }
}
