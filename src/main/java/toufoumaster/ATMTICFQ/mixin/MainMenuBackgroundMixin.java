package toufoumaster.ATMTICFQ.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.GLAllocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.MainMenuBackground;
import net.minecraft.client.render.TextureManager;
import net.minecraft.client.render.texture.Texture;
import net.minecraft.core.util.helper.Buffer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


@Mixin(value = MainMenuBackground.class, remap = false)
public class MainMenuBackgroundMixin {

	@Inject(method = "loadRandomBackground()Lnet/minecraft/client/gui/MainMenuBackground$Background;", at = @At("HEAD"), cancellable = true)
	@Environment(EnvType.CLIENT)
	public void loadRandomBackground(CallbackInfoReturnable<MainMenuBackground.Background> cir) throws IOException {
		InputStream stream = Minecraft.getMinecraft().texturePackList.getResourceAsStream("bg.png");
		BufferedImage image = ImageIO.read(stream);
		Buffer.put(image);
		int texture = GLAllocation.generateTexture();
		GL11.glBindTexture(3553, texture);
		GL11.glTexImage2D(3553, 0, 6408, image.getWidth(), image.getHeight(), 0, 6408, 5121, Buffer.buffer);
		GL11.glTexParameteri(3553, 10241, 9729);
		GL11.glTexParameteri(3553, 10240, 9729);
		GL11.glTexParameteri(3553, 10242, 10496);
		GL11.glTexParameteri(3553, 10243, 10496);
		TextureManager textureManager = Minecraft.getMinecraft().textureManager;
		cir.setReturnValue(new MainMenuBackground.Background(texture, image.getWidth(), image.getHeight()));
	}
}
