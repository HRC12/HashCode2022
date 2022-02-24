import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataIngest {
    static final String PATH = "data/a_an_example.in.txt";

    public static DataContainer ReadFile (String path) {
        ArrayList<Contributor> conts = new ArrayList<>();
        ArrayList<Project> proj = new ArrayList<>();

        if (path.equals(""))
            path = PATH;
        File file = new File(path);

        try {
            Scanner reader = new Scanner(file);
            //reading number of conts and projs
            int contNum = reader.nextInt();
            int projNum = reader.nextInt();
            //reading contributors
            for (int i = 0; i < contNum; i++) {
                String contName = reader.next();
                int skillNum = reader.nextInt();

                ArrayList<Skill> contSkills = new ArrayList<>();
                for (int j = 0; j < skillNum; j++) {
                    String skillName = reader.next();
                    int skillLvl = reader.nextInt();
                    contSkills.add(new Skill(skillName, skillLvl));
                }
                conts.add(new Contributor(contName, new ArrayList<>(contSkills)));
            }
            //reading projects
            for (int i = 0; i < projNum; i++) {
                String projName = reader.next();
                int daysToComp = reader.nextInt();
                int score = reader.nextInt();
                int deadline = reader.nextInt();
                int neededRoles = reader.nextInt();

                ArrayList<Skill> projSkills = new ArrayList<>();
                for (int j = 0; j < neededRoles; j++) {
                    String skillName = reader.next();
                    int skillLvl = reader.nextInt();
                    projSkills.add(new Skill(skillName, skillLvl));
                }
                proj.add(new Project(projName, new ArrayList<>(projSkills), daysToComp, score, deadline));
            }
        } catch (Exception ignored) {
            System.out.println("Error reading file: " + path);
        }
        return new DataContainer(conts, proj);
    }

}
