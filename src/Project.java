import java.util.ArrayList;

public class Project {
    private final String name;
    private final int neededRoles;
    private final ArrayList<Skill> neededSkillsList;
    private final int daysToComplete;
    private final int score;
    private final int deadline;

    public Project(String name, ArrayList<Skill> neededSkillsList, int daysToComplete, int score, int deadline) {
        this.name = name;
        this.neededSkillsList = new ArrayList<>(neededSkillsList);
        this.daysToComplete = daysToComplete;
        this.score = score;
        this.deadline = deadline;
        this.neededRoles = this.neededSkillsList.size();
    }

    public String getName() {
        return name;
    }

    public int getNeededRoles() {
        return neededRoles;
    }

    public ArrayList<Skill> getNeededSkillsList() {
        return neededSkillsList;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }

    public int getScore() {
        return score;
    }

    public int getDeadline() {
        return deadline;
    }
}
