import java.util.*;
//Least common multiple
class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int n = 0; n < t; n++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int check = 1;
            int count = 1;
            while (check > 0)
            {
                if ((count%a == 0) & (count%b == 0))
                {
                    System.out.println("LCM of '"+a+"' and '"+b+"' is : "+count);
                    check -= 1;
                    list.add(count);
                }
                count += 1;
            }
        }
        System.out.println(list);
        sc.close();
    }
}
