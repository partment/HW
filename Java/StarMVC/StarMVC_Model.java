public class StarMVC_Model {
    public StarMVC_Model() {}
    public String Print(int input) {
        String temp = "";
        for (int i = 0;i<input;i++) {
            temp = temp+"*";
        }
        temp = temp+"\n";
        return temp;
    }
}