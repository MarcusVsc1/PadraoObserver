import br.ufjf.model.Cliente;
import br.ufjf.model.ViagemColetiva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteTest {

    @Test
    public void notificarClienteTest() {
        ViagemColetiva viagemColetiva = new ViagemColetiva("Tangamandapio","Acapulco");
        Cliente cliente = new Cliente("Jaime");
        cliente.assinarInteresseViagem(viagemColetiva);
        viagemColetiva.avisarViagem();
        assertEquals("Olá, Jaime! Passando para avisar que a viagem que você deseja está disponível: \n" +
                "Saindo de: Tangamandapio para Acapulco",cliente.getUltimaNotificacao());
    }

    @Test
    public void notificarClientesTest() {
        ViagemColetiva viagemColetiva = new ViagemColetiva("Tangamandapio","Acapulco");
        Cliente cliente1 = new Cliente("Jaime");
        Cliente cliente2 = new Cliente("Florinda");
        cliente1.assinarInteresseViagem(viagemColetiva);
        cliente2.assinarInteresseViagem(viagemColetiva);
        viagemColetiva.avisarViagem();
        assertEquals("Olá, Jaime! Passando para avisar que a viagem que você deseja está disponível: \n" +
                "Saindo de: Tangamandapio para Acapulco",cliente1.getUltimaNotificacao());
        assertEquals("Olá, Florinda! Passando para avisar que a viagem que você deseja está disponível: \n" +
                "Saindo de: Tangamandapio para Acapulco",cliente2.getUltimaNotificacao());
    }

    @Test
    public void ultimaNotificacaoNulaTest() {
        ViagemColetiva viagemColetiva = new ViagemColetiva("Tangamandapio","Acapulco");
        Cliente cliente = new Cliente("Jaime");
        viagemColetiva.avisarViagem();
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void notificarClienteATest() {
        ViagemColetiva viagemColetivaA = new ViagemColetiva("Tangamandapio","Acapulco");
        ViagemColetiva viagemColetivaB = new ViagemColetiva("Juiz de Fora","Cabo Frio");
        Cliente clienteA = new Cliente("Jaime");
        Cliente clienteB = new Cliente("Florinda");
        clienteA.assinarInteresseViagem(viagemColetivaA);
        clienteB.assinarInteresseViagem(viagemColetivaB);
        viagemColetivaA.avisarViagem();
        assertEquals("Olá, Jaime! Passando para avisar que a viagem que você deseja está disponível: \n" +
                "Saindo de: Tangamandapio para Acapulco",clienteA.getUltimaNotificacao());
        assertNull(clienteB.getUltimaNotificacao());
    }
}
