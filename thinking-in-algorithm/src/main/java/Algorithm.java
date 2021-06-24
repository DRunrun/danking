import java.util.Arrays;

/**
 * 基础算法
 *
 * @author djq
 * @date 2021/6/23 15:33
 */
public class Algorithm {
    public static void main(String[] args) {
        //二分法
        dischotomy();
        //冒泡排序算法
        bubbleSort();
        //插入排序
        insertionSort();
    }

    /**
     * 插入排序算法：选取未排序的元素，插入到已排序区间的合适位置，直到未排序区间为空
     *
     * @author djq
     * @date 2021/6/23 16:13
     */
    private static void insertionSort() {
        int[] arr = {1,4,2,6,5,7,9,3,8,-1};
        System.out.println("原始数据："+ Arrays.toString(arr));
        for (int i = 1; i < arr.length;i++){
            int temp = arr[i];
            int j = i - 1;
            for (;j>=0;j--){
                if (arr[j] > temp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
        System.out.println("插入排序: " + Arrays.toString(arr));
    }

    /**
     * 冒泡排序算法:重第一个数据开始，依次比较相邻元素的大小，如果前者大于后者，则进行交换，
     * 把大的元素往后交换，通过多轮迭代，直到没有交换操作为止
     *
     * 最好的时间复杂度是O(n)  最坏的时复杂度是O(n*n)
     * 不需要开辟额外的空间  空间复杂度是O(1)
     *
     * @author djq
     * @date 2021/6/23 15:53
     */
    private static void bubbleSort() {
        int[] arr = {1,4,2,6,5,7,9,3,8,-1};
        System.out.println("原始数据："+ Arrays.toString(arr));
        for (int i = 1; i < arr.length;i++){
            for (int j = 0; j < arr.length -1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
        System.out.println("冒泡排序：" + Arrays.toString(arr));
    }

    /**
     * 分治法案例  查找在有序数组中是否出现过某个值
     * 时间复制度是O(logn)
     */
    private static void dischotomy() {
        //需要查找的数字
        int targetNumb = 18;
        //目标有序数组
        int[] arr ={1,2,3,4,5,6,7,8,9};
        //中位值
        int middle = 0;
        //两个索引
        int low = 0;
        int high = arr.length - 1;
        int isfind = 0;
        while (low <= high){
            middle = (high + low) / 2;
            if (arr[middle] == targetNumb){
                System.out.println(targetNumb + "在数组中，下标值为："+middle);
                isfind = 1;
                break;
            }else if (arr[middle] > targetNumb) {
                //说明该数在low~middle之间
                high = middle - 1;
            }else {
                //说明该值在middle~high之间
                low = middle + 1;
            }
        }
        if (isfind == 0){
            System.out.println("数组不含：" + targetNumb);
        }
    }
}
