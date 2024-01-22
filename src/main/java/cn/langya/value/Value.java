package cn.langya.value;

public abstract class Value<V>
{
    public Object value;
    public String name;

    public Value(final String name,final Object value) {
        this.name = name;
        this.value = value;
    }

}
