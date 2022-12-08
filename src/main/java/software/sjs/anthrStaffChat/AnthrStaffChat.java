package software.sjs.anthrStaffChat;

import net.md_5.bungee.api.plugin.Plugin;
import software.sjs.anthrStaffChat.config.Config;

public class AnthrStaffChat extends Plugin {

    private static AnthrStaffChat instance;
    private static Config config = null;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static AnthrStaffChat getInstance() {
        return instance;
    }

    public static Config getConfig() {
        return config;
    }
}
