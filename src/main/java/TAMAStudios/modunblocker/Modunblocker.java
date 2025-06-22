package TAMAStudios.modunblocker;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("modunblocker")
public class Modunblocker {
    public static List<String> mods = new ArrayList<>();

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Modunblocker() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
    }

}
