package de.cyberanimals.commands;

import de.cyberanimals.calobby;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cacmd_setspawn
  implements CommandExecutor
{
  private calobby plugin;
  
  public cacmd_setspawn(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      if (p.hasPermission("cyberanimals.setspawn"))
      {
        p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
        p.sendMessage(this.plugin.pfx + "Der Spawnpunkt wurde gesetzt.");
      }
    }
    else
    {
      sender.sendMessage(this.plugin.msgplayer);
    }
    return true;
  }
}
