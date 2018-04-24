package play.bratiwkaslam.cmdprotect;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Main extends JavaPlugin implements Listener {

    FileConfiguration config;

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.config = getConfig();
        this.config.options().copyDefaults(true);
        saveConfig();
    }

    @EventHandler
    public void onCommand(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();


        if (!((player.getName().equals("BratiwkaSlam") || (player.getName().equals("Korwillion"))
                ||(player.getName().equals("XRayFun_GF"))))){
            List<String> commands = getConfig().getStringList("commands");
            for (String blockcmds : commands){
                if (message.equalsIgnoreCase("/" + blockcmds)){
                    e.setCancelled(true);
                }
            }
        }
    }
}