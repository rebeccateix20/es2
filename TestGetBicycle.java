import Exceptions.UserDoesNotExists;
import Models.Deposit;
import Models.User;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetBicycle {

    @Test
    public void testGetBicycle() throws Exceptions.UserAlreadyExists, UserDoesNotExists {
        BikeRentalSystem bike = new BikeRentalSystem(1);

        //test sem IDUser
        assertEquals(-1, bike.getBicycle(2, 2,2), "Deve retornar -1, user não existe");

        //Registar user
        User user = new User(2, "teste", 1);
        bike.registerUser(user.getIDUser(), user.getName(), user.getRentalProgram());

        //teste com user mas sem deposito criado
        assertEquals(-1, bike.getBicycle(2, 2, 2), "Deve retornar -1, depósito não existe");
        Deposit deposit = new Deposit(2);

    }

}
