import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://hk.investing.com/crypto/currencies").get(); //虛擬貨比的網站
        System.out.println("漲跌劇烈提示器");
        /////// 打咚咚
       // Element table2 = doc.select("change24H").last(); //所有貨幣的資料 //全部排成一行 不能換行
       // System.out.print(table2.text());


        System.out.println("-------------------------------------------");
        System.out.println("今日警示 :"+"\n");// \n是換行
        /////// 打咚咚
        System.out.println("-------------------------------------------");

        Element title = doc.select("#fullColumn h1 ").first(); //此部分的標題 顯示所有加密貨幣 標題
        System.out.println(title.text());

         //Element table = doc.select("table").last(); //所有貨幣的資料
         //System.out.print(table.text());


        System.out.println("-----------------------------------------------------------------------------");
        Element table = doc.select("thead").last(); //所有貨幣的資料表
        System.out.print(table.text());
        System.out.println("\n"+"-----------------------------------------------------------------------------");// \n是換行


     // Element table1 = doc.select("tr class>1").last(); //所有貨幣的資料 //嘗試
     // System.out.print(table1.text());

      // Element title = doc.select("tr class>1").first(); //此部分的標題 //嘗試
      // System.out.println(title.text());

        Element table1 = doc.select("tbody").last(); //所有貨幣的資料 //全部排成一行 不能換行
        System.out.print(table1.text());

    }

    }

