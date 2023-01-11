/* Problem:

Return length of the logest peak in the array. Peak needs at least 3 elements to form. After peak it should be decreasing
1,2,3 doesn't form a peak... 1,3,2 forms a peak

Ex: coins=[1,2,3,3,4,0,10,6,5,-1,-3,2,3]

answer is 6 -> 0,10,6,5,-1,-3

**/

import java.util.*;

// Bruteforce wud be to check left/right at each position and expand both sides to find max. That wud be O(n^2)
// Trick is, you can directly jump to end of the peak.. because we won't find another 

class Program {
  public static int longestPeak(int[] a) {
    int longest=0,i=1;
		while(i<a.length-1){
			if(a[i-1]<a[i] && a[i]>a[i+1]){
				int j=i-2;
				while(j>=0&&a[j]<a[j+1]) j--;
				int k=i+2;
				while(k<a.length&&a[k]<a[k-1]) k++;
				int peakLength = k-j-1;
				longest = Math.max(longest,peakLength);
				i=k; continue; // directly jump to the end. because none of the elements in the current peak would become another peak. This is the actual trick for O(n) complexity
			}
			i++;
		}
		return longest;
  }
}