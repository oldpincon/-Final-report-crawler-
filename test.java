import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class test {
    public static void main(String[] args) {
        Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get(); //虛擬貨比的網站
        System.out.println("漲跌劇烈提示器");
        /////// 打咚咚
        // Element table2 = doc.select("change24H").last(); //所有貨幣的資料 //全部排成一行 不能換行
        // System.out.print(table2.text());


        System.out.println("-------------------------------------------");
        System.out.println("今日警示 :" + "\n"); // \n是換行
        /////// 打咚咚
        System.out.println("-------------------------------------------");

        Element title = doc.select("#fullColumn h1 ").first(); //此部分的標題 顯示所有加密貨幣 標題
        System.out.println(title.text());

        //Element table = doc.select("table").last(); //所有貨幣的資料
        //System.out.print(table.text());


        System.out.println("-----------------------------------------------------------------------------");
        Element table = doc.select("thead").last(); //所有貨幣的資料表
        System.out.print(table.text());
        System.out.println("\n" + "-----------------------------------------------------------------------------");// \n是換行

        //Element table2 = doc.select("tbody").last(); //所有貨幣的資料 //全部排成一行 不能換行
        //System.out.print(table2.text());
        Elements items = doc.getElementsByClass("tr class");
        for (Element item : items) {
            String a  = item.getElementsByClass("td").get(0).getElementsByTag("rank icon").get(0).text();
            String b  = item.getElementsByClass("td").get(0).getElementsByTag("left noWrap elp symb js-currency-symbol").get(0).text();
            System.out.println(a);
            System.out.println(b);
            //36-40 我找不到錯 也不知道這樣打是不是正確的 要瘋掉了 有時候還會跳第9行錯 
        }

    }
    }

