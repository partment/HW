public class StarMVC_Controller {
    public StarMVC_Controller() {}
    public String Forwarding(String input) {
        StarMVC_Model model = new StarMVC_Model();
        String temp = "";
        switch(input) {
            case "A":
                temp = model.Print(9);
                break;
            case "B":
                temp = model.Print(5);
                break;
            case "C":
                temp = model.Print(4);
                break;
            case "D":
                temp = model.Print(2);
                break;
            default:
                temp = "Unknown input.";
        }
        return temp;
    }
}