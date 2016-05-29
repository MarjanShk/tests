package vk;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Admin on 28.05.2016.
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(new File("C:\\Users\\Admin\\Desktop\\hrefsVk.csv")));
        ArrayList<String> hrefs = new ArrayList<>();
        String href = r.readLine();
        while (href != null) {
            hrefs.add(href);
            href = r.readLine();
        }
        r.close();

        ArrayList<String> res = new ArrayList<>();

        for (String s : hrefs) {
            System.out.println(s);
        }
        BufferedReader r2 = new BufferedReader(new FileReader(new File("C:\\Users\\Admin\\Desktop\\alreadyAdded.csv")));
        ArrayList<String> hrefs2 = new ArrayList<>();
        String href2 = r2.readLine();
        while (href2 != null) {
            hrefs2.add(href2);
            href2 = r2.readLine();
        }
        r2.close();

        System.out.println("=================================");
        for (String s : hrefs2) {
            System.out.println(s);
        }

        for (String s : hrefs) {
            if (!hrefs2.contains(s)) {
                res.add(s);
            }
        }
        FileWriter writer = new FileWriter(new File("C:\\Users\\Admin\\Desktop\\res.csv"));
        for (String h : res) {
            writer.write(h + "\n");
        }
        writer.close();
    }
}
