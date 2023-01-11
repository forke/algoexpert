/* Problem:

Given an array of +ve integers represeting coin values. return the minimum amount of change that you cannot make.

Ex: coins=[1,2,5], the min amount of change that u can't create is 4

**/

import java.util.*;

// The trick is, you keep adding the elements into sum.. and if you encounter a value which is bigger than sum+1.. that means you can't make it
// see vid for exmapantion. but it makes sense

class Program {

  public int nonConstructibleChange(int[] coins) {
		Arrays.sort(coins); // we need to sort first
		int sum=0; // named sum, but this will also hold the minimum value we can't make (if the input has such holes)
		for(int i=0;i<coins.length;i++){
			if(coins[i]>sum+1) return sum+1;
			sum+=coins[i];
		}
		
    return sum+1; // all the coins are already used. so the next minimum sum not possible to give is sum+1
  }
}
