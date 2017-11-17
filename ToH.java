import java.util.*;
import java.util.stream.*;

public class ToH {
    Stack left = new Stack();
    Stack middle= new Stack();
    Stack right = new Stack();
    int moves = 0;
    int discs = 0;

    public static void main(String args[]) {
        ToH toh = new ToH();
        toh.run(Integer.parseInt(args[0]));

    }

   void run(int n) {
       discs = n;
       moves=0;

       System.out.println("Towers of Hanoi");
       System.out.printf("Using %d discs\n", discs);

       for(int i=n; i>0;i--) left.push(i);
       display(left, middle, right);
       move(n,left,right,middle);
       System.out.printf("Total moves: %s\n", moves);

   }

    void move(int n, Stack source, Stack target, Stack auxillary) {
        if (n > 0) {
            move(n - 1, source, auxillary, target);
            target.push(source.pop());
            // Display
            display(left, middle, right);
            moves++;
            move(n-1, auxillary, target, source);
        }
    }

    void display(Stack left, Stack middle, Stack right) {
            System.out.printf("A:%s\t\t\tB:%s\t\t\tC:%s\n", renderStack(left), renderStack(middle), renderStack(right));
    }

    String renderStack(Stack stack) {
        Boolean isFirst = true;
        StringBuffer ret = new StringBuffer("[");
        for(Object v: stack.toArray()) {
            ret.append(String.format("%s%d", (isFirst? "":","), v));
            isFirst = false;
        }
        ret.append("]");
        return ret.toString();
    }

}
