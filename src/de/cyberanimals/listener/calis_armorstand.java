package de.cyberanimals.listener;

import de.cyberanimals.calobby;
import java.util.ArrayList;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class calis_armorstand
  implements Listener
{
  private calobby plugin;
  
  public calis_armorstand(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onManipulate(PlayerInteractEntityEvent e)
  {
    if ((e.getRightClicked().getType() == EntityType.ARMOR_STAND) && 
      (!this.plugin.PBM.contains(e.getPlayer().getName()))) {
      e.setCancelled(true);
    }
  }
}
