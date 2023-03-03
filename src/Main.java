
import java.util.*;
class Solution {
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String result = "";
        boolean flag = false;
        for(int i=0;i<completion.length;i++){
            System.out.println(participant[i]);
            System.out.println(completion[i]);
            if(participant[i]!=completion[i]){
                flag = true;
                result = participant[i];
            }
        }
        System.out.println(flag);
        if(flag == false){
            result = participant[participant.length-1];
            System.out.println("**"+participant.length);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
}
