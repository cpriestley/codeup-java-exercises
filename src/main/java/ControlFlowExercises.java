public class ControlFlowExercises {
    public static void main(String[] args) {


        System.out.format("Print 5 to 15:%n");
        for (int i = 5; i <= 15; i++) {
            System.out.println(i);
        }

        System.out.format("%nPrint Squares From 2 While value is less than 1,000,000:%n");
        for (long j = 2; j < 1000000; j*=j) {
            System.out.println(j);
        }

    }
}
