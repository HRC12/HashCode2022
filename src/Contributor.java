import java.util.ArrayList;
import java.util.HashMap;

import static java.util.stream.Collectors.toMap;

public class Contributor {
    private final String name;
    public HashMap<String, Integer> skillsMap = new HashMap<>();
    public ArrayList<Skill> skillsList;

    public String getName() {
        return name;
    }

    public ArrayList<Skill> getSkillsList() {
        return skillsList;
    }

    public Contributor(String name, ArrayList<Skill> skillsList) {
        this.name = name;
        this.skillsList = new ArrayList<>(skillsList);
        for(Skill s: this.skillsList){
            skillsMap.put(s.getName(), s.getLevel());
            System.out.println(s.getName() + s.getLevel());
        }
    }


}
