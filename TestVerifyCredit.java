import Models.User;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVerifyCredit {

    @Test
    public void testVerifyCredit()throws  Exceptions.UserAlreadyExists{
        BikeRentalSystem bike = new BikeRentalSystem(2);

        //utilizador com o IDUser não existe
        assertFalse(bike.verifyCredit(1));

        //Criação de User
        User user = new User(1, "teste", 1);
        bike.registerUser(user.getIDUser(), user.getName(), user.getRentalProgram());


        //com utilizador mas sem credito
        assertFalse(bike.verifyCredit(1));


        //Criaçao do crédito
        bike.addCredit(1, 3);

        //retorna true
        assertTrue(bike.verifyCredit(1));
    }

}
