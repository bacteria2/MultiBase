import com.multi.webadmin.MultiDemoWebInitializer;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * @author multi.xia
 * @date 2017年02月13日
 * @description input useage
 */
public class TestOutput {

    public void testOutput() {

            //Document doc = DocumentHelper.parseText(Files.asCharSource(Paths.get("src/test/resources/mockData/single.xml").toFile(), Charset.forName("UTF-8")).read());
            //Element element = doc.getRootElement().element("content");
            org.jsoup.nodes.Document document = Jsoup.parseBodyFragment("");
            Elements elements = document.getElementsMatchingOwnText("^附件\\d+");
            Iterator iterator=elements.iterator();
            System.out.println(elements.size());
            StringBuilder sb=new StringBuilder();
            while (iterator.hasNext()){
                org.jsoup.nodes.Element element1=(org.jsoup.nodes.Element)iterator.next();
                if (element1.nodeName().equals("a"))
                    sb.append(element1.attr("href")).append(";;");
            }
            System.out.println(sb.toString());


/*
            elements.forEach(element1 -> {
                if (element1.nodeName().equals("a"))
                    System.out.println(element1.attr("href"));
            });
*/


        ;
    }


    public void test() throws URISyntaxException {
        Path path=Paths.get(MultiDemoWebInitializer.class.getResource("../shiro").toURI());
        System.out.println(path);

    }
}
