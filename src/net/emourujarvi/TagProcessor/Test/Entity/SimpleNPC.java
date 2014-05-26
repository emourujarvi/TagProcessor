package net.emourujarvi.TagProcessor.Test.Entity;

public class SimpleNPC {

    public enum Field {
        NAME, AGE;
    }

    private String name;
    private Integer age;

    public SimpleNPC(String name, Integer age) {
        setName(name);
        setAge(age);
    }

    public String getFieldValue(Field f) {
        switch (f) {
            case NAME:
                return getName();
            case AGE:
                return getAge().toString();
            default:
                return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
