package software.sjs.anthrStaffChat.staffchat.listener;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import software.sjs.anthrStaffChat.AnthrStaffChat;
import software.sjs.anthrStaffChat.controller.StaffController;

public class StaffChatListener implements Listener {

    @EventHandler
    public void onJoinProxyEvent(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        if(player.hasPermission(AnthrStaffChat.getConfig().getString("PERMISSION_USE"))) {
            StaffController.register(player);
        }
    }

    @EventHandler
    public void onStaffMessage(ChatEvent event) {
        if(event.isCommand() || event.isProxyCommand())
            return;
        if((event.getSender() instanceof ProxiedPlayer player) && ((ProxiedPlayer) event.getSender()).hasPermission(AnthrStaffChat.getConfig().getString("PERMISSION_USE")) ) {
            if(StaffController.hasStaffChatEnabled(player)) {

           }
        }
        if((event.getSender() instanceof ProxiedPlayer) && StaffController.hasStaffChatEnabled((ProxiedPlayer) event.getSender())) {

        }
    }
}
