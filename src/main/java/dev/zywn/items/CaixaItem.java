package dev.zywn.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CaixaItem {

    public static ItemStack criarCaixa(String tipo, int quantidade) {
        ItemStack caixa;

        if (tipo.equalsIgnoreCase("Basico")) {
            caixa = new ItemStack(Material.CHEST, quantidade);
            ItemMeta meta = caixa.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Caixa Básica");
            caixa.setItemMeta(meta);
        } else if (tipo.equalsIgnoreCase("Avancado")) {
            caixa = new ItemStack(Material.ENDER_CHEST, quantidade);
            ItemMeta meta = caixa.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Caixa Avançada");
            caixa.setItemMeta(meta);
        } else {
            return null;
        }

        return caixa;
    }
}
