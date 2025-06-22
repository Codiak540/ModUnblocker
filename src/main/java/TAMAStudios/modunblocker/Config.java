package TAMAStudios.modunblocker;


import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;
public class Config {

        public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
        public static final ForgeConfigSpec CLIENT_SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> HIDDEN_MODS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> MANUAL_MODE;

        static {
            HIDDEN_MODS = BUILDER
                    .comment("List of mod IDs to hide from the server")
                    .defineList("hidden_mods",
                            () -> Arrays.asList("modunblocker"),  // Default values
                            o -> o instanceof String              // Validator
                    );

            MANUAL_MODE = BUILDER.comment("if true: enable manual mode (manual mode uses the list, automatic will attempt to automatically match the modlist)").define("manual_mode", false);

            CLIENT_SPEC = BUILDER.build();
        }
    }
