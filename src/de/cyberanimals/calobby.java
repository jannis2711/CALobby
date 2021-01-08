package de.cyberanimals;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.cyberanimals.commands.cacmd_gamemode;
import de.cyberanimals.commands.cacmd_pbm;
import de.cyberanimals.commands.cacmd_setspawn;
import de.cyberanimals.commands.cacmd_spawn;
import de.cyberanimals.commands.cacmd_sun;
import de.cyberanimals.commands.cacmd_vanish;
import de.cyberanimals.core.CACore;
import de.cyberanimals.core.CAMySQL;
import de.cyberanimals.listener.calis_armorstand;
import de.cyberanimals.listener.calis_building;
import de.cyberanimals.listener.calis_chatmanager;
import de.cyberanimals.listener.calis_cmdevent;
import de.cyberanimals.listener.calis_foodlevel;
import de.cyberanimals.listener.calis_iceleaf;
import de.cyberanimals.listener.calis_itemdroppickup;
import de.cyberanimals.listener.calis_joinleave;
import de.cyberanimals.listener.calis_playerdamage;
import de.cyberanimals.listener.calis_weatherchange;

public class calobby
  extends JavaPlugin
{

	
  public String pfx;
  public String cpfx;
  public String epfx;
  public String msgperm;
  public String msgplayer;
  
  public CAMySQL CASQL;
  public lobbyfunctions cfunctions = new lobbyfunctions(this);
  public ArrayList<String> PBM = new ArrayList();
  public ArrayList<String> VANISHED = new ArrayList();
  public File cfgf = new File("CALobby/config.yml");
  public FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.cfgf);
  public File signcfgf = new File("CALobby/signcfg.yml");
  public FileConfiguration scfg = YamlConfiguration.loadConfiguration(this.signcfgf);
  
  public void onEnable()
  {
    System.out.println(this.cpfx + "Lobby Core start activating...");
    loadCyberAnimals();
    this.CASQL = de.cyberanimals.core.CACore.getMySQL();
    if(CASQL == null) {
    	System.out.println("Sorry. Plugin [CYBERCORE] not available. Shutting down.");
    	Bukkit.getPluginManager().disablePlugin(this);
    } else {
    	System.out.println("Hooked into CyberCore. Plugin loaded. MySQL available.");
    }
    
	this.pfx = CACore.getPFX();
	this.cpfx = CACore.getCPFX();
	this.epfx = CACore.getEPFX();
	this.msgperm = CACore.getMSGPERM();
	this.msgplayer = CACore.getMSGPLAYER();
   
    
    
    System.out.println(this.cpfx + "Lobby Core loaded successfully.");
  }
  
  public void onDisable()
  {
    System.out.println(this.cpfx + "Lobby Core start deactivating...");
    
    
    System.out.println(this.cpfx + "Lobby Core deactivated successfully.");
  }
  
  public void loadCyberAnimals()
  {
    
    
    PluginManager pm = Bukkit.getPluginManager();
    getCommand("gamemode").setExecutor(new cacmd_gamemode(this));
    getCommand("sun").setExecutor(new cacmd_sun(this));
    pm.registerEvents(new calis_joinleave(this), this);
    pm.registerEvents(new calis_building(this), this);
    pm.registerEvents(new calis_foodlevel(), this);
    pm.registerEvents(new calis_playerdamage(), this);
    pm.registerEvents(new calis_cmdevent(this), this);
    pm.registerEvents(new calis_iceleaf(), this);
    pm.registerEvents(new calis_weatherchange(), this);
    pm.registerEvents(new calis_armorstand(this), this);
    pm.registerEvents(new calis_itemdroppickup(), this);
    pm.registerEvents(new calis_chatmanager(this), this);
    getCommand("buildmode").setExecutor(new cacmd_pbm(this));
    getCommand("setspawn").setExecutor(new cacmd_setspawn(this));
    getCommand("spawn").setExecutor(new cacmd_spawn(this));
    getCommand("vanish").setExecutor(new cacmd_vanish(this));
    
    System.out.println(this.cpfx + "Events are loaded successfully.");
  }
}
