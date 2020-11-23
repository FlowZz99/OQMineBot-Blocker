package it.flowzz.oqminebot;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import it.flowzz.oqminebot.adapters.SettingsAdapter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        registerListener();
    }

    private void registerListener() {
        ProtocolLibrary.getProtocolManager().addPacketListener(new SettingsAdapter(new PacketAdapter.AdapterParameteters()
                .plugin(this)
                .listenerPriority(ListenerPriority.NORMAL)
                .types(PacketType.Play.Client.SETTINGS)));
    }

}
