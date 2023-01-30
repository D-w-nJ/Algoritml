package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Dot {
    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int y;

}

public class Bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Dot> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Dot(x,y));
        }

        Comparator<Dot> comp = (o1, o2) -> {
            if(o1.getY()==o2.getY())
                return o1.getX()-o2.getX();
            else
                return o1.getY()-o2.getY();
        };

        Collections.sort(list,comp);

        StringBuilder sb = new StringBuilder();
        for(Dot i : list){
            sb.append(i.getX()+" "+i.getY()+"\n");
        }
        System.out.println(sb);
    }
}
