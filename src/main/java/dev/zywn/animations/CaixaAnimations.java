package dev.zywn.animations;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CaixaAnimations {

    public static void animarCaixa(Player player, ItemStack caixaItem, ItemStack recompensa) {
        Location loc = player.getLocation().add(player.getLocation().getDirection().normalize().multiply(1)).add(0, 1.5, 0);

        Item caixaVoando = player.getWorld().dropItem(loc, caixaItem);
        caixaVoando.setPickupDelay(Integer.MAX_VALUE); // Impedir que a caixa seja pega
        caixaVoando.setGravity(false); // Caixa flutuante, sem gravidade

        Vector direcao = player.getLocation().getDirection().normalize().multiply(0.1); // Multiplicador para ajustar a velocidade do "voo"

        new BukkitRunnable() {
            int ticks = 0;

            @Override
            public void run() {
                if (ticks > 20) {
                    caixaVoando.remove();

                    player.getInventory().addItem(recompensa);
                    player.sendMessage("§b§lYAY! §fVocê recebeu " + "§b" + recompensa.getItemMeta().getDisplayName());

                    player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation(), 30, 0.5, 0.5, 0.5, 0);
                    this.cancel();
                    return;
                }

                caixaVoando.setVelocity(direcao);

                player.getWorld().spawnParticle(Particle.CRIT_MAGIC, caixaVoando.getLocation(), 10, 0.2, 0.2, 0.2, 0);

                ticks++;
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("CaixaMisteriosa"), 0, 5);
    }
}
