package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型;

/**
 * 二分查找 算法
 */
class BinarySearch {

    int rank(int key, int[] a){
        int firstIndex=0;
        int lastIndex=a.length-1;

        while(firstIndex<=lastIndex){
            int index=firstIndex+(lastIndex-firstIndex)/2;
            if(key<a[index]){
                lastIndex=index-1;
            }else if(key>a[index]){
                firstIndex=index+1;
            }else{
                return index;
            }
        }
        return 0;
    }

}
