package de.cyberanimals.listener;

import de.cyberanimals.calobby;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class calis_building
  implements Listener
{
  private calobby plugin;
  
  public calis_building(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onBuild(BlockPlaceEvent e)
  {
    Player p = e.getPlayer();
    if (p.hasPermission("cyberanimals.build"))
    {
      if (this.plugin.PBM.contains(p.getName())) {
        e.setCancelled(false);
      } else {
        e.setCancelled(true);
      }
    }
    else {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onBuildBreak(BlockBreakEvent e)
  {
    Player p = e.getPlayer();
    if (p.hasPermission("cyberanimals.build"))
    {
      if (this.plugin.PBM.contains(p.getName())) {
        e.setCancelled(false);
      } else {
        e.setCancelled(true);
      }
    }
    else {
      e.setCancelled(true);
    }
  }
}
