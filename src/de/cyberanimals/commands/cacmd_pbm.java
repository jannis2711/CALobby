package de.cyberanimals.commands;

import de.cyberanimals.calobby;
import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cacmd_pbm
  implements CommandExecutor
{
  private calobby plugin;
  
  public cacmd_pbm(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      if (sender.hasPermission("cyberanimals.build"))
      {
        if (this.plugin.PBM.contains(((Player)sender).getName()))
        {
          this.plugin.PBM.remove(((Player)sender).getName());
          sender.sendMessage(this.plugin.pfx + "Baumodus deaktiviert.");
          return true;
        }
        if (!this.plugin.PBM.contains(((Player)sender).getName()))
        {
          this.plugin.PBM.add(((Player)sender).getName());
          sender.sendMessage(this.plugin.pfx + "Baumodus aktiviert.");
          return true;
        }
      }
      else
      {
        sender.sendMessage(this.plugin.msgperm);
      }
    }
    else {
      sender.sendMessage("You Have to be a Player!");
    }
    return true;
  }
}
