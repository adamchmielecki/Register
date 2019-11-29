package app;

import java.util.List;

public class Presence {
    int[][] presence;

    public Presence(List<Student> students) {
        presence = new int[students.size()][2];
        for (int i = 0; i < students.size(); i++) {
            presence[i][0] = i;
        }
    }
}
