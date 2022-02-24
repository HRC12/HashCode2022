import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataIngest.testReader("data/a_an_example.in.txt");
        DataContainer data = DataIngest.ReadFile("data/a_an_example.in.txt");
        ArrayList<Contributor> contributors = data.contributors;
        ArrayList<Project> projects = data.projects;
        DictHash dh = new DictHash(contributors);
        dh.genDict();
    }
}
