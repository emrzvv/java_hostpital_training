package conversation;

public class Validators {
    public static void checkIfNotPositive(int id) {
        if (id <= 0) throw new NumberFormatException();
    }

    public static Boolean validateId(int id) {
        return 1 <= id && id <= 200;
    }
}
