import java.util.Date;

public class SistemaBancario {
    public static void main(String[] args) {
        // Exemplo de uso
        ContaPoupanca poupanca = new ContaPoupanca(TipoCliente.FISICO, new Date(), 1000.0);
        ContaCorrente corrente = new ContaCorrente(TipoCliente.JURIDICO, new Date(), 2000.0);

        poupanca.depositar(500.0);
        poupanca.sacar(200.0);
        poupanca.exibirSaldo();

        corrente.depositar(1000.0);
        corrente.fazerTransferencia(poupanca, 300.0);
        corrente.exibirSaldo();
        poupanca.exibirSaldo();
    }
}
