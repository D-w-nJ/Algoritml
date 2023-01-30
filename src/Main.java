import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

class Coor{
    private int num;
    private int id;
    private int rst;

    public int getRst() {
        return rst;
    }

    public int getId() {
        return id;
    }

    public void setRst(int rst) {
        this.rst = rst;
    }

    public int getNum() {
        return num;
    }

    public Coor(int num, int id, int rst) {
        this.num = num;
        this.id = id;
        this.rst = rst;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Coor> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Coor(Integer.parseInt(st.nextToken()),i,0));
        }

        Comparator<Coor> comp1 = new Comparator<Coor>(){
            @Override
            public int compare(Coor o1, Coor o2) {
                return o1.getNum()-o2.getNum();
            }
        };
        Collections.sort(list,comp1);

        int tmp = 0;
        for (int i = 1; i < N; i++) {
            if(list.get(i-1).getNum()==list.get(i).getNum())
                list.get(i).setRst(tmp);
            else{
                list.get(i).setRst(++tmp);
            }
        }
        Comparator<Coor> comp2 = new Comparator<Coor>(){
            @Override
            public int compare(Coor o1,Coor o2){
                return o1.getId()-o2.getId();
            }
        };
        Collections.sort(list,comp2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i).getRst()+" ");
        }
        System.out.println(sb);
    }
}
