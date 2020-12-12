package wq.dp.stategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] arr = {new Cat(3,5),new Cat(5,1),new Cat(1,3)};

        Sorter<Cat> sorter= new Sorter();
        Cat[] arr1 = arr.clone();
        Cat[] arr2 = arr.clone();
        sorter.sort(arr1,new CatWeightComparator());
        System.out.println(Arrays.toString(arr1));


        sorter.sort(arr2,new CatHeightComparator());
        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.toString(arr));

    }

}
