package cn.langya.module.impl.player;

import cn.langya.event.impl.render.EventRender3D;
import cn.langya.module.Category;
import cn.langya.module.Module;
import cn.langya.ui.font.FontDrawer;
import cn.langya.ui.font.FontManager;
import cn.langya.util.impl.render.RenderUtil;
import com.cubk.event.annotations.EventTarget;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Timer;
import org.lwjgl.opengl.GL11;

public class NameTags extends Module {

    public NameTags() {
        super("NameTags", Category.Render);
        state = true;
    }


    // 1fscaleValue
    @EventTarget
    public void onRender3D(EventRender3D event) {
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glPushMatrix();

        // Disable lightning and depth test
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        GL11.glEnable(GL11.GL_LINE_SMOOTH);

        // Enable blend
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        for (Entity entity : mc.theWorld.loadedEntityList) {
            if (!(entity instanceof EntityLivingBase) || entity == mc.thePlayer) continue;
            String text = entity.getDisplayName().getUnformattedText();
            renderNameTag((EntityLivingBase) entity, text);
        }

        GL11.glPopMatrix();
        GL11.glPopAttrib();

        // Reset color
        GlStateManager.resetColor();
    }

    private void renderNameTag(EntityLivingBase entity, String tag) {
        FontDrawer fontRenderer = FontManager.T15;

        // Modify tag
        String nameColor = "§6";

        String distanceText = "§7" + Math.round(mc.thePlayer.getDistanceToEntity(entity)) + "m ";
        String healthText = "§7§c " + Math.round(entity.getHealth()) + " HP";

        String text = distanceText + nameColor + tag + healthText;

        // Push
        GL11.glPushMatrix();

        // Translate to player position
        Timer timer = mc.timer;
        RenderManager renderManager = mc.getRenderManager();


        GL11.glTranslated( // Translate to player position with render pos and interpolate it
                entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * timer.renderPartialTicks - renderManager.renderPosX,
                entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * timer.renderPartialTicks - renderManager.renderPosY + entity.getEyeHeight() + 0.55,
                entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * timer.renderPartialTicks - renderManager.renderPosZ
        );

        GL11.glRotatef(-renderManager.playerViewY, 0F, 1F, 0F);
        GL11.glRotatef(renderManager.playerViewX, 1F, 0F, 0F);


        // Scale
        float distance = mc.thePlayer.getDistanceToEntity(entity) * 0.25f;

        if (distance < 1F)
            distance = 1F;

        float scale = distance / 100f * 1f;

        GL11.glScalef(-scale, -scale, scale);


        // Draw NameTag
        float width = fontRenderer.getStringWidth(text) * 0.5f;

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);

        RenderUtil.quickDrawRect(-width - 2F, -2F, width + 4F, fontRenderer.FONT_HEIGHT + 2F, Integer.MIN_VALUE);

        GL11.glEnable(GL11.GL_TEXTURE_2D);

        fontRenderer.drawString(text, 1F + -width, 1.5F, 0xFFFFFF, true);


        if (entity instanceof EntityPlayer) {
            for (int index = 0; index < 4; index++) {
                if (entity.getEquipmentInSlot(index) == null)
                    continue;

                mc.getRenderItem().zLevel = -147F;
                mc.getRenderItem().renderItemAndEffectIntoGUI(entity.getEquipmentInSlot(index), -50 + index * 20, -22);
            }

            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableTexture2D();
        }

        // Pop
        GL11.glPopMatrix();
    }
}
