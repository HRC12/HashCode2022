import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MentoringLevel {
    ArrayList<Contributor> contributors;
    ArrayList<Project> projects;

    public MentoringLevel (ArrayList<Contributor> contributors, ArrayList<Project> projects) {
        this.contributors = contributors;
        this.projects = projects;
    }

    public ArrayList<Contributor> getContributor (int projectIndex) {

        if (projects.get(projectIndex).getNeededRoles() != 1) {
            ArrayList<Boolean> found = new ArrayList<>();

            ArrayList<Contributor> returned = new ArrayList<>();
            for (int k = 0; k < projects.get(projectIndex).getNeededSkillsList().size(); k++) {
                found.add(false);
                returned.add(new Contributor("", new ArrayList<>()));
            }

            for (int k = 0; k < projects.get(projectIndex).getNeededSkillsList().size() && !found.get(k); k++) {
                int possibleFind = 0;
                int arrayPos = 0;
                String name = "";
                ArrayList<Contributor> language2 = DictHash.map.get(projects.get(projectIndex).getNeededSkillsList().get(k).getName());
                for (int i = 0; i < language2.size(); i++) {
                    for (int j = 0; j < language2.get(i).getSkillsList().size() && !found.get(k); j++) {
                        if (language2.get(i).getSkillsList().get(j).getName().equals(
                                projects.get(projectIndex).getNeededSkillsList().get(k).getName())) {
                            if (projects.get(projectIndex).getNeededSkillsList().get(k).getLevel() - 1 ==
                                    language2.get(i).getSkillsList().get(j).getLevel() && language2.get(i).busy == false) {
                                name = language2.get(i).getSkillsList().get(j).getName();
                                possibleFind = i;
                                arrayPos = k;
                                found.set(k,true);
                            }
                        }
                    }
                    int aux = 0;
                    if (found.get(k)) {
                        for (int p = 0; p < language2.size(); p++) {
                            for (int j = 0; j < language2.get(p).getSkillsList().size(); j++) {
                                for (int l = 0; l < projects.get(projectIndex).getNeededSkillsList().size(); l++) {
                                    if (language2.get(p).getSkillsList().get(j).getName().equals(
                                            projects.get(projectIndex).getNeededSkillsList().get(l).getName())
                                    && !name.equals(language2.get(p).getSkillsList().get(j).getName())) {
                                        if (projects.get(projectIndex).getNeededSkillsList().get(l).getLevel() >=
                                                language2.get(p).getSkillsList().get(j).getLevel() && language2.get(p).busy == false) {
                                            returned.set(arrayPos, language2.get(possibleFind));
                                            returned.set(l, language2.get(p));
                                            found.set(l,true);
                                            aux = l;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!found.get(aux)) {
                        found.set(k,false);
                        for (int j = 0; j < language2.get(i).getSkillsList().size() && !found.get(k); j++) {
                            if (language2.get(i).getSkillsList().get(j).getName().equals(
                                    projects.get(projectIndex).getNeededSkillsList().get(k).getName())) {
                                if (projects.get(projectIndex).getNeededSkillsList().get(k).getLevel() <=
                                        language2.get(i).getSkillsList().get(j).getLevel() && language2.get(i).busy == false) {
                                    returned.set(k, language2.get(i));
                                    found.set(k, true);
                                }
                            }
                        }
                    }
                    if (!found.get(k)) {
                        return null;
                    }
                }


            }
            return returned;
        }
        else {
            ArrayList<Contributor> language1 = DictHash.map.get(projects.get(projectIndex).getNeededSkillsList().get(0).getName());
            for (int i = 0; i < language1.size(); i++) {
                for (int j = 0; j < language1.get(i).getSkillsList().size(); j++) {
                    if (language1.get(i).getSkillsList().get(j).getName().equals(
                            projects.get(projectIndex).getNeededSkillsList().get(0).getName())) {
                        if (projects.get(projectIndex).getNeededSkillsList().get(0).getLevel() <=
                                language1.get(i).getSkillsList().get(j).getLevel() && language1.get(i).busy == false) {
                            ArrayList<Contributor> returned = new ArrayList<>();
                            returned.add(language1.get(i));
                            return returned;
                        }
                    }
                }
            }
            return null;
        }


    }

}
