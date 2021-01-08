package de.cyberanimals.listener;

import de.cyberanimals.lobbyfunctions;
import de.cyberanimals.calobby;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;

public class calis_cmdevent
  implements Listener
{
  private calobby plugin;
  
  public calis_cmdevent(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onCMD(PlayerCommandPreprocessEvent e)
  {
    String[] eingabe = e.getMessage().split(" ");
    
    String cmd = eingabe[0];
    if (!e.isCancelled())
    {
      HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
      if (topic == null)
      {
        e.getPlayer().sendMessage(this.plugin.epfx + "Der Befehl existiert nicht. §e§l[" + cmd + "]");
        e.setCancelled(true);
      }
    }
    List cmds = new ArrayList();
    
    cmds.add("/plugins");
    cmds.add("/pl");
    cmds.add("/me");
    cmds.add("/help");
    cmds.add("/?");
    if (cmd.equalsIgnoreCase("/help"))
    {
      e.setCancelled(true);
      this.plugin.cfunctions.helpCommand(e.getPlayer());
      return;
    }
    if ((cmds.contains(cmd)) && 
      (!e.getPlayer().hasPermission("cyberanimals.useblockedcmds")))
    {
      e.getPlayer().sendMessage("§fUnknown command. Type https://cyberanimals.de/help/ in your Browser for help.");
      e.setCancelled(true);
    }
  }
}
