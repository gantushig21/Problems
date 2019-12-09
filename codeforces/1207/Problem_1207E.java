import java.util.*;

public class Problem_1207E {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("?");
        for (int i = 1; i <= 100; i++)
            System.out.print(" " + i);
        System.out.println();

        System.out.flush();

        int x = (input.nextInt() >> 7) << 7;

        System.out.print("?");
        for (int i = 1; i <= 100; i++) {
            int number = 0;
            for (int j = 0; j < 7; j++) {
                if ((i & (1 << j)) != 0)
                    number += (1 << (j + 7));
            }
            System.out.print(" " + number);
        }
        System.out.println();

        System.out.flush();

        x = x ^ (input.nextInt() & ((1 << 7) - 1));

        System.out.println("! " + x);
        input.close();
    }

}