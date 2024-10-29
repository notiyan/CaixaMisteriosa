package dev.zywn.commands;

import dev.zywn.items.CaixaItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CaixaCommand implements @Nullable CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 3) {
            sender.sendMessage(ChatColor.RED + "Uso correto: /caixa {tipo} {quantia}");
            return false;
        }

        Player player = (Player) sender;
        String tipo = args[0];
        int quantidade;

        try {
            quantidade = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Quantia inválida.");
            return false;
        }

        ItemStack caixa = CaixaItem.criarCaixa(tipo,quantidade);
        if (caixa == null) {
            sender.sendMessage(ChatColor.RED + "Tipo de caixa inválido.");
            return false;
        }

        player.getInventory().addItem(caixa);
        player.sendMessage("§b§lYAY! §fVocê recebeu " + "§b" + quantidade + "§f" + " caixas do tipo " + "§b" + tipo + "§f.");
        return true;
    }
}
