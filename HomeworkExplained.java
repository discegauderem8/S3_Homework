//Объяснение того же алгоритма (см. Python): https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D1%81%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5%D0%BC#:~:text=%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0%20%D1%81%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5%D0%BC%20(%D0%B0%D0%BD%D0%B3%D0%BB.,%D0%BF%D1%80%D0%B8%D0%BD%D1%86%D0%B8%D0%BF%D0%B0%20%C2%AB%D1%80%D0%B0%D0%B7%D0%B4%D0%B5%D0%BB%D1%8F%D0%B9%20%D0%B8%20%D0%B2%D0%BB%D0%B0%D1%81%D1%82%D0%B2%D1%83%D0%B9%C2%BB

import java.util.Arrays;
import java.util.logging.Logger;

public class HomeworkExplained {

    public static void main(String[] args) {
        int[] a1 = new int[]{21, 25, 42, 40, 75, 900, 78, 77, 900, 2100, 2200, 2000, 66, 2500};
        for (int item : a1) {
            System.out.print(item + " ");
        }

        SortUnsorted(a1, 0, a1.length - 1);

        System.out.println();

        for (int item : a1) {
            System.out.print(item + " ");
        }
    }

    private static void SortUnsorted(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        SortUnsorted(a, lo, mid);
        SortUnsorted(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);


        int i = lo, j = mid + 1;


        for (int k = lo; k <= hi; k++)
            if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else if (i > mid) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }

    }
}