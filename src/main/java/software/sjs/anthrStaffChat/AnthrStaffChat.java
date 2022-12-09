package software.sjs.anthrStaffChat;

import net.md_5.bungee.api.plugin.Plugin;
import org.bstats.bungeecord.Metrics;
import software.sjs.anthrStaffChat.config.Config;
import software.sjs.anthrStaffChat.utils.Logging;
import software.sjs.anthrStaffChat.utils.Utils;

public class AnthrStaffChat extends Plugin {

    private static AnthrStaffChat instance;
    private static Config config = null;
    private static Metrics metrics = null;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        try {
            Logging.logPrefix("Start loading &aAnthrStaffChat");

            metrics = new Metrics(this, Utils.getBStatsId());

            if (!config.load("config.yml")) {
                return;
            }

            Logging.logPrefix("&9|",
                                "&9|  &5AnthrStaffChat - &r"+ getDescription().getVersion(),
                                "&9|  &fJust another StaffChat Plugin by "+ getDescription().getAuthor(),
                                "&9|");
        } catch (Exception exception) {
            Logging.logError(Logging.ErrorCode.UNKNOWN, "Error while starting!", exception);
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        instance = null;
        super.onDisable();
    }

    public static AnthrStaffChat getInstance() {
        return instance;
    }

    public static Config getConfig() {
        return config;
    }

    public static Metrics getMetrics() {
        return metrics;
    }

    private void loadConfigSettings() {
        
    }
}
