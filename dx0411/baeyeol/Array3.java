package dx0411.baeyeol;

public class Array3 {
    public static void main(String[] args) {
        int score[][] = {
                {100, 100, 100}
                ,{20,20,20}
                ,{30,30,30}
                ,{40,40,40}
                ,{50,50,50}
        };

        int korTotal = 0, engTotal = 0, matTotal = 0;
        System.out.println("번호  국어  영어  수학  총점  평균");
        System.out.println("==============================");

        for (int i=0; i < score.length; i++) {
            int sum = 0;
            float avg = 0.0f;

            korTotal += score[i][0];
            engTotal += score[i][1];
            matTotal += score[i][2];
            System.out.printf("%3d", i+1);

            for (int j=0; j< score[j].length; j++) {
                sum += score[i][j];
                System.out.printf("%5d", score[i][j]);
            }
            avg = sum/(float)score[i].length;
            System.out.printf("%5d %5.1f%n", sum, avg);
        }

        System.out.println("==============================");
        System.out.println("총점: " + korTotal + " " + engTotal + " " + matTotal);
    }
}