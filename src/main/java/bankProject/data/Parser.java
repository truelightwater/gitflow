package bankProject.data;

import bankProject.model.BankTransaction;

import java.util.List;

public interface Parser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLineFrom(List<String> line);
}
