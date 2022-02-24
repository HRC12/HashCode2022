import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataPrint {

    public static void Print(String path, ArrayList<Project> projects) {
        try {
            File myObj = new File("filename.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("filename.txt");
            writer.write(projects.size());
            for (Project p : projects) {
                writer.write(p.getName());
                StringBuilder sb = new StringBuilder();
                for (Contributor c : p.projectContributors) {
                    sb.append(c.getName()).append(" ");
                }
                writer.write(sb.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
