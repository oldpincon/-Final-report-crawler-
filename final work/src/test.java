import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class test {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get(); //虛擬貨幣的網站
            System.out.println("漲跌劇烈提示器");//主題
            System.out.println("-------------------------------------------");
            System.out.println("今日警示 :");
            System.out.println("-------------------------------------------");

            System.out.println("前10個幣值資料:");
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
                    System.out.printf("%-10s",table1000,"%-10s");
                }
            }
            System.out.println("\n");
        }
        catch (Exception e){
            System.out.println("error: " + e);
        }
    }
}