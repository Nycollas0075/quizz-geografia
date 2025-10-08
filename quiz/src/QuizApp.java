import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando perguntas
        Questao[] quiz = new Questao[2];

        quiz[0] = new Questao(
                "Qual é a capital do Brasil?",
                new String[]{"São Paulo", "Rio de Janeiro", "Brasília", "Belo Horizonte"},
                2 // Brasília (índice 2)
        );

        quiz[1] = new Questao(
                "Quanto é 5 x 3?",
                new String[]{"15", "10", "8", "20"},
                0 // 15 (índice 0)
        );

        int pontos = 0;

        System.out.println("=== Bem-vindo ao Quiz! ===\n");

        for (int i = 0; i < quiz.length; i++) {
            System.out.println("Pergunta " + (i + 1));
            quiz[i].mostrar();

            System.out.print("Digite a letra da resposta: ");
            String respostaStr = scanner.nextLine().toUpperCase();

            // Converte letra (A, B, C...) em número (0, 1, 2...)
            int respostaUsuario = respostaStr.charAt(0) - 'A';

            if (quiz[i].verificar(respostaUsuario)) {
                System.out.println("✅ Resposta certa!\n");
                pontos++;
            } else {
                System.out.println("❌ Resposta errada.\n");
            }
        }

        System.out.println("Você acertou " + pontos + " de " + quiz.length + " perguntas.");
        scanner.close();
    }
}
