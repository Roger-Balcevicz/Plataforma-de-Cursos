package br.com.plataformacursos.certificado;

import br.com.plataformacursos.dominio.Matricula;

import java.time.LocalDate;

/**
 * Factory Method: <b>ConcreteProduct</b>.
 *
 * <p>Certificado de mérito: reconhece o esforço e desempenho excepcional do aluno.</p>
 */
public class CertificadoMerito extends Certificado {
    protected CertificadoMerito(String codigo, Matricula matricula, LocalDate dataEmissao) {
        super(codigo, matricula, dataEmissao);
    }

    @Override
    public TipoCertificado getTipo() {
        return TipoCertificado.MERITO;
    }

    @Override
    protected String gerarTexto() {
        return String.format("Certificamos que %s recebeu este reconhecimento " +
                "por seu desempenho excepcional no curso de \"%s\" (%d horas).", getNomeAluno(), getTituloCurso(), getCargaHoraria());
    }
}
