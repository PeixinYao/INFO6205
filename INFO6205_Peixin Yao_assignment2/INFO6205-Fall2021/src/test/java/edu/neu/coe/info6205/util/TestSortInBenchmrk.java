package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import java.util.ArrayList;


public class TestSortInBenchmrk {


    public static void main(String[] args) {
        TestSortInBenchmrk createArray = new TestSortInBenchmrk();
        InsertionSort ins = new InsertionSort();


        Comparable[] array1 = createArray.orderArray(40000);
        Comparable[] array2 = createArray.reOrderArray(40000);
        Comparable[] array3 = createArray.partOrderArray(40000);
        Comparable[] array4 = createArray.randomArray(40000);


        Timer t1 = new Timer();
        Timer t2 = new Timer();
        Timer t3 = new Timer();
        Timer t4 = new Timer();

        double time1 =  t1.repeat(10,() ->{
           ins.sort(array1,0,array1.length-1);
           return null;
                });
        System.out.println(time1);

        double time2 =  t2.repeat(10,() ->{
            ins.sort(array2,0,array2.length-1);
            return null;
        });
        System.out.println(time2);

        double time3 =  t3.repeat(10,() ->{
            ins.sort(array3,0,array3.length-1);
            return null;
        });
        System.out.println(time3);

        double time4 =  t4.repeat(10,() ->{
            ins.sort(array4,0,array4.length-1);
            return null;
        });
        System.out.println(time4);



    }
    public  Comparable[] orderArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = i;
        }
        return arrayList;
    }

    public  Comparable[]  reOrderArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = n-i-1;
        }
        return arrayList;
    }


    public Comparable[]  partOrderArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n/2; i++) {
            arrayList[i] = i;
        }
        for (int i = n/2; i < n; i++) {
            arrayList[i] = ((int) (Math.random()*1000));
        }

        return arrayList;
    }

    public Comparable[] randomArray(int n){
        Comparable[] arrayList = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = ((int)  (Math.random()*1000)) ;
        }
        return arrayList;
    }

}
