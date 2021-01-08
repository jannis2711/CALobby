package de.cyberanimals.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class calis_foodlevel
  implements Listener
{
  @EventHandler
  public void onFood(FoodLevelChangeEvent e)
  {
    e.setCancelled(true);
    e.setFoodLevel(20);
    Player p = (Player)e.getEntity();
    p.setFoodLevel(20);
  }
}
