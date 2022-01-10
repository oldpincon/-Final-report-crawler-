import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get(); //虛擬貨幣的網站
            Document doc1 = Jsoup.connect("https://hk.investing.com/crypto/").get();

            System.out.println("漲跌劇烈提示器");//主題

            System.out.println("-------------------------------------------");
            System.out.println("今日警示 :");//寫不出來== 爬下來的是text檔，目前轉不成integer @_@


            System.out.println("-------------------------------------------");
            System.out.println("前10個幣值資料:");//不想取太多個，太後面那些也沒用，如果想看更多請付費解鎖，沒啦!想看我還是能改^^
            int j = 0;
            for (int i = 1; i <= 10; i++) {
                String table2 = doc.getElementsByClass("left bold elp name cryptoName first js-currency-name").get(j).text(); //抓名稱
                String table3 = doc.getElementsByClass("left noWrap elp symb js-currency-symbol").get(j).text(); //抓代號
                String table4 = doc.getElementsByClass("price js-currency-price").get(j).text(); //抓價格
                String table5 = doc.getElementsByClass("js-market-cap").get(j).text(); //抓市值
                String table6 = doc.getElementsByClass("js-24h-volume").get(j).text(); //抓交易量
                String table7 = doc.getElementsByClass("js-total-vol").get(j).text(); //ˊ抓市場交易份額
                String table9 = doc.getElementsByClass("js-currency-change-7d redFont").get(j).text(); //七日內的升跌率
                Elements updo = doc1.select("#fullColumn > div:nth-child(9) > table > tbody > tr:nth-child(" + i + ")"); //貨幣分別有不同i值,所以要另外抓24hr升跌率
                Element table10 = updo.get(0); // 抓<tr i >整串原始碼

                if(doc.select("#fullColumn > div:nth-child(14) > table > tbody > tr:nth-child("+i+") > td.js-currency-change-24h.greenFont.pid-"+ table10.attr("i") +"-pcp").size() != 0){
                    //如果24小時的升率字串數字大小不等於0 則顯示
                    String tfcU = doc.getElementsByClass("js-currency-change-24h greenFont pid-" + table10.attr("i") +"-pcp").get(0).text();
                    System.out.println(i  + "." + "名稱: " + table2 + " 代號: " + table3 + " 價格 (USD): " + table4 + " 市值: " + table5 + "\n   成交量(24小時): " + table6 + "   市場份額: " + table7 + " 升跌率 (24小時): " +tfcU + " 升跌率(7日): " + table9 + "\n");
                    //tfcU = 24hrㄉ升率，tf = twenty-four 、 c = change 、 U = up
                }
                else {
                    //如果24小時的跌率字串數字大小不等於0 則顯示
                    String tfcD = doc.getElementsByClass("js-currency-change-24h redFont pid-" + table10.attr("i") +"-pcp").get(0).text();
                    System.out.println(i + "." + "名稱: " + table2 + " 代號: " + table3 + " 價格 (USD): " + table4 + " 市值: " + table5 + "\n  成交量(24小時): " + table6 + "     市場份額: " + table7 + " 升跌率 (24小時): " +tfcD + " 升跌率(7日): " + table9 + "\n");
                    //tfcD = 24hrㄉ升率，tf = twenty-four 、 c = change 、 D = down
                }
                j++;
            }
        }
        catch (Exception e){
            System.out.println("error" + e);
        }
    }
}
