import Exceptions.UserAlreadyExists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testRegisterUser {

    private BikeRentalSystem bikeRental;

    @Test
    public void UserIDNegative(){
        int oldSize = bikeRental.getUsers().size();
        try {
            bikeRental.registerUser(-1, "ola", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bikeRental.getUsers().size();

        Assertions.assertEquals(oldSize, size, "É esperado que não adicione um User com IDUser negativo.");
    }

}
