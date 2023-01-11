/* Problem:

Given 2 arrays. Tell whether they both form same BST.


Ex: a1=[10, 15, 8, 12, 94, 81, 5, 2, 11] , a2=[10, 8, 5, 15, 2, 12, 11, 94, 81]

answer is yes, they both form same BST.

How, start from the first node and construct BSTs.. at last both will be same.

The question is to tell that without constructing the trees.

**/

import java.util.*;

class Program {
  /*
        we go to the right to find out min and max for each element in array and compare they are same. recursively.
        only thing is, just finding the min or max is not enough.. because that min/max could have already been taken when traversing parents
        example:
        arr1:  10, 15, 8, 12, 94, 81, 5, 2, 11
        arr2 : 10, 8, 5, 15, 2, 12, 11, 94, 81
        when we are exploring 10, we will mark 8 as min and 15 as max
        again when we are exploring 8, we might again mark 15 as the max in second array... which is incorrect.. it is already taken up by 10
        that's why we also need to pass a max/min range when finding out min/max
     */

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return same(arrayOne, arrayTwo, 0,0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

     static boolean same(List<Integer> arrayOne, List<Integer> arrayTwo, int idxOne, int idxTwo, int minVal, int maxVal){
        if(idxOne==-1 || idxTwo==-1) return idxOne==idxTwo;      // if either if one is -1 both must be -1 or else return false
        if(arrayOne.get(idxOne) != arrayTwo.get(idxTwo)) return false;

        int currentValue = arrayOne.get(idxOne);
        int rightSmall1 = rightSmall(arrayOne, idxOne, minVal);
        int rightSmall2 = rightSmall(arrayTwo, idxTwo, minVal);
        int rightLarge1 = rightLarge(arrayOne, idxOne, maxVal);
        int rightLarge2 = rightLarge(arrayTwo, idxTwo, maxVal);

        return same(arrayOne, arrayTwo, rightSmall1,rightSmall2, minVal, currentValue) && same(arrayOne, arrayTwo, rightLarge1,rightLarge2, currentValue, maxVal);

     }

     static int rightSmall(List<Integer> array, int current, int min){
        for(int i=current+1;i<array.size();i++){
            if(array.get(current)>array.get(i) && array.get(i)>min) return i;
        }
        return -1;
     }

    static int rightLarge(List<Integer> array, int current, int max){
        for(int i=current+1;i<array.size();i++){
            if(array.get(current)<=array.get(i) && array.get(i)<max) return i;
        }
        return -1;
    }
}
