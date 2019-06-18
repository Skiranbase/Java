import java.util.*;
import java.text.SimpleDateFormat;
class solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int mx = 1;
        for(int n = 0; n < t; n++)
        {
            //System.out.println(mx);
            ArrayList<Date> start = new ArrayList<>();
            ArrayList<Date> end = new ArrayList<>();
            int num = sc.nextInt();
            if(num==1)
            {
                String time1 = sc.next();
                String time2 = sc.next();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        		Date date1 = format.parse(time1);
        		Date date2 = format.parse(time2);
                start.add(date1);
                end.add(date2);
            }
            else
            {
                String ones = sc.next();
                String onee= sc.next();
                SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        		Date date1 = format1.parse(ones);
        		Date date2 = format1.parse(onee);
                start.add(date1);
                end.add(date2);
                for (int i = 1; i<num; i++)
                {
                    String time1 = sc.next();
                    String time2 = sc.next();
                    SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
            		Date check1= format2.parse(time1);
            		Date check2 = format2.parse(time2);
            		int x = 0;
                    for (int j = 0; j<start.size(); j++)
                    {
                        if (check1.before(start.get(j)) & check2.after(start.get(j)) & check2.before(end.get(j)))
                        {
                            start.set(j, check1);
                            //System.out.println(start.get(j)+" "+check1+" "+check2);
                        }
                        else if(check1.after(start.get(j)) & check1.before(end.get(j)) & check2.after(end.get(j)))
                        {
                            end.set(j, check2);
                        }
                        else if((check1.before(start.get(j)) & check2.before(start.get(j))) | (check1.after(end.get(j)) & check2.after(end.get(j))))
                        {
                            x = x + 1;
                        }
                        else if(check1.before(start.get(j)) & check2.after(end.get(j)))
                        {
                            start.set(j,check1);
                            end.set(j, check2);
                        }
                        else if((check1 == start.get(j)) & check2.after(end.get(j)))
                        {
                            start.set(j,check1);
                            end.set(j, check2);
                        }
                        else if(check1.before(start.get(j)) & (check2 == end.get(j)))
                        {
                            start.set(j,check1);
                            end.set(j, check2);
                        }
                        else if((check1 == start.get(j)) & (check2 == end.get(j)))
                        {
                            start.set(j,check1);
                            end.set(j, check2);
                        }

                    }
                    if (x == start.size())
                        {
                            start.add(check1);
                            end.add(check2);
                        }
                }
            }
            long fin = 0L;
            int out = -1;
            int ec = 0;
            int sk = 0;
            for (int a = 0; a<start.size(); a++)
            {
                long diff;
                //System.out.println(start.get(a)+" "+end.get(a));
                if (end.get(a).getTime() == 0)
                {
                    diff = 86400000 - start.get(a).getTime();
                    fin = fin + diff;
                    out +=1;
                }
                else
                {
                    diff = end.get(a).getTime() - start.get(a).getTime();
                    fin = fin + diff;
                    out +=1;
                }
                if (end.get(a).getTime() == 0)
                {
                    ec = ec+1;
                }
                if (start.get(a).getTime() == 0)
                {
                    sk = sk+1;
                }
            }
            if (ec > 0)
            {
                ec *= 0;
            }
            else
            {
                ec = 1;
            }
            if (sk > 0)
            {
                sk *= 0;
            }
            else
            {
                sk = 1;
            }
            long finals = 86400000-fin;
            int sums = out + ec + sk;
            long diffSeconds = finals / 1000 % 60;
            long diffMinutes = finals / (60 * 1000) % 60;
            long diffHours = finals / (60 * 60 * 1000) % 24;
            String h = String.format("%02d", diffHours);
            String m = String.format("%02d", diffMinutes);
            String s = String.format("%02d", diffSeconds);
            System.out.println(sums+" "+h+":"+m+":"+s);
            mx = mx+1;
        }
    }
}

//Note:
// 1. system is taking 00:00:00 when time is 24:00:00
// 2. run and compare the output in middle

//Output:
/*1 00:00:00
2 23:30:00
1 00:00:01
2 00:00:02
3 16:00:00
2 12:00:00
2 01:30:00
4 13:00:00
2 -8:00:00
6 00:-8:-43
3 11:27:42
4 07:00:07
3 09:33:08
3 11:57:00
5 03:51:30
3 08:07:48 */

//Input
/*16
1
00:00:00 24:00:00
1
20:30:00 21:00:00
1
00:00:00 23:59:59
1
00:00:01 23:59:59
2
12:00:00 13:00:00
14:00:00 21:00:00
3
12:00:00 24:00:00
14:00:00 22:00:00
16:00:00 20:00:00
8
18:30:00 21:30:00
07:00:00 23:00:00
14:30:00 22:00:00
01:30:00 11:30:00
07:30:00 13:00:00
22:30:00 23:30:00
17:30:00 18:00:00
01:00:00 02:30:00
4
01:00:00 02:00:00
03:00:00 04:00:00
04:00:00 12:00:00
15:00:00 24:00:00
5
13:00:00 24:00:00
00:00:00 08:00:00
14:00:00 24:00:00
08:00:00 14:00:00
00:00:00 13:00:00
9
16:16:53 19:04:50
19:21:55 23:13:56
02:37:34 05:13:11
09:32:35 12:30:11
14:10:08 16:43:12
13:28:35 15:40:13
06:14:55 09:28:10
09:25:24 11:51:11
12:26:54 14:52:17
7
19:23:10 21:36:02
09:42:49 12:39:31
15:39:43 19:36:43
15:51:18 18:27:27
11:51:46 15:13:29
08:37:30 11:01:14
11:44:00 13:52:28
8
07:07:40 10:29:20
01:11:16 04:51:53
05:50:27 08:50:02
01:25:57 04:26:41
05:01:50 07:26:25
19:12:46 22:37:41
10:04:56 13:50:36
00:05:41 02:19:17
10
17:17:28 20:45:17
06:57:26 10:55:03
18:06:25 22:01:05
05:45:38 08:23:02
10:52:25 13:51:28
18:40:25 21:34:10
11:13:26 14:11:09
08:27:50 12:02:32
15:59:44 19:12:59
09:56:35 12:21:52
5
10:39:11 13:50:27
16:14:27 19:16:39
09:16:33 11:46:35
06:16:21 10:14:36
17:02:16 20:43:21
10
18:09:28 21:01:03
19:19:21 21:48:23
07:48:04 11:20:06
00:09:40 03:44:28
04:35:25 07:49:25
11:51:18 15:44:53
13:49:53 16:52:52
01:21:37 03:47:44
18:29:55 22:11:38
00:32:07 04:29:45
10
01:32:37 03:57:09
15:49:13 18:56:56
02:16:38 04:46:03
12:57:59 16:57:09
12:04:04 14:38:19
08:51:40 12:49:31
11:24:09 13:28:36
12:42:35 16:17:58
01:02:20 04:01:14
06:48:27 10:30:08


___________________
//Expected Output

0 00:00:00
2 23:30:00
1 00:00:01
2 00:00:02
3 16:00:00
1 12:00:00
2 01:30:00
3 05:00:00
0 00:00:00
4 04:42:27
3 11:27:42
4 07:00:07
3 09:33:08
3 11:57:00
5 03:51:30
3 08:07:48 */
