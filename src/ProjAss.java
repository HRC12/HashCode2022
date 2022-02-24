import java.util.ArrayList;

public class ProjAss {
    ArrayList<Project> projects;
    MentoringLevel mL;

    public ProjAss(ArrayList<Project> projectsRead, MentoringLevel mL) {
        this.mL = mL;
        this.projects = projectsRead;
    }

    //Sort all projects based on deadline
    public void sortProjects(){
        Qs.quickSort(projects, 0, projects.size());
    }

   
    public void projectSelection(ArrayList<Project> projectsList){
        for (Project project : projects) {
            //SEND TO SERGI
            ArrayList<Contributor> projectContributors = mL.getContributor(projects.indexOf(project));
            if (projectContributors != null) {
                for (Contributor contributor: projectContributors) {
                   contributor.busy = true;
                }
                project.selected = true;
                project.projectContributors = projectContributors;
            }
        }
    }

    //Calculate score
    public int calcScore(Project project) {
        int scoreCalc;
        if(project.deadline >= 0) {
            scoreCalc = project.score;
        } else {
            scoreCalc = project.score + project.deadline;
        }
        if (scoreCalc < 0){
            scoreCalc = 0;
        }
        return scoreCalc;
    }



    //Next day
    public void nextDay() {
        for (Project project : projects) {
            project.deadline--;
            if(project.selected) {
                project.daysToComplete--;
                if (project.daysToComplete == 0) {
                    project.selected = false;
                    project.finished = true;
                    for (Contributor contributor: project.projectContributors) {
                        contributor.busy = false;
                        for (Skill skill: contributor.getSkillsList()) {
                            for (int i = 0; i < project.getNeededSkillsList().size(); i++) {
                                if(skill.getName().equals(project.getNeededSkillsList().get(i).getName())) {
                                    if(skill.getLevel() <= project.getNeededSkillsList().get(i).getLevel()) {
                                        skill.incf();
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
