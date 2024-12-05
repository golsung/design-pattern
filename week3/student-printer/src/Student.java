import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    public Student(String name) {
        this.name = name;
    }
    private String name;
    private double midScore;
    private double finalScore;
    private double hwScore;

    public void setMidScore(double midScore) {
        this.midScore = midScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public void setHwScore(double hwScore) {
        this.hwScore = hwScore;
    }

    public Grade calculateGrade() {
        double total = 0.0;

        total = 0.35 * midScore + 0.35 * finalScore + 0.3 * hwScore;
        if (total >= 85.0) return Grade.A;
        if (total >= 75.0) return Grade.B;
        if (total >= 65.0) return Grade.C;
        if (total >= 50.0) return Grade.D;
        return Grade.F;
    }

    public void print(String mode) {
        if (mode.equals("xml")) {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                doc.setXmlStandalone(true);

                Element student = doc.createElement("학생성적정보");
                doc.appendChild(student);

                Element name = doc.createElement("이름");
                student.appendChild(name);
                name.appendChild(doc.createTextNode(this.name));

                Element gradeInfo = doc.createElement("성적정보");
                student.appendChild(gradeInfo);

                Element middleScore = doc.createElement("중간점수");
                gradeInfo.appendChild(middleScore);
                middleScore.appendChild(doc.createTextNode(String.valueOf(this.midScore)));

                Element finalScore = doc.createElement("기말점수");
                gradeInfo.appendChild(finalScore);
                finalScore.appendChild(doc.createTextNode(String.valueOf(this.finalScore)));
                Element hwScore = doc.createElement("과제점수");
                gradeInfo.appendChild(hwScore);
                hwScore.appendChild(doc.createTextNode(String.valueOf(this.hwScore)));


                Element grade = doc.createElement("학점");
                gradeInfo.appendChild(grade);
                grade.appendChild(doc.createTextNode(String.valueOf(calculateGrade())));

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
        else if (mode.equals("json")) {
            JSONObject entry = new JSONObject();

            Map item = new LinkedHashMap();
            item.put("name", this.name);
            item.put("midScore", this.midScore);
            item.put("finalScore", this.finalScore);
            item.put("hwScore", this.hwScore);
            item.put("grade", calculateGrade());

            JSONObject json = new JSONObject(item);

            System.out.println(json.toJSONString());
        }
    }
}
