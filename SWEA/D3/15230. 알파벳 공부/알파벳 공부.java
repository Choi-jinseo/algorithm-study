import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int count;
            for (count = 0; count < str.length(); count++) {
                if (str.charAt(count) != 'a' + count) break;
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}