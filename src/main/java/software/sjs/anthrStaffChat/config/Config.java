package software.sjs.anthrStaffChat.config;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.config.Configuration;
import software.sjs.anthrStaffChat.AnthrStaffChat;

import java.io.File;
import java.util.logging.Level;

public class Config {

    private String fileName = null;
    private Configuration configuration;
    private File file;
    private File configFolder;

    public boolean load(String fileName) {
        this.fileName = fileName;
        this.configFolder = AnthrStaffChat.getInstance().getDataFolder();

        if(!configFolder.exists()) {
            if(!configFolder.mkdirs()) {
                ProxyServer.getInstance().getLogger().log(Level.SEVERE, "Folder could not be created");
            }

        }
        return true;
    }
}
