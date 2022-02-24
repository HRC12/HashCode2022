public class Skill {
    private final String name;

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    private final int level;

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
