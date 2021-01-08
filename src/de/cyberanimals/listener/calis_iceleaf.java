package de.cyberanimals.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.LeavesDecayEvent;

public class calis_iceleaf
  implements Listener
{
  @EventHandler
  public void onLeaf(LeavesDecayEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onMelt(BlockFadeEvent e)
  {
    if (e.getBlock().getType() == Material.ICE) {
      e.setCancelled(true);
    }
  }
}
