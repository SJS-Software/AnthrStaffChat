package software.sjs.anthrStaffChat.config;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import software.sjs.anthrStaffChat.AnthrStaffChat;
import software.sjs.anthrStaffChat.utils.Logging;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class Config {

    private String fileName = null;
    private Configuration configuration;
    private File configFile;
    private File configFolder;

    private final HashMap<String,String> configSettings = new HashMap<>();

    public boolean load(String fileName) {
        this.fileName = fileName;
        this.configFolder = AnthrStaffChat.getInstance().getDataFolder();

        if(!configFolder.exists())
            if(!configFolder.mkdirs()) {
                Logging.logError(Logging.ErrorCode.GENERATE_FOLDER_FAILED, "Failed to generate folder");
                return false;
            }

        configFile = new File(configFolder, fileName);

        if(!configFile.exists()) {
            try {
                InputStream inputStream = AnthrStaffChat.getInstance().getResourceAsStream(fileName);
                Files.copy(inputStream, configFile.toPath());
                inputStream.close();
            } catch(IOException exception) {
                Logging.logError(Logging.ErrorCode.GENERATE_FILE_FAILED, "Failed to generate " + fileName, exception);
                return false;
            }
        }

        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        }catch (IOException exception) {
            Logging.logError(Logging.ErrorCode.LOAD_CONFIG_FAILED, "Failed to load "+ fileName, exception);
            return false;
        }

        return true;
    }

    public boolean reload() {
        return load(fileName);
    }

    public String getString(String path) {
        if(configuration == null)
            return null;
        return configuration.getString(path);
    }

    public Boolean getBoolean(String path) {
        if(null == configuration)
            return null;
        return configuration.getBoolean(path);
    }

    public Integer getInteger(String path) {
        if(null == configuration)
            return null;
        return configuration.getInt(path);
    }

    public List<String> getStringList(String path) {
        if(null == configuration)
            return null;
        return configuration.getStringList(path);
    }

    public int getVersion() {
        if(null == configuration)
            return -1;
        return configuration.getInt("version");
    }

    public String getFileName() {
        return fileName;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public File getConfigFile() {
        return configFile;
    }

    public HashMap<String, String> getConfigSettings() {
        return configSettings;
    }
}
