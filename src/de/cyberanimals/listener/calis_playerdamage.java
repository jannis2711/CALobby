package de.cyberanimals.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class calis_playerdamage
  implements Listener
{
  @EventHandler
  public void onDamage(EntityDamageEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onDMGbyEntity(EntityDamageByEntityEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if ((e.getDamager() instanceof Player))
      {
        Player d = (Player)e.getDamager();
        if (d.hasPermission("cyberanimals.dopvp")) {
          e.setCancelled(false);
        } else {
          e.setCancelled(true);
        }
      }
    }
  }
}
