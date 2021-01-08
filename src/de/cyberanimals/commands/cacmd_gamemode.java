package de.cyberanimals.commands;

import de.cyberanimals.calobby;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cacmd_gamemode
  implements CommandExecutor
{
  private calobby plugin;
  
  public cacmd_gamemode(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  public void pSetGameMode(Player p, String gm)
  {
    if ((gm.equalsIgnoreCase("CREATIVE")) || (gm.equalsIgnoreCase("c")) || (gm.equalsIgnoreCase("1")))
    {
      p.setGameMode(GameMode.CREATIVE);
      p.sendMessage(this.plugin.pfx + "Dein Spielmodus wurde zu Kreativ/Creative/1 geändert.");
      return;
    }
    if ((gm.equalsIgnoreCase("SURVIVAL")) || (gm.equalsIgnoreCase("s")) || (gm.equalsIgnoreCase("0")))
    {
      p.setGameMode(GameMode.SURVIVAL);
      p.sendMessage(this.plugin.pfx + "Dein Spielmodus wurde zu §berleben/Survival/0 geändert.");
      return;
    }
    if ((gm.equalsIgnoreCase("ADVENTURE")) || (gm.equalsIgnoreCase("a")) || (gm.equalsIgnoreCase("2")))
    {
      p.setGameMode(GameMode.ADVENTURE);
      p.sendMessage(this.plugin.pfx + "Dein Spielmodus wurde zu Abenteuer/Adventure/2 geändert.");
      return;
    }
    if ((gm.equalsIgnoreCase("SPECTATOR")) || (gm.equalsIgnoreCase("spec")) || (gm.equalsIgnoreCase("3")))
    {
      p.setGameMode(GameMode.SPECTATOR);
      p.sendMessage(this.plugin.pfx + "Dein Spielmodus wurde zu Zuschauer/Spectator/3 geändert.");
      return;
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (sender.hasPermission("cyberanimals.gamemode"))
    {
      if ((sender instanceof Player))
      {
        if (args.length < 1)
        {
          sender.sendMessage("§6Syntax: §c/gamemode <GameMode> [Player]");
          sender.sendMessage("§6Syntax: §c/gm <GameMode> [Player]");
        }
        if (args.length == 1)
        {
          String gamemode = args[0];
          pSetGameMode((Player)sender, gamemode);
        }
        if (args.length == 2)
        {
          String gamemode = args[0];
          String playername = args[1];
          Player p = Bukkit.getPlayer(playername);
          if (p != null)
          {
            pSetGameMode(p, gamemode);
            sender.sendMessage(this.plugin.pfx + "Der Spielmodus von " + p.getName() + " wurde geändert.");
          }
          else
          {
            sender.sendMessage(this.plugin.epfx + "Fehler. Der Spieler wurde nicht gefunden.");
          }
        }
      }
      else
      {
        if (args.length < 2)
        {
          sender.sendMessage("§6Syntax: §c/gamemode <Player> <GameMode>");
          sender.sendMessage("§6Syntax: §c/gm <Player> <GameMode>");
          return true;
        }
        if (args.length == 2)
        {
          String gamemode = args[0];
          String playername = args[1];
          Player p = Bukkit.getPlayer(playername);
          if (p != null)
          {
            pSetGameMode(p, gamemode);
            sender.sendMessage(this.plugin.pfx + "Der Spielmodus von " + p.getName() + " wurde geändert.");
          }
          else
          {
            sender.sendMessage(this.plugin.epfx + "Fehler. Der Spieler wurde nicht gefunden.");
          }
        }
      }
    }
    else {
      sender.sendMessage(this.plugin.msgperm);
    }
    return true;
  }
}
