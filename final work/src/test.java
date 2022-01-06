import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import javax.lang.model.util.ElementScanner6;
import java.io.IOException;


public class test {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get(); //虛擬貨比的網站
        System.out.println("漲跌劇烈提示器");
        /////// 打咚咚
        // Element table2 = doc.select("change24H").last(); //所有貨幣的資料 //全部排成一行 不能換行
        // System.out.print(table2.text());


        System.out.println("-------------------------------------------");
        System.out.println("今日警示 :"); // \n是換行
        /////// 打咚咚
        System.out.println("-------------------------------------------");

        Element title = doc.select("#fullColumn h1 ").first(); //此部分的標題 顯示所有加密貨幣 標題
        System.out.println(title.text()+":\n");

        ////////////////////////// 給他們一點自己的空間
        for (int i=0 ; i<10 ; i++) {
            String table1 = doc.getElementsByClass("left noWrap elp symb js-currency-symbol").get(i).text();
            String table2 = doc.getElementsByClass("left bold elp name cryptoName first js-currency-name").get(i).text();
            String table3 = doc.getElementsByClass("price js-currency-price").get(i).text();
            String table4 = doc.getElementsByClass("js-market-cap").get(i).text();
            String table5 = doc.getElementsByClass("js-24h-volume").get(i).text();
            String table6 = doc.getElementsByClass("js-total-vol").get(i).text();
            //String table7 = doc.getElementsByClass("1057391").get(0).text();
            //String table7 = doc.select("#fullColumn > div:nth-child(9) > table > tbody > tr:nth-child(1) > td.js-currency-change-24h.pid-1057391-pcp.redFont").get(0).text();
            String table8 = doc.getElementsByClass("js-currency-change-7d redFont").get(i).text();


            System.out.println((i+1)+"."+" 名稱: " + table2 + " 代號: " + table1 + " 價格 (USD): " + table3 + " 市值: " + table4 + "\n    成交量(24小時): " + table5 + " 市場份額: " + table6 + " 升跌率 (24小時): "  + " 升跌率(7日): " + table8+ "\n");
            // table 7 一直錯誤 我真的沒辦法 煩死人了!
        }
    }
}

