package dev.zywn.rewards;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Recompensas {

    private static final Random random = new Random();

    private static final List<ItemStack> recompensasBasicas = new ArrayList<>();

    private static final List<ItemStack> recompensasAvancadas = new ArrayList<>();

    static {
        recompensasBasicas.add(criarItem(Material.EMERALD, "Esmeralda"));
        recompensasBasicas.add(criarItem(Material.COOKED_BEEF, "Carne Cozida"));
        recompensasBasicas.add(criarItem(Material.STONE, "Pedra"));
        recompensasBasicas.add(criarItem(Material.WOODEN_SWORD, "Espada de Madeira"));

        recompensasAvancadas.add(criarItem(Material.DIAMOND, "Diamante"));
        recompensasAvancadas.add(criarItem(Material.GOLDEN_APPLE, "Maçã Dourada"));
        recompensasAvancadas.add(criarItem(Material.NETHERITE_SCRAP, "Fragmento de Netherita"));
        recompensasAvancadas.add(criarItem(Material.ENCHANTED_GOLDEN_APPLE, "Maçã Dourada Encantada"));
    }

    private static ItemStack criarItem(Material material, String nome) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack criarRecompensaBasica() {
        int index = random.nextInt(recompensasBasicas.size());
        return recompensasBasicas.get(index);
    }

    public static ItemStack criarRecompensaAvancada() {
        int index = random.nextInt(recompensasAvancadas.size());
        return recompensasAvancadas.get(index);
    }
}
