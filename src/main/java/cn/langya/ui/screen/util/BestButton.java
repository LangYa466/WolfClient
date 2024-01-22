package cn.langya.ui.screen.util;

import cn.langya.ui.font.FontDrawer;
import cn.langya.util.Util;
import cn.langya.util.impl.render.RoundedUtils;

import java.awt.*;

/**
 * @author LangYa
 * @date 2024/1/21 下午 02:28
 */

public class BestButton extends Util {
    protected float x, y;
    protected float width, height;
    Color color;
    public int hoverFade = 0;
    public BestButton(float x, float y, float width, float height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public BestButton(double x, double y, double width, double height, Color color) {
        this.x = (float) x;
        this.y = (float) y;
        this.width = (float) width;
        this.height = (float) height;
        this.color = color;
    }

    public void draw(int mouseX, int mouseY) {
        boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
        if (hovered) {
            if (hoverFade < 40) hoverFade += 10;
        } else {
            if (hoverFade > 0) hoverFade -= 10;
        }

        RoundedUtils.drawRound(x,y,width, height,5, color);
        RoundedUtils.drawRound(x,y + width / 5 - 4,width, 3,2, Color.white);
    }
}
