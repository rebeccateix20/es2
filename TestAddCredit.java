import Exceptions.UserAlreadyExists;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestAddCredit {

    private BikeRentalSystem bikeRental;
    private static final int rentalFee=30;

    @BeforeEach
    public void testAddCredit() {
        bikeRental = new BikeRentalSystem(rentalFee);
        try {
            bikeRental.registerUser(2, "Teste", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }



    }

    @Test
    public void verifyAmount(){
        bikeRental.addCredit(2,2);
        Assertions.assertEquals(2,bikeRental.getUsers().get(0).getCredit(),"Credit deve ser igual a 2");
    }


     @Test
    public void limiteSupAmount() {
         bikeRental.addCredit(2, Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE,bikeRental.getUsers().get(0).getCredit(),"Amount deve ser igual a maxInt");
    }


     @Test
    public void verifyAmount0(){
         bikeRental.addCredit(2,0);
        Assertions.assertEquals(0,bikeRental.getUsers().get(0).getCredit(),"Amount=0, deve retornar 0");
    }

    @Test
    public void verifyAmountNegative(){
        bikeRental.addCredit(2,-100);
        Assertions.assertEquals(-1,bikeRental.getUsers().get(0).getCredit());
    }
}
