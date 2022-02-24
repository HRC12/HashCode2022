import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataContainer data = DataIngest.ReadFile("data/a_an_example.in.txt");
        ArrayList<Contributor> contributors = data.contributors;
        ArrayList<Project> projects = data.projects;
        DictHash dh = new DictHash(contributors);
        dh.genDict();
        MentoringLevel ml = new MentoringLevel(contributors, projects);
        ArrayList<Contributor> out = ml.getContributor(1);
        ProjAss projAss = new ProjAss(projects, ml);
        projAss.sortProjects();
        projAss.projectSelection(projects);
        while(!projAss.checkEnd(projects)) {
            projAss.nextDay();
        }


    }
}
