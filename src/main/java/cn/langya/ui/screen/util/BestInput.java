package cn.langya.ui.screen.util;

import cn.langya.ui.font.FontDrawer;
import cn.langya.util.Util;
import cn.langya.util.impl.render.RoundedUtils;

import java.awt.*;

/**
 * @author LangYa
 * @date 2024/1/21 下午 02:31
 */

public class BestInput extends Util {
    protected float x, y;
    protected float width, height;
    Color color;
    public int hoverFade = 0;
    public BestInput(float x, float y, float width, float height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public BestInput(double x, double y, double width, double height, Color color) {
        this.x = (float) x;
        this.y = (float) y;
        this.width = (float) width;
        this.height = (float) height;
        this.color = color;
    }

    public void draw(String text, FontDrawer fontDrawer,Color fontcolor, int mouseX, int mouseY) {
        boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
        if (hovered) {
            if (hoverFade < 40) hoverFade += 10;
        } else {
            if (hoverFade > 0) hoverFade -= 10;
        }

        RoundedUtils.drawRound(x,y,width, height,0, color);
        fontDrawer.drawCenteredString(text,x + 40,y + 5,-1);

    }
}