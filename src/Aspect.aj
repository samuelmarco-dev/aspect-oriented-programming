import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class VerificarSaldoAspect {

    @Before("execution(void Conta.sacar(double)) && args(valor) && target(conta)")
    public void verificarSaldoSaque(JoinPoint joinPoint, double valor, Conta conta) {
        if (valor > conta.getSaldo()) {
            System.out.println("Operação de saque bloqueada. Saldo insuficiente.");
            throw new RuntimeException("Operação de saque bloqueada. Saldo insuficiente.");
        }
    }

    @Before("execution(void ContaCorrente.fazerTransferencia(Conta, double)) && args(destino, valor) && target(origem)")
    public void verificarSaldoTransferencia(JoinPoint joinPoint, Conta origem, Conta destino, double valor) {
        if (valor > origem.getSaldo()) {
            System.out.println("Operação de transferência bloqueada. Saldo insuficiente.");
            throw new RuntimeException("Operação de transferência bloqueada. Saldo insuficiente.");
        }
    }
}
