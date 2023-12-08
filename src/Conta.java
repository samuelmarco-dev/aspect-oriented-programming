import java.util.Date;

enum TipoConta {
    POUPANCA, CORRENTE
}

enum TipoCliente {
    FISICO, JURIDICO
}

// Classe Conta principal
class Conta {
    private TipoConta tipoConta;
    private TipoCliente tipoCliente;
    private Date dataAbertura;
    private double saldo;

    public Conta(TipoConta tipoConta, TipoCliente tipoCliente, Date dataAbertura, double saldoInicial) {
        this.tipoConta = tipoConta;
        this.tipoCliente = tipoCliente;
        this.dataAbertura = dataAbertura;
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor);
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Valor de depósito inválido: R$" + valor);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}

// Classe ContaPoupanca
class ContaPoupanca extends Conta {
    public ContaPoupanca(TipoCliente tipoCliente, Date dataAbertura, double saldoInicial) {
        super(TipoConta.POUPANCA, tipoCliente, dataAbertura, saldoInicial);
    }
}

// Classe ContaCorrente
class ContaCorrente extends Conta {
    public ContaCorrente(TipoCliente tipoCliente, Date dataAbertura, double saldoInicial) {
        super(TipoConta.CORRENTE, tipoCliente, dataAbertura, saldoInicial);
    }

    // Método específico para ContaCorrente
    public void fazerTransferencia(Conta destino, double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada para a conta de " + destino.getTipoCliente());
        } else {
            System.out.println("Transferência inválida ou saldo insuficiente para transferir R$" + valor);
        }
    }
}
