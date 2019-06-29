import java.util.*;

class solution 
{
    public static void main(String[] args) 
    {
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Character> arr = new ArrayList<Character>();
        for (int i = 0; i < str1.length(); i++)
        {   
            int m = i;
            list1.add(m);
            char s = str1.charAt(i);
            arr.add(s);
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) 
        {
            int b = sc.nextInt();
            String a = sc.next();
        	ArrayList<Character> al = new ArrayList<Character>();
        	ArrayList<Integer> list2 = new ArrayList<Integer>();
            for(int m =0; m < a.length(); m++)
            {
	          char d = a.charAt(m);
	          al.add(d);
            }
            for (int p = 0; p < al.size(); p++)
            {
                for(int q = 0; q < arr.size(); q++)
                {
                    if (al.get(p) == arr.get(q))
                    {
                        list2.add(list1.get(q));
                    }
                }
            }
            Collections.reverse(list2);
            double fin = 0;
            int y; double num; int rem; double tot;
            for (int s = 0; s<list2.size(); s++)
            {
                if (s ==0)
                {
                    y = list2.get(s) * 2;
                    num = Math.floor((y / 64));
                    rem = y % 64;
                    tot = num + rem;
                    fin = fin + tot;
                }
                else if (s%2 == 0)
                {
                    y = list2.get(s) * 2;
                    num = Math.floor((y / 64));
                    rem = y % 64;
                    tot = num + rem;
                    fin = fin + tot;
                }
                else
                {
                    fin = fin + list2.get(s);
                }
            }
            double rem3 = fin % 64;
            int rem2 = (int)rem3;
            if (fin == 0)
            {
                System.out.println('A');
            }
            else
            {
                System.out.println(arr.get(64-rem2));
            }
        }
    }
}
