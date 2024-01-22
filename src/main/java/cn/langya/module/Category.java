package cn.langya.module;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:11
 */
public enum Category {

    Combat("战斗"),
    Move("移动"),
    World("世界"),
    Render("渲染"),
    Client("客户端"),
    Misc("其他"),
    Player("玩家");

    public final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

}
