import java.util.ArrayList;

public class DataContainer {
    ArrayList<Contributor> contributors;
    ArrayList<Project> projects;

    public DataContainer(ArrayList<Contributor> conts, ArrayList<Project> proj) {
        contributors = conts;
        projects = proj;
    }
}
