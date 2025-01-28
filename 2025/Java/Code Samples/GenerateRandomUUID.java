import java.util.UUID;

public class GenerateRandomUUID {
    public static void main(String[] args) {
        String randomUUID=UUID.randomUUID().toString();
        System.out.println(randomUUID);
    }
}