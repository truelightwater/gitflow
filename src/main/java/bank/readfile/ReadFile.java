package bank.readfile;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface ReadFile {
    Object readFile(String fileName) throws IOException, ParseException, org.json.simple.parser.ParseException;
}


