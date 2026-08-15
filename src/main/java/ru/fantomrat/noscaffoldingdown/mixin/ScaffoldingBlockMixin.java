package ru.fantomrat.noscaffoldingdown.mixin;

import ru.fantomrat.noscaffoldingdown.config.ModConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScaffoldingBlock.class)
public abstract class ScaffoldingBlockMixin {
	@Redirect(
			method = "getCollisionShape",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/phys/shapes/CollisionContext;isDescending()Z"
			)
	)
	private boolean requireLookingDown(CollisionContext context) {
		return context.isDescending() && isLookingDown(context);
	}

	private static boolean isLookingDown(CollisionContext context) {
		if (!(context instanceof EntityCollisionContext entityContext)) {
			return false;
		}

		if (!(entityContext.getEntity() instanceof Player player)) {
			return false;
		}

		return player.getXRot() > ModConfig.getLookDownAngle();
	}
}
