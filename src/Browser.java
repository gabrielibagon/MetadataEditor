import java.io.IOException;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Browser {
	
	
	public Browser(){
	}
	
	
	
	public void scraper(String album, String artist) throws IOException{
//		System.out.println(album + artist);
//		//String html = "https://rateyourmusic.com/search?searchtype=l&searchterm=" + artist + "+" + album;
//		String html = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=Miles+Davis+Kind+Of+Blue+site%3Arateyourmusic.com";
//		System.out.println(html);
//		Document doc = Jsoup.connect(html).userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
//		Elements links = doc.select("li[class=g]");
//		for (Element link : links) {
//            Elements titles = link.select("h3[class=r]");
//            String title = titles.text();
//
//            Elements bodies = link.select("span[class=st]");
//            String body = bodies.text();
//
//            System.out.println("Title: "+title);
//            System.out.println("Body: "+body+"\n");
//        }
//		Elements firstLink = doc.select("")
		Document doc;
			String reqToken = "";
			try {
				Response res = 	Jsoup.connect("http://rateyourmusic.com/httprequest").userAgent("Mozilla").ignoreHttpErrors(true).timeout(0)
					.header("Host", "rateyourmusic.com")
					.header("Origin", "http://rateyourmusic.com")
					.header("Referer", "http://rateyourmusic.com/search?searchtype=l&searchterm=miles+davis+kind+of+blue")
					.header("X-Requested-With", "XMLHttpRequest")
					.data("searchterm", "miles davis kind of blue")
					.data("type", "1")
					.data("page", "1")
					.data("action", "Search")
					.data("rym_ajax_req", "1")
					.data("request_token", reqToken)
					.method(Method.POST)
					.execute();
				doc = res.parse();
				Elements links = doc.select("*");
				System.out.print(res.statusCode());
				System.out.print(links);
			}
			catch (IOException e){
				e.printStackTrace();
			}
		
//		 Document doc;
//		    try{
//		        doc =        Jsoup.connect("https://www.google.com/search?as_q=&as_epq=%22Yorkshire+Capital%22+&as_oq=fraud+OR+allegations+OR+scam&as_eq=&as_nlo=&as_nhi=&lr=lang_en&cr=countryCA&as_qdr=all&as_sitesearch=&as_occt=any&safe=images&tbs=&as_filetype=&as_rights=").userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
//		        Elements links = doc.select("li[class=g]");
//		        for (Element link : links) {
//		            Elements titles = link.select("h3[class=r]");
//		            String title = titles.text();
//
//		            Elements bodies = link.select("span[class=st]");
//		            String body = bodies.text();
//
//		            System.out.println("Title: "+title);
//		            System.out.println("Body: "+body+"\n");
//		        }
//		    }
//		    catch (IOException e) {
//		        e.printStackTrace();
//		    }
	}
	
	public void getGenre(String artist, String album){
		
	}
}
