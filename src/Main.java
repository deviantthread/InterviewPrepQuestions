import java.net.HttpURLConnection;

import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1").append("2");
        String s1 = sb.toString();
        sb.append("3");
        String s2 = sb.toString();
        System.out.println(s1 + " : " + s2);
    }

}
