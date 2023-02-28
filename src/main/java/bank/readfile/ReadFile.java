package bank.readfile;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface ReadFile {
    Object readFile(String fileName) throws IOException, ParseException;
}


