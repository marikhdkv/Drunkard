import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String input = new Scanner(System.in).nextLine();
        Queue<Integer> first = new PriorityQueue<>();
        for (String elem : input.split(" "))
            first.add(Integer.parseInt(elem));

        input = new Scanner(System.in).nextLine();
        Queue<Integer> second = new PriorityQueue<>();
        for (String elem : input.split(" "))
            second.add(Integer.parseInt(elem));

        int moves = 0;
        while (true)
        {
            if (first.isEmpty())
            {
                System.out.println("second " + moves);
                break;
            }
            else if (second.isEmpty())
            {
                System.out.println("first " + moves);
                break;
            }
            else if (moves >= 106)
            {
                System.out.println("botva");
                break;
            }
            else
            {
                int topFirst = first.poll(),
                        topSecond = second.poll();
                if (topFirst < topSecond)
                {
                    first.offer(topFirst);
                    first.offer(topSecond);
                }
                else
                {
                    second.offer(topFirst);
                    second.offer(topSecond);
                }
                ++moves;
            }
        }
    }
}