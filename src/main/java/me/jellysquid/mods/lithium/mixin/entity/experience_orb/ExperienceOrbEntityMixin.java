package me.jellysquid.mods.lithium.mixin.entity.experience_orb;

import me.jellysquid.mods.lithium.common.entity.experience_orb.ExperienceOrbSize;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ExperienceOrbEntity.class)
public abstract class ExperienceOrbEntityMixin extends Entity {
    @Shadow
    private int amount;

    public ExperienceOrbEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(
            method = "getOrbSize",
            cancellable = true,
            at = @At(
                    value = "HEAD"
            )
    )
    private void getOrbSizeFaster(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(this.getExpOrbSize());
    }

    private int getExpOrbSize() {
        return ExperienceOrbSize.getEnum(this.amount).getSize();
    }

    @Inject(
            method = "roundToOrbSize",
            cancellable = true,
            at = @At(
                    value = "HEAD"
            )
    )
    private static void roundToOrbSizeFaster(int value, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(roundToExpOrbSize(value));
    }

    private static int roundToExpOrbSize(int value) {
        return ExperienceOrbSize.getEnum(value).getAmount();
    }
}
