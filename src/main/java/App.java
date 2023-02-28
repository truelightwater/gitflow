public class App {
    public static void main(String[] args) {
        InformationDAO infoDAO = new InformationDAO();
        System.out.println(infoDAO.getInfoMap().toString());
    }
}
