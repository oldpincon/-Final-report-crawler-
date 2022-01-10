import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get(); //虛擬貨比的網站
            Document doc1 = Jsoup.connect("https://hk.investing.com/crypto/").get();

            System.out.println("漲跌劇烈提示器");

            System.out.println("-------------------------------------------");
            System.out.println("今日警示 :");


            System.out.println("-------------------------------------------");
            System.out.println("前10個幣值資料:");
            int j = 0;
            for (int i = 1; i <= 10; i++) {
                String table2 = doc.getElementsByClass("left bold elp name cryptoName first js-currency-name").get(j).text();
                String table3 = doc.getElementsByClass("left noWrap elp symb js-currency-symbol").get(j).text();
                String table4 = doc.getElementsByClass("price js-currency-price").get(j).text();
                String table5 = doc.getElementsByClass("js-market-cap").get(j).text();
                String table6 = doc.getElementsByClass("js-24h-volume").get(j).text();
                String table7 = doc.getElementsByClass("js-total-vol").get(j).text();
                String table9 = doc.getElementsByClass("js-currency-change-7d redFont").get(j).text();
                Elements updo = doc1.select("#fullColumn > div:nth-child(9) > table > tbody > tr:nth-child(" + i + ")");
                Element table10 = updo.get(0);

                if(doc.select("#fullColumn > div:nth-child(14) > table > tbody > tr:nth-child("+i+") > td.js-currency-change-24h.greenFont.pid-"+ table10.attr("i") +"-pcp").size() != 0){
                    String table8 = doc.getElementsByClass("js-currency-change-24h greenFont pid-" + table10.attr("i") +"-pcp").get(0).text();
                    System.out.println(i  + "." + "名稱: " + table2 + " 代號: " + table3 + " 價格 (USD): " + table4 + " 市值: " + table5 + "\n   成交量(24小時): " + table6 + "   市場份額: " + table7 + " 升跌率 (24小時): " +table8 + " 升跌率(7日): " + table9 + "\n");
                }
                else {
                    String table8 = doc.getElementsByClass("js-currency-change-24h redFont pid-" + table10.attr("i") +"-pcp").get(0).text();
                    System.out.println(i + "." + "名稱: " + table2 + " 代號: " + table3 + " 價格 (USD): " + table4 + " 市值: " + table5 + "\n  成交量(24小時): " + table6 + "     市場份額: " + table7 + " 升跌率 (24小時): " +table8 + " 升跌率(7日): " + table9 + "\n");
                }
                j++;
            }
        }
        catch (Exception e){
            System.out.println("error" + e);
        }
    }
}
