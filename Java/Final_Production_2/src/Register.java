public class Register {
	public Register() {}
    public String entrance(String id, String address) {
        Database database = new Database();
        String fallback = database.register(id, address);
        return fallback;
    }
}