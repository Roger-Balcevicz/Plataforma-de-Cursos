package br.com.plataformacursos.certificado;

import br.com.plataformacursos.dominio.Matricula;

import java.time.LocalDate;

/**
 * Factory Method: <b>ConcreteProduct</b>.
 *
 * <p>Certificado de extensão: </p>
 */
public class CertificadoCapacitacao extends Certificado {

    private final LocalDate dataValidade;

    protected CertificadoCapacitacao(String codigo, Matricula matricula, LocalDate dataEmissao, LocalDate dataValidade) {
        super(codigo, matricula, dataEmissao);
        this.dataValidade = dataValidade;
    }

    @Override
    public TipoCertificado getTipo() {
        return TipoCertificado.CAPACITACAO;
    }

    @Override
    protected String gerarTexto() {
        return String.format(
                "Certificamos que %s recebeu este reconhecimento " +
                "por seu desempenho excepcional no curso de \"%s\" (%d horas).",
                getNomeAluno(), getTituloCurso(), getCargaHoraria()
        );
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}
