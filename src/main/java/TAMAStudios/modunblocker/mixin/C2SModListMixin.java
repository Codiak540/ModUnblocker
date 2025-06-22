package TAMAStudios.modunblocker.mixin;

import TAMAStudios.modunblocker.Config;
import TAMAStudios.modunblocker.Modunblocker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.FMLHandshakeMessages;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(FMLHandshakeMessages.C2SModListReply.class)
public class C2SModListMixin {

    @Shadow
    private List<String> mods;

    @Shadow private Map<ResourceLocation, String> channels;

    @Shadow private Map<ResourceLocation, String> registries;

    @Inject(method = "<init>*", at = @At("TAIL"))
    private void onConstructed(CallbackInfo ci) {
        // Filter out mod IDs from config
        if(Config.MANUAL_MODE.get()) {
            List<? extends String> hiddenMods = Config.HIDDEN_MODS.get();
            this.mods.removeIf(hiddenMods::contains);
        }
        else {
            Modunblocker.LOGGER.info("[ModUnblocker] Attempting to use this modlist (Automatic mode) {}", Modunblocker.mods);
            this.mods = Modunblocker.mods;
        }
    }
}
