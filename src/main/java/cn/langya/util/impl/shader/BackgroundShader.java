package cn.langya.util.impl.shader;

import cn.langya.util.impl.render.RenderUtil;
import cn.langya.util.impl.shader.Shader;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL20;

public final class BackgroundShader extends Shader {

    public final static BackgroundShader BACKGROUND_SHADER = new BackgroundShader();

    private float time;

    public BackgroundShader() {
        super("background.frag");
    }

    @Override
    public void setupUniforms() {
        setupUniform("iResolution");
        setupUniform("iTime");
    }

    @Override
    public void updateUniforms() {
        final ScaledResolution scaledResolution = new ScaledResolution(mc);

        final int resolutionID = getUniform("iResolution");
        if(resolutionID > -1)
            GL20.glUniform2f(resolutionID, (float) scaledResolution.getScaledWidth() * 2, (float) scaledResolution.getScaledHeight() * 2);
        final int timeID = getUniform("iTime");
        if(timeID > -1) GL20.glUniform1f(timeID, time);

        time += 0.005F * RenderUtil.deltaTime;
    }
}