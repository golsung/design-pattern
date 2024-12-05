import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintInJson implements Printer {
    @Override
    public void print(String name, double m, double f, double h, Grade g) {
        JSONObject entry = new JSONObject();

        Map item = new LinkedHashMap();
        item.put("name", name);
        item.put("midScore", m );
        item.put("finalScore", f);
        item.put("hwScore", h);
        item.put("grade", g);

        JSONObject json = new JSONObject(item);

        System.out.println(json.toJSONString());
    }
}
