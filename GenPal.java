public class GenPal {

    private boolean verbose = false;

    public GenPal() {
        this(false);
    }
    public GenPal(boolean verbose) {
        this.verbose = verbose;
    }

    public static void main(String args[]) {
        int starter = Integer.parseInt(args[0]);
        GenPal gp = (args.length > 1 && args[1] !=null && "-verbose".equals(args[1]))? new GenPal(true): new GenPal(false);
        gp.run(starter);
    }

    void run(int n) {

        int starter = n;
        int current = starter;
        int stages = 0;
        while(!isPalindrome(current)) {
            int prev = current;
            stages++;
            current = nextStage(current);
            if(verbose) System.out.printf("Step: [%s] (%s+%s)\t--> %s\n", stages, prev, reverse(prev), current);
        }
        if(verbose) {
            System.out.printf("GenPal: %s %s --> %s",stages, starter, current);
        } else {
            System.out.printf("%s,%s,%s ",starter, current, stages);
        }
        System.out.println();
    }

    int nextStage(int n) {
        int s2 = reverse(n);
        return n+s2;
    }

    int reverse(int n) {
        int reverse = 0;
        int sum = 0;

        while( n != 0 ) {
            sum = sum + (n%10);
            reverse = reverse * 10;
            reverse = reverse + n%10;
            n = n/10;
        }
        //  System.out.printf("n:%s, sum:%s\n", n,sum);
        return reverse;
    }

    /*
    boolean isPalindrome(int n) {
        int reverse = reverse(n);
        if(n % 10 != 0)
            return false;
        else
            return true;
    }
    */

    static boolean isPalindrome(int integer) {
        int palindrome = integer;
        int reverse = 0;

        // Compute the reverse
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // The integer is palindrome if integer and reverse are equal
        return integer == reverse; // Improved by Peter Lawrey

    }


}
