package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UpDownLeftRight {
    public static void main(String[] args) throws IOException {
        // 지도크기 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 계획서 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = 1, y = 1;
        // Switch 문으로 사용.. x, y 좌표 0 이상 N 이하
        while(st.hasMoreTokens()){
            switch (st.nextToken().charAt(0)) {
                case 'L':
                    y--; break;
                case 'R':
                    y++; break;
                case 'U':
                    x--; break;
                case 'D':
                    x++; break;
            }
            if(x==0) x++;
            if(y==0) y++;
        }

        System.out.printf("%d %d",x,y);
    }
}
