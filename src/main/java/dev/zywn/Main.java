package dev.zywn;

import dev.zywn.animations.CaixaAnimations;
import dev.zywn.commands.CaixaCommand;
import dev.zywn.rewards.Recompensas;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private static Main Instance;
    @Override
    public void onEnable() {
        Instance = this;

        Bukkit.getPluginManager().registerEvents(this, this);
        this.getCommand("caixa").setExecutor(new CaixaCommand());
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getHand() == EquipmentSlot.HAND) {
            ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

            if (item != null && item.getType() == Material.CHEST && item.getItemMeta() != null &&
                    item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Caixa Básica")) {

                ItemStack recompensa = Recompensas.criarRecompensaBasica();

                CaixaAnimations.animarCaixa(event.getPlayer(), item, recompensa);

                item.setAmount(item.getAmount() - 1);

            } else if (item != null && item.getType() == Material.ENDER_CHEST && item.getItemMeta() != null &&
                    item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Caixa Avançada")) {

                ItemStack recompensa = Recompensas.criarRecompensaAvancada();

                CaixaAnimations.animarCaixa(event.getPlayer(), item, recompensa);

                item.setAmount(item.getAmount() - 1);
            }
        }
    }

    public void onDisable() {
    }
}