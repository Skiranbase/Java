import java.util.*;
//Greatest common divisor
class solution 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) 
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int m;
            if(a>b)
            {
                m = a;
            }
            else
            {
                m = b;
            }
            int ma = 0;
            for(int i = m; i > 1; i--)
            {
                if ((a%i == 0) & (b%i == 0))
                {
                    ma += 1;
                    System.out.println("GCD of '"+a+"' and '"+b+"' is : "+i);
                    break;
                }
            }
            if (ma == 0)
            {
            System.out.println("There is no GCD of "+a+" and "+b+".");
            }
        }
        sc.close();
    }
}