package it.flowzz.oqminebot.adapters;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;

public class SettingsAdapter extends PacketAdapter {

    public SettingsAdapter(AdapterParameteters params) {
        super(params);
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        int skinMask = event.getPacket().getIntegers().read(1);
        System.out.println("SkinMask -> " + skinMask);
        /*
        OQMineBot usually doesn't send skinmask bytes

        Bit 0 (0x01): Cape enabled
        Bit 1 (0x02): Jacket enabled
        Bit 2 (0x04): Left Sleeve enabled
        Bit 3 (0x08): Right Sleeve enabled
        Bit 4 (0x10): Left Pants Leg enabled
        Bit 5 (0x20): Right Pants Leg enabled
        Bit 6 (0x40): Hat enabled

        Usually a normal player send 0x7F
        OQMineBot send 0x00
         */
        if(skinMask == 0){
            Bukkit.getScheduler().runTask(plugin, () -> event.getPlayer().kickPlayer("§7OQMineBot Detected!"));
        }
    }
}
