import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class PrintInXML implements Printer{
    @Override
    public void print(String name, double m, double f, double h, Grade g) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);

            Element student = doc.createElement("학생성적정보");
            doc.appendChild(student);

            Element stdname = doc.createElement("이름");
            student.appendChild(stdname);
            stdname.appendChild(doc.createTextNode(name));

            Element gradeInfo = doc.createElement("성적정보");
            student.appendChild(gradeInfo);

            Element middleScore = doc.createElement("중간점수");
            gradeInfo.appendChild(middleScore);
            middleScore.appendChild(doc.createTextNode(String.valueOf(m)));

            Element finalScore = doc.createElement("기말점수");
            gradeInfo.appendChild(finalScore);
            finalScore.appendChild(doc.createTextNode(String.valueOf(f)));
            Element hwScore = doc.createElement("과제점수");
            gradeInfo.appendChild(hwScore);
            hwScore.appendChild(doc.createTextNode(String.valueOf(h)));


            Element grade = doc.createElement("학점");
            gradeInfo.appendChild(grade);
            grade.appendChild(doc.createTextNode(String.valueOf(g)));

            // XML로 쓰기
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //정렬 스페이스4칸
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //들여쓰기
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); //doc.setXmlStandalone(true); 했을때 붙어서 출력되는부분 개행

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
