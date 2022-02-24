import java.util.ArrayList;
import java.util.HashMap;

public class DictHash {
    ArrayList<Contributor> conts;
    static HashMap<String, ArrayList<Contributor>> map = new HashMap<String, ArrayList<Contributor>>();

    public DictHash(ArrayList<Contributor> conts) {
        this.conts = conts;
    }

    public void genDict(){
        for (Contributor curr: conts) {
            for (Skill cSkill: curr.getSkillsList()) {
                if(map.containsKey(cSkill.getName())) {
                    boolean flag = false;
                    for (int i = 0; i < map.get(cSkill.getName()).size() && !flag; i++) {
                        if (cSkill.getLevel() < map.get(cSkill.getName()).get(i).skillsMap.get(cSkill.getName())){
                            map.get(cSkill.getName()).add(i, curr);
                            flag = true;
                        }

                    }
                    if(!flag){
                        map.get(cSkill.getName()).add(curr);
                    }
                }
                else{
                    map.put(cSkill.getName(), new ArrayList<>());
                    map.get(cSkill.getName()).add(curr);
                }
            }
        }
    }
}
