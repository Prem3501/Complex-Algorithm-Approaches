import java.util.*;

class activitySelection {
    static class Match {
        String name;
        int stime;
        int ftime;

        Match(String name, int stime, int ftime) {
            this.name = name;
            this.stime = stime;
            this.ftime = ftime;
        }
    }

    public static void sa(Match[] m, int n) {
        System.out.println("Selected activities are:");
        System.out.print(m[0].name + " ");
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (m[i].stime >= m[k].ftime) {
                System.out.print(m[i].name + " ");
                k = i;
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Match[] m = new Match[1000];
        
        n = 3;
        m[0] = new Match("A", 1, 3);
        m[1] = new Match("B", 2, 5);
        m[2] = new Match("C", 3, 7);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (m[i].ftime > m[j].ftime) {
                    Match temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                }
            }
        }

        sa(m, n);
    }
}