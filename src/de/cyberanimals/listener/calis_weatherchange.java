package de.cyberanimals.listener;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class calis_weatherchange
  implements Listener
{
  @EventHandler
  public void onChange(WeatherChangeEvent e)
  {
    e.setCancelled(true);
    e.getWorld().setThundering(false);
  }
}
