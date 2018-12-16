//Author Satyam Ramawat at satyamramawat@gmail.com
package readWeb;

import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.giaybac.traprange.PDFTableExtractor;
import com.giaybac.traprange.entity.Table;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;

public class readWeb {

	public void readhtmldata(String html) {
		try {
			Document doc = Jsoup.connect(html).get();
			Elements tableElements = doc.select("table");

			Elements tableHeaderEles = tableElements.select("thead tr th");
			System.out.println("headers");
			for (int i = 0; i < tableHeaderEles.size(); i++) {                 
				System.out.println(tableHeaderEles.get(i).text());  // This loop will read Row-by-Row
			}
			System.out.println();

			Elements tableRowElements = tableElements.select(":not(thead) tr");

			for (int i = 0; i < tableRowElements.size(); i++) {
				Element row = tableRowElements.get(i);
				System.out.println("row"+(i+1));
				Elements rowItems = row.select("td");
				for (int j = 0; j < rowItems.size(); j++) {        // This loop will read elements of a selected row One-by-One
					System.out.println(rowItems.get(j).text());    //rowItems.get(j).text() we can store this in a nth position of Array & ArrayList 
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		String html = "https://accessibility.umn.edu/web-designers/tables-web-pages";
		readWeb parser = new readWeb();
		parser.readhtmldata(html);
	}
}