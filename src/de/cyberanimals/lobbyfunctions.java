package de.cyberanimals;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bukkit.entity.Player;
import de.cyberanimals.calobby;

public class lobbyfunctions
{
  private calobby plugin;
  
  public lobbyfunctions(calobby plugin)
  {
    this.plugin = plugin;
  }
  
  public void plusCoins(String playername, int coins)
  {
    String qry = "UPDATE `statistics` SET `points`=points+" + coins + " WHERE playername='" + playername + "'";
    
    this.plugin.CASQL.update(qry);
  }
  
  public int getCoins(String playername)
  {
    int coins = 0;
    try
    {
      ResultSet rs = this.plugin.CASQL.getResult("SELECT `points` FROM `statistics` WHERE playername='" + playername + "'");
      while (rs.next()) {
        coins = rs.getInt("points");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return -1;
    }
    return coins;
  }
  
  public void helpCommand(Player p) {}
}
