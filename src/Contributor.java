import java.util.ArrayList;

public class Contributor {
    private final String name;

    public String getName() {
        return name;
    }

    public ArrayList<Skill> getSkillsList() {
        return skillsList;
    }

    private final ArrayList<Skill> skillsList;

    public Contributor(String name, ArrayList<Skill> skillsList) {
        this.name = name;
        this.skillsList = skillsList;
    }
}
