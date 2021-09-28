package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import java.util.Arrays;

public class insertionSortTimeTest {
    public static void main(String[] args) {
        InsertionSort ins = new InsertionSort();
        Comparable[] ranArr = new Comparable[160000];
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = ((int) (Math.random() * 160000));
        }
        Comparable[] sortArr = new Comparable[160000];
        for (int i = 0; i < ranArr.length; i++) {
            sortArr[i] = ((int) (Math.random() * 160000));
        }
        Arrays.sort(sortArr);
        Comparable[] partArr = new Comparable[160000];
        for (int i = 0; i < sortArr.length / 2; i++) {
            partArr[i] = sortArr[i];
        }
        for (int i = ranArr.length / 2; i < sortArr.length; i++) {
            partArr[i] = ranArr[i];
        }
        Comparable[] reverseArr = new Comparable[160000];
        for (int i = sortArr.length - 1; i >= 0; i--) {
            reverseArr[sortArr.length - i - 1] = sortArr[i];
        }
        Timer timer1 = new Timer();
        Timer timer2 = new Timer();
        Timer timer3 = new Timer();
        Timer timer4 = new Timer();
        final int zzz = 20;
        final double ranTime = timer1.repeat(20, () -> zzz, t -> {
            ins.sort(ranArr, 0, ranArr.length - 1);
            return null;
        });
        final double sortTime = timer1.repeat(20, () -> zzz, t -> {
            ins.sort(sortArr, 0, sortArr.length - 1);
            return null;
        });
        final double partTime = timer1.repeat(20, () -> zzz, t -> {
            ins.sort(partArr, 0, partArr.length - 1);
            return null;
        });
        final double reverseTime = timer1.repeat(20, () -> zzz, t -> {
            ins.sort(reverseArr, 0, reverseArr.length - 1);
            return null;
        });
        System.out.println("The insertion sort time of random number group with length 160000 is "+ranTime);
        System.out.println("The insertion sort time of an ordered array of length 160000 is "+sortTime);
        System.out.println("The insertion sort time of an partially-ordered  array of length 160000 is "+partTime);
        System.out.println("The insertion sort time of an reverse-ordered  array of length 160000 is "+reverseTime);

    }
}
