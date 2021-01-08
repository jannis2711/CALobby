package de.cyberanimals.listener;

import de.cyberanimals.calobby;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class calis_chatmanager
  implements Listener
{
  private calobby plugin;
  
  public calis_chatmanager(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    
    ArrayList<String> beleidigungen = new ArrayList();
    beleidigungen.add("hure");
    beleidigungen.add("arsch");
    beleidigungen.add("arschloch");
    beleidigungen.add("hurensohn");
    beleidigungen.add("nutte");
    beleidigungen.add("wixxer");
    beleidigungen.add("wichser");
    beleidigungen.add("wixa");
    beleidigungen.add("wichsa");
    beleidigungen.add("hitler");
    beleidigungen.add("hitla");
    beleidigungen.add("nuttenbumser");
    beleidigungen.add("scheiße");
    beleidigungen.add("scheisse");
    beleidigungen.add("dumme hure");
    beleidigungen.add("spasti");
    beleidigungen.add("spast");
    beleidigungen.add("behindert");
    beleidigungen.add("nigger");
    beleidigungen.add("nigga");
    beleidigungen.add("n1gg4");
    beleidigungen.add("noob");
    beleidigungen.add("n00b");
    for (String beleidigung : beleidigungen) {
      if (e.getMessage().contains(beleidigung))
      {
        e.setCancelled(true);
        p.sendMessage(this.plugin.epfx + "Pass auf deine Wortwahl auf! Solche Leute können wir hier gar nicht gebrauchen.");
        break;
      }
    }
  }
}
