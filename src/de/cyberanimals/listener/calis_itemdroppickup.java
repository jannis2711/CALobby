package de.cyberanimals.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class calis_itemdroppickup
  implements Listener
{
  @EventHandler
  public void onDrop(PlayerDropItemEvent e)
  {
    if (!e.getPlayer().hasPermission("cyberanimals.dropitem")) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onPickup(PlayerPickupItemEvent e)
  {
    if (!e.getPlayer().hasPermission("cyberanimals.pickupitem")) {
      e.setCancelled(true);
    }
  }
}
