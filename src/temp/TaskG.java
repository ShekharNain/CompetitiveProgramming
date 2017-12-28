package temp;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskG {
    public static void main(String[] args) {
        String[] usedIP = new String[6];
        String mainIP = "255.255.255.255";
        Set<String> ips = Arrays.stream(usedIP).collect(Collectors.toSet());
        String str = nextString(mainIP);
        while(str != null) {
            if(!ips.contains(str))
                return ;
            str = nextString(str);
        }
    }

    private static String nextString(String ip) {
        String[] arr = ip.split("\\.");
        int id = -1;
        if(!arr[3].equals("255")) {
            return arr[0] + "." + arr[1] + "." + arr[2] + "." + (Integer.valueOf(Integer.valueOf(arr[3]) + 1)).toString();
        } else arr[3] = "0";
        if(!arr[2].equals("255")) {
            return arr[0] + "." + arr[1] +  "." + (Integer.valueOf(Integer.valueOf(arr[2]) + 1)).toString() + "." + arr[3];
        } else arr[2] = "0";
        if(!arr[1].equals("255")) {
            return arr[0]  + "." + (Integer.valueOf(Integer.valueOf(arr[1]) + 1)).toString() + "." + arr[2] + "." + arr[3];
        } else arr[1] = "0";
        if(!arr[0].equals("255")) {
            return (Integer.valueOf(Integer.valueOf(arr[0]) + 1)).toString() + "." + arr[1]  + "." + arr[2] + "." + arr[3];
        }
        return null;
    }

}
