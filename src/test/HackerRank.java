package test;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HackerRank {

    public static class Solution {
	public static int gcd(int A, int B) {
	    if (A == 0)
	        return B;
	    return gcd(B % A, A);
	}
}

   static int[] solve(int[] a, int[] b) {
        int A = 0;
        int B = 0;
        for(int i=0; i < 3; i++) {
            if (a[i]==b[i]){
                continue;
            }
            if (a[i] > b[i]) {
                A=A+1;
            } else {
                B=B+1;
            }
        }
        return new int[]{A,B};
    }
    static void staircase(int n) {
        for(int i=n;i>0;i--) {
            StringBuffer buf1 = new StringBuffer();
            for(int j=(i-1);j>0;j--) {
                buf1.append(" ");   
            }
            StringBuffer buf2 = new StringBuffer();
            for(int j=n;j>=i;j--) {
                buf1.append("#");   
            }
            System.out.println(buf1.toString() + buf2.toString());
        }
    }
    
    static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar);
        int tallest = -1;
        int sum = 0;
        for(int i=ar.length-1;i>=0;i--) {
            if (ar[i] > ar.length) {
                continue;
            }
            if (tallest==-1) {
                tallest = ar[i];
                sum+=1;
            } else {
                if (ar[i] == tallest) {
                    sum+=1;
                } else {
                    break;
                }
            }
        }
        return sum != 0 ? sum : 1;
    }
    
   static String timeConversion(String s) {
        String hour=s.substring(0,2);
        String mins=s.substring(3,5);
        String sec=s.substring(6,8);
        String status=s.substring(8,10);
        int h = Integer.valueOf(hour);
        
        if ("AM".equalsIgnoreCase(status) && h==12) {
            h = 0;
        } else if ("PM".equalsIgnoreCase(status) && h==12) {
            h = 12;
        } else if ("PM".equalsIgnoreCase(status) && h!=12) {
            h += 12;
        }
        String outHour = (h==0) ? "00" : (new Integer(h)).toString();    
        return outHour + ":" + mins + ":" + sec;  
    }
     
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        Map<Integer, Integer> map=getScores(scores);
        for (int j = 0; j < alice.length; j++) {
            res[j] = getRank(scores, map, alice[j]);
        }
        return res;
    }

    private static Map<Integer, Integer> getScores(int[] scores) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int i=0;i<scores.length;i++) {
            if (map.containsKey(scores[i])) {
                map.put(scores[i], index);
            } else {
                map.put(scores[i], ++index);
            }
        }
        return map;
    }
    
    private static int getRank(int[] sc, Map<Integer, Integer> scores, int number) {
        int index = -1;
        for(int i=0;i<sc.length;i++) {
            int num=sc[i];
            if (num == number) {
                index=scores.get(num);
                break;
            } else if(number > num) {
                index=scores.get(num);
                if (index==0) {
                    index=1;
                }
                break;
            }
        }
        if (index == -1) {
            return scores.get(sc[sc.length-1]) + 1;
        }
        return index;
    }
   
    static int hurdleRace(int k, int[] height) {
        int max=k;
        for(int i=0;i<height.length;i++) {
            if (height[i]>max) {
                max=height[i];
            }
        }
        if (max>k) {
            return max-k;
        }
        return 0;
    }
     
    static char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static int designerPdfViewer(int[] h, String word) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<ch.length;i++) {
            map.put(ch[i], h[i]);
        }
        int max = 0;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            int num = map.get(c);
            if (num>max) {
                max=num;
            }
        }
        return word.length()*1*max;
    }
    
    static int viralAdvertising(int n) {
        int index=0;
        int sum = 0;
        int people = 5;
        while(true) {
            if(index>=n){
                break;
            }
            int p = new Double(Math.floor(people/2)).intValue();
            sum+=p;
            people=3*p;
            index++;
        }
        return sum;
    }
    
    static int saveThePrisoner(int n, int m, int s) {
        int pos = s;
        for(int i=1;i<=m;i++) {
            if (pos==n) {
                pos=1;
            } else {
                pos++;
            }
        }
        return pos-1;
    }
    
    
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int [] res = new int[queries.length];
        int kk = k;
        if(k>a.length) {
            if(k%a.length == 0) {
                k = 0;
            }
            k = k%a.length;
        }
        for(int i=0;i<queries.length;i++) {
            int pos = queries[i];
            if (pos-k<0) {
                pos = a.length+(pos-k);
            } else {
                pos=pos-k;
            }
            res[i] = a[pos];
        }
        return res;
    }
    
    static int[] permutationEquation(int[] p) {
        int[] res = new int[p.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<p.length;i++) {
            map.put(p[i], i+1);
        }
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list);
        int index = 0;
        for(Integer i : list){
            int num = map.get(i);
            res[index++] = map.get(num);
        }
        return res;
    }
    
    static int jumpingOnClouds(int[] c, int k) {
        int pos = 0;
        int power = 0;
        while(true) {
            pos = (pos + k)%c.length;
            if (c[pos] == 0) {
                power++;
            } else {
                power = power + 3;
            }
            if (pos == 0) {
                break;
            }
        }
        return 100-power;
    }
    
    static int findDigits(int n) {
        int result = 0;
        String s = Integer.toString(n);
        for(int i = 0; i<s.length();i++) {
            int c = s.charAt(i)-'0';
            if(c!= 0 && n%c==0) {
                result++;
            }
        }
        return result;
    }
    
    static void extraLongFactorials(int n) {
        System.out.print(factorial(n));
    }
    
    static BigInteger factorial(long n) {
        if(n==1) {
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }
    
    
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        for(int i=t.length();i>0;i--) {
            String substring = t.substring(0,i);
            if (s.contains(substring)) {
                boolean result = (s.length()-i) + (t.length()-i) - k ==0;
                if (result) return "Yes";
            } 
        }
        return s.length()+t.length()-k <= 0?"Yes":"No";
    }
    
    //  All perfect squares end in 1, 4, 5, 6, 9 or 00 (i.e. Even number of zeros). 
    // Therefore, a number that ends in 2, 3, 7 or 8 is not a perfect square. 
    
    // a perfect square will always have a digital root of 0, 1, 4 or 7. 
    static int squares(int a, int b) {
        return new Double((Math.floor(Math.sqrt(Integer.valueOf(b).doubleValue())) -
                Math.ceil(Math.sqrt(Integer.valueOf(a).doubleValue()))) + 1).intValue();         
    }
    
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date firstDate = sdf.parse(Integer.toString(m2) + "/" + Integer.toString(d2)+ "/" + Integer.toString(y2));
            Date secondDate = sdf.parse(Integer.toString(m1) + "/" + Integer.toString(d1)+ "/" + Integer.toString(y1));
            
            Calendar startCalendar = new GregorianCalendar();
            startCalendar.setTime(firstDate);
            Calendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(secondDate);
            
            long diffInMillies = secondDate.getTime() - firstDate.getTime();
            if (diffInMillies <= 0) {
                return 0;
            }
            
            if (y1-y2 > 0) {
                return 10000;
            }
            if (m1-m2 > 0) {
                return Math.abs(endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH)) * 500;
            }
            return Long.valueOf(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)).intValue() * 15;

        } catch (ParseException ex) {
           
        }
        return 0;
    }
     
    
    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int sum = 0;
        int all = arr.length;
        res.add(all);
        for(int i = 0; i < arr.length; i++) {
           if (prev != -1 && arr[i] != prev) {
               all = all - sum;
               res.add(all);
               sum = 0;
           }
           sum++;
           prev = arr[i];
        }
        int[] result = new int[res.size()];
        int i = 0;
        for(Integer iii : res) {
            result[i++] = iii;
        }
        return result;
    }
        
    static int nonDivisibleSubset1(int k, int[] S) {
        if(k==1) {
            return 0;
        }
        if(S.length == 1) {
            return S[0]%k != 0 ? 1 : 0;
        }
        if(S.length == 2) {
            return (S[0] + S[1])%k != 0 ? 1 : 0;
        }
        int sum = 0;
        for (int i = 0; i < S.length; i++) {
            int[] res = new int[S.length];
            int a = 0;
            res[a++] = S[i];
            for (int j = i+1; j < S.length; j++) {
                int val = S[i] + S[j];
                if (val % k != 0) {
                    res[a++] = S[j];
                }
            }
            res = removeElement(res, a);
            if (fit(k, res) && res.length > sum) {
                sum = res.length;
            }
        }
        return sum;
    }
    
    public static int[] removeElement(int[] original, int element) {
        int[] n = new int[element];
        System.arraycopy(original, 0, n, 0, element);
        return n;
    }
    
    private static boolean fit(int k, int[] S) {
        for (int i = 0; i < S.length; i++) {
            for (int j = i + 1; j < S.length; j++) {
                int val = S[i] + S[j];
                if (val % k == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int app = 0;
        int ora = 0;
        for(int i = 0; i < apples.length; i++) {
            int pos = apples[i] + a;
            if (pos >= s && pos <= t) {
                app++;
            }
        }
        for(int i = 0; i < oranges.length; i++) {
            int pos = oranges[i] + b;
            if (pos >= s && pos <= t) {
                ora++;
            }
        }
        System.out.println(app);
        System.out.println(ora);
    }

    static int camelcase(String s) {
        char[] c = s.toCharArray();
        int sum = 1;
        for(int i=0; i<c.length; i++) {
            if ((c[i] - '0') <= 42) {
                sum++;
            }
        }
        return sum;
    }
    
    static void insertionSort1(int n, int[] arr) {
        int pos = arr.length-1;
        int elem = arr[pos];
        boolean done = false;
        for(int i = arr.length - 2; i >= 0; i--) {
            if (elem < arr[i]) {
                arr[pos] = arr[i];
            } else {
                arr[pos] = elem;
                done = true;
            }
            printElements(arr);
            pos--;
            if (done) {
                break;
            }
        }
        if (pos==0) {
            arr[0] = elem;
            printElements(arr);
        }
    }
    
    private static void printElements(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    
    static String solve(int year) {
        if (year == 1918) {
            return "26.09.1918";
        } else if (((year <= 1917) && (year%4 == 0)) || 
                ((year%400 == 0) || ((year%4 ==0) && (year%100 != 0)))) {
            return "12.09." + year;
        } else {
            return "13.09." + year;
                   }
    }    
}

