package software.sjs.anthrStaffChat.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Logging {

    private static final String logPrefix = "[AnthrStaffChat] ";
    private static final String errorPrefix = "[&4%lError&r] &4";

    public static void log(String... messages) {
        for(String message : messages) {
            ProxyServer.getInstance().getConsole().sendMessage(formatMessage(message));
        }
    }

    public static void logPrefix(String... messages) {
        for(String message : messages) {
            ProxyServer.getInstance().getConsole().sendMessage(formatMessage(logPrefix + message));
        }
    }

    public static void logError(ErrorCode errorCode, String message, Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);

        logPrefix(
                errorPrefix + errorCode.getMessage(),
                errorPrefix + "Error code: "+ errorCode.getCode(),
                errorPrefix + "Message: " + message,
                errorPrefix + "Stack trace: \n" + stringWriter.toString()
        );

        try {
            printWriter.close();
            stringWriter.close();
        }catch (IOException exception) {
            logError(ErrorCode.UNKNOWN, ErrorCode.UNKNOWN.getMessage() );
        }
    }

    public static void logError(ErrorCode errorCode, String message) {
        logPrefix(
                errorPrefix + errorCode.getMessage(),
                errorPrefix + "Error code: "+ errorCode.getCode(),
                errorPrefix + "Message: " + message
        );
    }

    public static BaseComponent[] formatMessage(String message) {
        return TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message));
    }

    public enum ErrorCode {
        UNKNOWN("UNKNOWN", 1, "An unexpected error occurred."),
        GENERATE_FOLDER_FAILED("FOLDER_GENERATE", 2, "An error occurred while trying to generate plugin folder."),
        GENERATE_FILE_FAILED("FILE_GENERATE", 3, "An error occurred while trying to generate configuration file."),
        LOAD_CONFIG_FAILED("CONFIG_LOAD", 4, "An error occurred while trying to load configuration file.");

        private final String code;
        private final int id;
        private final String message;

        ErrorCode(String code, int id, String message) {
            this.code = code;
            this.id = id;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public int getId() {
            return id;
        }

        public String getMessage() {
            return message;
        }
    }
}
