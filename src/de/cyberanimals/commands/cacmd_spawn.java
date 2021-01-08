package de.cyberanimals.commands;

import de.cyberanimals.calobby;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cacmd_spawn
  implements CommandExecutor
{
  private calobby plugin;
  
  public cacmd_spawn(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "warp spawn " + p.getName());
    }
    else
    {
      sender.sendMessage(this.plugin.msgplayer);
    }
    return true;
  }
}
