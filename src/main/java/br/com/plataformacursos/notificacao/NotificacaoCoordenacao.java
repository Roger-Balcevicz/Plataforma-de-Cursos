package br.com.plataformacursos.notificacao;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Observer: <b>ConcreteObserver</b>.
 *
 * <p>Canal da coordenação do curso: simula o aviso à equipe pedagógica quando
 * um aluno conclui o curso (para providenciar o certificado) ou cancela a
 * matrícula (para registrar a desistência). Os demais eventos não exigem
 * ação da coordenação e são ignorados.</p>
 */
public class NotificacaoCoordenacao implements ObservadorMatricula {

    private static final Set<TipoEvento> EVENTOS_RELEVANTES = EnumSet.of(
            TipoEvento.CURSO_CONCLUIDO,
            TipoEvento.MATRICULA_CANCELADA);

    private final PrintStream saida;
    private final List<String> avisos = new ArrayList<>();

    public NotificacaoCoordenacao(PrintStream saida) {
        this.saida = Objects.requireNonNull(saida);
    }

    @Override
    public void atualizar(EventoMatricula evento) {
        if (!EVENTOS_RELEVANTES.contains(evento.tipo())) {
            return;
        }
        String aviso = evento.tipo().getTitulo() + ": " + evento.matricula();
        avisos.add(aviso);
        saida.println("  [Coordenação] " + aviso);
    }

    public List<String> getAvisos() {
        return Collections.unmodifiableList(avisos);
    }
}
