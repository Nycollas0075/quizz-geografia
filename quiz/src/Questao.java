public class Questao {
    String enunciado;          // Pergunta
    String[] opcoes;           // Alternativas (A, B, C, D...)
    int respostaCorreta;       // Índice da resposta correta (0, 1, 2 ou 3)

    // Construtor da questão
    public Questao(String enunciado, String[] opcoes, int respostaCorreta) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    // Método para mostrar a questão
    public void mostrar() {
        System.out.println(enunciado);
        for (int i = 0; i < opcoes.length; i++) {
            char letra = (char) ('A' + i); // Converte 0 → A, 1 → B, etc.
            System.out.println(letra + ") " + opcoes[i]);
        }
    }

    // Verifica se a resposta do usuário está certa
    public boolean verificar(int respostaUsuario) {
        return respostaUsuario == respostaCorreta;
    }
}
