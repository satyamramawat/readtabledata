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
				System.out.println(tableHeaderEles.get(i).text());
			}
			System.out.println();

			Elements tableRowElements = tableElements.select(":not(thead) tr");

			for (int i = 0; i < tableRowElements.size(); i++) {
				Element row = tableRowElements.get(i);
				System.out.println("row");
				Elements rowItems = row.select("td");
				for (int j = 0; j < rowItems.size(); j++) {
					System.out.println(rowItems.get(j).text());
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*public void readpdfdata() throws IOException {
		PDFTableExtractor extractor = new PDFTableExtractor();
		List<Table> tables = extractor.setSource("users/satyamramawat/desktop/sample-1.pdf")
			.addPage(0)
			.addPage(1)
			.exceptLine(0) //the first line in each page
			.exceptLine(1) //the second line in each page
			.exceptLine(-1)//the last line in each page
			.extract();
		String html = tables.get(0).toHtml();//table in html format
		String csv = tables.get(0).toString();//table in csv format using semicolon as a delimiter 
	}*/

	public static void main(String[] args) throws IOException {
		String html = "https://accessibility.umn.edu/web-designers/tables-web-pages";
		readWeb parser = new readWeb();
		parser.readhtmldata(html);
		//parser.readpdfdata();
	}
}