package TAMAStudios.modunblocker.mixin;

import TAMAStudios.modunblocker.Modunblocker;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.FMLHandshakeMessages;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(FMLHandshakeMessages.S2CModList.class)
public abstract class S2CModListMixin {
    @Inject(remap = false, method = "decode", at = @At("RETURN"))
    private static void afterDecode(PacketBuffer input, CallbackInfoReturnable<FMLHandshakeMessages.S2CModList> cir) {
        FMLHandshakeMessages.S2CModList list = cir.getReturnValue();
        List<String> mods = list.getModList();

        Modunblocker.mods.addAll(mods);
    }
}