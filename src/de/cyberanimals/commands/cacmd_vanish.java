package de.cyberanimals.commands;

import de.cyberanimals.calobby;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cacmd_vanish
  implements CommandExecutor
{
  private calobby plugin;
  
  public cacmd_vanish(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!sender.hasPermission("cyberanimals.vanish")) {
      sender.sendMessage(this.plugin.msgperm);
      return true;
    }
    if (!(sender instanceof Player)) {
      sender.sendMessage(this.plugin.msgplayer);
      return true;
    }
    Player p = (Player)sender;
    if (!this.plugin.VANISHED.contains(p.getName()))
    {
      this.plugin.VANISHED.add(p.getName());
      for (Player all : Bukkit.getOnlinePlayers())
      {
        
        if (!all.hasPermission("cyberanimals.seeVanished")) {
          all.hidePlayer(p);
        }
      }
      p.sendMessage(this.plugin.pfx + "Du hast dich unsichtbar gemacht!");
      return true;
    }
    if (this.plugin.VANISHED.contains(p.getName()))
    {
      this.plugin.VANISHED.remove(p.getName());
      for (Player all : Bukkit.getOnlinePlayers())
      {
        
        all.showPlayer(p);
      }
      p.sendMessage(this.plugin.pfx + "Du bist nun sichtbar!");
      return true;
    }
    return true;
  }
}
