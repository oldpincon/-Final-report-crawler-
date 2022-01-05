import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.lang.model.util.ElementScanner6;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get(); //我們爬的網站
        System.out.println("漲跌劇烈提示器");
        System.out.println("-------------------------------------------");
        System.out.println("今日警示");

        System.out.println("-------------------------------------------");
        Element title = doc.select("#fullColumn h1 ").first(); //此部分的標題
        System.out.println(title.text());
        Element table = doc.select("table").last();//所有貨幣的資料
        System.out.println(table.text());
      //  Element tbody = table.select("tbody").first();
      //  Elements tr = tbody.select("tr").first();
      //  for (Element items : tr){
      //      System.out.println(items.text());
        }
    }

