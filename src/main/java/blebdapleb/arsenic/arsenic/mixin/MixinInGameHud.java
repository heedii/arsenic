package blebdapleb.arsenic.arsenic.mixin;

import blebdapleb.arsenic.arsenic.Arsenic;
import blebdapleb.arsenic.arsenic.event.events.EventRenderCrosshair;
import blebdapleb.arsenic.arsenic.event.events.EventRenderInGameHud;
import blebdapleb.arsenic.arsenic.event.events.EventRenderOverlay;
import blebdapleb.arsenic.arsenic.gui.Hud;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleManager;
import blebdapleb.arsenic.arsenic.module.mods.combat.Hitbox;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {

	@Unique private boolean bypassRenderOverlay = false;
	@Unique private boolean bypassRenderCrosshair = false;

	@Shadow private void renderOverlay(MatrixStack matrices, Identifier texture, float opacity) {}
	@Shadow private void renderCrosshair(MatrixStack matrices) {}

	@Inject(method = "render", at = @At("RETURN"), cancellable = true)
	private void render(MatrixStack matrixStack, float tickDelta, CallbackInfo info) {
		EventRenderInGameHud event = new EventRenderInGameHud(matrixStack);
		Arsenic.eventBus.post(event);

		Hud.render(matrixStack, tickDelta); // RENDERS HUD

		if (event.isCancelled()) {
			info.cancel();
		}
	}

	@Inject(method = "renderOverlay", at = @At("HEAD"), cancellable = true)
	private void renderOverlay(MatrixStack matrices, Identifier texture, float opacity, CallbackInfo ci) {
		if (!bypassRenderOverlay) {
			EventRenderOverlay event = new EventRenderOverlay(matrices, texture, opacity);
			Arsenic.eventBus.post(event);

			if (!event.isCancelled()) {
				bypassRenderOverlay = true;
				renderOverlay(matrices, event.getTexture(), event.getOpacity());
				bypassRenderOverlay = false;
			}

			ci.cancel();
		}
	}


	@Inject(method = "renderCrosshair", at = @At("HEAD"), cancellable = true)
	private void renderCrosshair(MatrixStack matrices, CallbackInfo callback) {
		if (!bypassRenderCrosshair) {
			EventRenderCrosshair event = new EventRenderCrosshair(matrices);
			Arsenic.eventBus.post(event);

			if (!event.isCancelled()) {
				bypassRenderCrosshair = true;
				renderCrosshair(event.getMatrices());
				bypassRenderCrosshair = false;
			}

			callback.cancel();
		}
	}
}
