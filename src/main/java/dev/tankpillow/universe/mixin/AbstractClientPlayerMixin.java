package dev.tankpillow.universe.mixin;


import dev.tankpillow.universe.misc.CapeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.ClientAsset;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerSkin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(AbstractClientPlayer.class)
@Environment(EnvType.CLIENT)
public class AbstractClientPlayerMixin {

    @Inject(method = "getSkin", at = @At("RETURN"), cancellable = true)
    private void injectCustomCape(CallbackInfoReturnable<PlayerSkin> cir) {
        UUID uuid = ((Player) (Object) this).getUUID();
        Identifier capeId = CapeRegistry.getCape(uuid);
        if (capeId == null) {
            return;
        }

        PlayerSkin original = cir.getReturnValue();
        cir.setReturnValue(new PlayerSkin(
                original.body(),
                new ClientAsset.ResourceTexture(capeId),
                new ClientAsset.ResourceTexture(capeId),
                original.model(),
                false
        ));
    }

}
