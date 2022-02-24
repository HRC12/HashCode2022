public class Skill {
    private final String name;

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    private int level;

    public void incf(){
        this.level++;
    }

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
