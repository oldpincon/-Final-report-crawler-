import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get();
        System.out.println("漲跌劇烈提示器");
        System.out.println("-------------------------------------------");
        System.out.println("今日警示");

        System.out.println("-------------------------------------------");
        Element item = doc.select("#fullColumn h1 ").first();
        System.out.println(item.text());
        Element table = doc.select("table").last();
        System.out.print(table.text());

    }
}
