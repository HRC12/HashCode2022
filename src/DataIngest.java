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
                conts.add(new Contributor(contName, contSkills));
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
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error reading file: " + path);
        }
        return new DataContainer(conts, proj);
    }

    public static void testReader (String path) {
        DataContainer testData = ReadFile(path);

        ArrayList<Contributor> conts = new ArrayList<>();
        ArrayList<Project> projs = new ArrayList<>();
        ArrayList<Skill> skills = new ArrayList<>();

        skills.add(new Skill("C++", 2));
        conts.add(new Contributor("Anna", skills));
        skills.removeAll(skills);

        skills.add(new Skill("HTML", 5));
        skills.add(new Skill("CSS", 5));
        conts.add(new Contributor("Bob", skills));
        skills.removeAll(skills);

        skills.add(new Skill("Python", 3));
        conts.add(new Contributor("Maria", skills));
        skills.removeAll(skills);

        skills.add(new Skill("C++", 3));
        projs.add(new Project("Logging", skills, 5, 10, 5));
        skills.removeAll(skills);

        skills.add(new Skill("HTML", 3));
        skills.add(new Skill("C++", 2));
        projs.add(new Project("WebServer", skills, 7, 10, 7));
        skills.removeAll(skills);

        skills.add(new Skill("Python", 3));
        skills.add(new Skill("HTML", 3));
        projs.add(new Project("WebChat", skills, 10, 20, 20));
        skills.removeAll(skills);

        DataContainer controlData = new DataContainer(conts, projs);

        if (controlData.equals(testData)) System.out.println("GOOD");
    }
}


