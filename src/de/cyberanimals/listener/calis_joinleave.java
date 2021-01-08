package de.cyberanimals.listener;

import de.cyberanimals.calobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class calis_joinleave
  implements Listener
{
  private calobby plugin;
  
  public calis_joinleave(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    if (p.hasPermission("cyberanimals.showjoinmessage")) {
      e.setJoinMessage("§c" + p.getName() + " §6hat den Server betreten.");
    } else {
      e.setJoinMessage(null);
    }
    if (!e.getPlayer().hasPermission("cyberanimals.notpspawn")) {
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "warp spawn " + p.getName());
    }
    if (!e.getPlayer().hasPermission("cyberanimals.seevanished")) {
      for (String pname : this.plugin.VANISHED)
      {
        Player t = Bukkit.getPlayer(pname);
        if (t != null) {
          e.getPlayer().hidePlayer(t);
        }
      }
    }
  }
  
  @EventHandler
  public void onLeave(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (p.hasPermission("cyberanimals.showleavemessage")) {
      e.setQuitMessage("§c" + p.getName() + " §6hat den Server verlassen.");
    } else {
      e.setQuitMessage(null);
    }
  }
}
