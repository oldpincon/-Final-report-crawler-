
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
            System.out.println("今日警示 :");//寫不出來==

        //   for (int i = 1; i <= 10; i++) {
        //       Elements updo = doc1.select("#fullColumn > div:nth-child(9) > table > tbody > tr:nth-child(" + i + ")"); //貨幣分別有不同i值,所以要另外抓24hr升跌率
        //       Element table10 = updo.get(0); // 抓<tr i >整串原始碼
        //       if(doc.select("#fullColumn > div:nth-child(14) > table > tbody > tr:nth-child("+i+") > td.js-currency-change-24h.greenFont.pid-"+ table10.attr("i") +"-pcp").size() != 0){
        //           String tfc = doc.getElementsByClass("js-currency-change-24h greenFont pid-" + table10.attr("i") +"-pcp" ).get(i).text();
        //           tfc = tfc.replaceAll("[^\\d]","");
        //           double tfcU = Double.parseDouble(tfc);
        //           if (tfcU > 10)
        //           System.out.println(tfcU);
        //       }
        //       else {
        //           String tfc = doc.getElementsByClass("js-currency-change-24h redFont pid-" + table10.attr("i") +"-pcp").get(i).text();
        //           tfc = tfc.replaceAll("[^\\d]","");
        //           double tfcD = Double.parseDouble(tfc);
        //           if (tfcD < -10)
        //           System.out.println(tfcD);
        //       }
        //   }


            System.out.println("-------------------------------------------");
            System.out.println("前10個幣值資料:");//不想取太多個，太後面那些也沒用，如果想看更多請付費解鎖，沒啦!想看我還是能改^^
            for(int a=0; a<10 ; a++){
                String table100 = doc.getElementsByTag("tr").get(0).getElementsByTag("th").get(a).text();
                if(a<10){
                    System.out.printf("%-10s",table100);
                }
                else{
                    System.out.printf("%-10s",table100,"%-10s");
                }
            }

            System.out.println("\n");
            for(int b=1; b<=10 ; b++) {
                System.out.println("\n");
                for (int c = 0; c < 10; c++) {
                    String table1000 = doc.getElementsByTag("tr").get(b).getElementsByTag("td").get(c).text();
                    System.out.printf("%-11s",table1000,"%-11s");
                }
            }
            System.out.println("\n");
        }
        catch (Exception e){
            System.out.println("error" + e);
        }
    }
}
