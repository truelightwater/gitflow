package bank.readfile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class jsonReadFile implements ReadFile {

    @Override
    public Object readFile(String fileName) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        // json 파일 읽기
        Reader reader = new FileReader(fileName);

        // JSONParse 에 json 데이터를 넣어 파싱한 다음 JSONObject 로 변환한다.
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        // JSONArray 로 배열에 데이터를 담는다.
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");


        System.out.println(jsonArray);

        return jsonArray;
    }

}
