package de.cyberanimals.commands;

import de.cyberanimals.calobby;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cacmd_sun
  implements CommandExecutor
{
  private calobby plugin;
  
  public cacmd_sun(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      if (p.hasPermission("cyberanimals.sun"))
      {
        p.getWorld().setStorm(false);
        p.getWorld().setThundering(false);
        Bukkit.dispatchCommand(p, "weather clear");
        p.sendMessage(this.plugin.pfx + "Das Wetter wurde zu SCHÖN geändert.");
      }
      else
      {
        p.sendMessage(this.plugin.msgperm);
      }
    }
    return true;
  }
}
