package com.liuhu.datastruct.sort;

import java.util.Arrays;

public class Sort {

    /**
     * @Description 冒泡排序 相邻两个数比较然后交换
     * @author liuhu
     * @param arr
     * @date 2021/3/11 15:04
     * @return void
     */
    public static void bubbleSort(int[] arr){
        // 一共需要得次数
        for (int i = 0; i < arr.length-1; i++) {
            // 交换得次数
            for (int j = 0; j <arr.length-1-i ; j++) {
                // 临时变量
                int temp;
                // 大的和小的交换位置
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        print(arr);
    }

    /**
     * @Description 选择排序  每次选出数组中最小得数放在第一个  依次排列
     * @author liuhu
     * @param
     * @date 2021/3/11 15:09
     * @return void
     */
    public  static  void chooseSort(int[] arr){
        //  需要进行得次数
        for (int i = 0; i < arr.length-1; i++) {
            // 假定每次第一个数为最小数
            int minVal=arr[i];
            // 最小数下标
            int minIndex = i;
            // i+1 表示 选出来当前最小数时剔除  从后面开始再继续找最小数
            for (int j = i+1; j <arr.length ; j++) {
                 if(arr[j]<minVal){
                     minVal = arr[j];
                     minIndex = j;
                 }
            }
            // 如果i==minIndex 表示当前假定得这个最小数  刚好就是最小的  这次应该不交换
          if(i != minIndex){
              // 交换位置  实际最小数  与假定得最小数交换位置
              arr[minIndex] = arr[i];
              arr[i]=minVal;
          }
        }
        print(arr);
    }

   /**
    * @Description 快速排序  选取一个基准点  用左右两个指针，找出比基准点大的数组放右边  小的放左边  递归处理
    * @author liuhu
    * @param arr
    * @param leftIndex
    * @param rightIndex
    * @date 2021/3/11 15:33
    * @return void
    */
    public static void quickSort(int[] arr,int leftIndex,int rightIndex){
        if (leftIndex > rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        //  选取第一个值为基准点
        int baseVal = arr[leftIndex];
        // 如果left = right 代表此时数组已经遍历完毕  中间得那个数就是基准值
        while (left<right){
            // 找出右边比基准值小的数 跳出循环
            while (left<right&& arr[right]>=baseVal){
                right--;
            }
            // 交换位置  将小的数交换到左边
            arr[left]=arr[right];
            // 找出左边比基准值大的数 跳出循环
            while (left<right && arr[left]<=baseVal){
                left++;
            }
            // 交换位置  将大的数交换到右边
            arr[right]=arr[left];
        }
        // 基准值归位
        arr[left]=baseVal;
        // 递归调用 左边递归
        quickSort(arr,leftIndex,left-1);
        // 递归调用 右边递归
        quickSort(arr,right+1,rightIndex);
        print(arr);
    }


    /**
     * @Description 二分法  只针对于有序数组 选取一个基准 比基准值大就在右边找  比基准值小的在左边找
     * @author liuhu
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @date 2021/3/11 16:02
     * @return void
     */
    public static  int twoSort(int[] arr,int leftIndex,int rightIndex,int key){
        if(rightIndex<leftIndex){
            return -1;
        }
        int baseIndex = (leftIndex+rightIndex)/2;
        int baseVal = arr[baseIndex];
        if(baseVal>key){
            return twoSort(arr,leftIndex,baseIndex+1,key);
        }else if(baseVal<key){
            return twoSort(arr,baseIndex+1,rightIndex,key);
        }else{
            return baseVal;
        }
    }

    public  static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,56,43,66,67,23};
//        Sort.bubbleSort(arr);
//        Sort.chooseSort(arr);
//        Sort.quickSort(arr,0,arr.length-1);
//        int[] sortedArr = new int[]{2,5,34,43,66,67};
//        System.out.println(Sort.twoSort(sortedArr,0,sortedArr.length-1,66));
    }
}
