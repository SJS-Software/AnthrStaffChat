package software.sjs.anthrStaffChat.controller;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class StaffController {

    private static final HashMap<UUID,Boolean> staff = new HashMap<>();

    public static boolean isRegistered(ProxiedPlayer player) {
        return staff.containsKey(player.getUniqueId());
    }

    public static boolean register(ProxiedPlayer player) {
        if(!isRegistered(player))
            staff.put(player.getUniqueId(),true);
        return isRegistered(player);
    }

    public static boolean hasStaffChatEnabled(ProxiedPlayer player) {
        return staff.get(player.getUniqueId());
    }

    public static boolean toggleStaffChatForPlayer(ProxiedPlayer player) {
        staff.replace(player.getUniqueId(), !hasStaffChatEnabled(player));
        return hasStaffChatEnabled(player);
    }


    public static void broadcastMessage(CommandSender sender, String m) {

    }
}
