import Models.Deposit;
import Models.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReturnBicycle {

    @Test
    public void tipoEntradas(){
        BikeRentalSystem bike = new BikeRentalSystem(0);

        //Erro de compilação pois é obrigatorio as variaveis serem todas do tipo inteiro
        //assertThrows(Exception.class, ()->bike.returnBicycle(1,"Exemplo" ,"Exemplo" ));
    }


    @Test
    public void testReturnBicycle()throws Exceptions.UserAlreadyExists{
        BikeRentalSystem bike = new BikeRentalSystem( 1);

        //test sem IDUser
        assertEquals(-1, bike.returnBicycle(2, 2,2), "Deve retornar -1, user não existe");

        //Registar user
        User user = new User(2, "teste", 1);
        bike.registerUser(user.getIDUser(), user.getName(), user.getRentalProgram());

        //teste com user mas sem deposito criado
        assertEquals(-1, bike.returnBicycle(2, 2, 2), "Deve retornar -1, depósito não existe");
        Deposit deposit = new Deposit(2);

        //teste com user e deposito mas bicicleta não existe
        assertEquals(-1, bike.returnBicycle(deposit.getIDDeposit(), 2, 2), "Deve retornar -1, bicicleta não tem aluguer ativo");
        bike.addBicycle(2, 1, 1);


    }

}
