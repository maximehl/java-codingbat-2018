import java.util.Arrays;

public class Runner{

    public static void main(String[] args){
        System.out.println(hasTeen(13, 20, 10));
        System.out.println(!hasTeen(1, 20, 12));
        System.out.println(hasTeen(12, 18, 20));

        System.out.println(stringSplosion("Code").equals("CCoCodCode"));
        System.out.println(stringSplosion("Kitten").equals("KKiKitKittKitteKitten"));
        System.out.println(stringSplosion("fade").equals("ffafadfade"));

        System.out.println(lastChars("last", "chars").equals("ls"));
        System.out.println(lastChars("", "hello").equals("@o"));
        System.out.println(lastChars("", "").equals("@@"));

        System.out.println(Arrays.equals(swapEnds(new int[] {1, 2, 3, 4}), new int[] {4, 2, 3, 1}));
        System.out.println(Arrays.equals(swapEnds(new int[] {8, 6, 7, 9, 5}), new int[] {5, 6, 7, 9, 8}));
        System.out.println(Arrays.equals(swapEnds(new int[] {1}), new int[] {1}));

        System.out.println(withoutDoubles(2, 3, true)==5);
        System.out.println(withoutDoubles(3, 3, true)==7);
        System.out.println(withoutDoubles(3, 3, false)==6);

        System.out.println(makeBricks(3, 1, 8));
        System.out.println(!makeBricks(3, 1, 9));
        System.out.println(!makeBricks(1, 4, 12));

        System.out.println(prefixAgain("abXYabc", 1));
        System.out.println(prefixAgain("Hi12345Hi6789Hi10", 3));
        System.out.println(!prefixAgain("Hi12345Hi6789Hi10", 4));

        System.out.println(gHappy("xxggxx"));
        System.out.println(!gHappy("xxgxx"));
        System.out.println(gHappy("xxgggxygg"));

        System.out.println(modThree(new int[] {2, 1, 3, 5}));
        System.out.println(!modThree(new int[] {9, 7, 2, 9, 2, 2}));
        System.out.println(modThree(new int[] {9, 7, 2, 9, 2, 2, 6}));

        System.out.println(maxMirror(new int[] {1, 2, 3, 8, 9, 3, 2, 1})==3);
        System.out.println(maxMirror(new int[] {21, 22, 9, 8, 7, 6, 23, 24, 6, 7, 8, 9, 25, 7, 8, 9})==4);
        System.out.println(maxMirror(new int[] {1})==1);
    }

    public static boolean hasTeen(int a, int b, int c) {
        return(a>12&&a<20)||(b>12&&b<20)||(c>12&&c<20);
    }

    public static String stringSplosion(String str) {
        String returnString = "";
        if(str.length()>0){
            for(int n = 0; n<str.length()+1; n++){
                for(int a = 0; a<n; a++){
                    returnString += str.substring(a, a+1);
                }
            }
        }
        return returnString;
    }

    public static String lastChars(String a, String b) {
        String word = "";
        if(a.length()>0){
            word+=a.substring(0, 1);
        }else{
            word+="@";
        }
        if(b.length()>0){
            word+=b.substring(b.length()-1);
        }else{
            word+="@";
        }
        return word;
    }

    public static int[] swapEnds(int[] nums) {
        int saved = nums[nums.length-1];
        nums[nums.length-1] = nums[0];
        nums[0] = saved;
        return nums;
    }

    public static int withoutDoubles(int die1, int die2, boolean noDoubles) {
        if(noDoubles&&die1==die2){
            die1 = (die1%6)+1;
        }
        return die1+die2;
    }

    public static boolean makeBricks(int small, int big, int goal) {
        if(Math.floor(goal/5)<=big){
            return goal%5<=small;
        }
        return (goal-(big*5))<=small;
    }

    public static boolean prefixAgain(String str, int n) {
        return str.substring(n).contains(str.substring(0, n));
    }

    public static boolean gHappy(String str) {
        String nextL;
        String prevL;
        for(int n=0; n<str.length(); n++){
            if(str.substring(n, n+1).equals("g")){
                if(n>0){
                    prevL = str.substring(n-1, n);
                }else{
                    prevL = "";
                }
                if(n+2<=str.length()){
                    nextL = str.substring(n+1, n+2);
                }else{
                    nextL = "";
                }
                if(!(prevL.equals("g")||nextL.equals("g"))){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean modThree(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        for(int n : nums){
            if(n%2==0){
                evenCount++;
                oddCount = 0;
            }else{
                oddCount++;
                evenCount = 0;
            }
            if(evenCount==3||oddCount==3){
                return true;
            }
        }
        return false;
    }

    public static int maxMirror(int[] nums) {
        int maxMirrorL = 0;
        int curMirrorL = 0;
        int c;
        for(int n = 0; n<nums.length; n++){
            for(int e = nums.length-1; e>=n; e--){
                if(nums[e]==nums[n]){
                    c = n;
                    while(nums[e]==nums[c]){
                        curMirrorL++;
                        e--;
                        c++;
                        if(e<0||c==nums.length){
                            break;
                        }
                    }
                    maxMirrorL = Math.max(curMirrorL, maxMirrorL);
                    curMirrorL = 0;
                }
            }
        }
        return maxMirrorL;
    }

}