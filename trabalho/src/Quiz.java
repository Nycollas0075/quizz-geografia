import java.util.Calendar;
import java.util.Scanner;
public class Quiz {
    public static void main(String[] args) {
        Cabecalho.exibir();
        Questao[] questoes = new Questao[15];

        String[] perguntas = {
                "Qual é a capital do Brasil?",
                "Em que continente fica o Egito?",
                "Qual é o maior oceano do mundo?",
                "Qual é o maior país do mundo em extensão territorial?",
                "Em que continente está localizado o Deserto do Saara?",
                "Qual é o país mais populoso do mundo?",
                "Em que continente está localizada a Austrália?",
                "Qual é a capital da França?",
                "Qual é a maior cidade do Brasil em termos de população?",
                "Em qual oceano está localizado o arquipélago do Havai?",
                "Qual é a capital da Argentina?",
                "Qual país possui o maior número de vulcões ativos no mundo?",
                "Em que continente está localizada a Mongólia?",
                "Qual é a capital do Japão?",
                "Qual é o país que possui a maior área de florestas tropicais??"
        };

        String[][] opcoes = {
                {"Brasilia", "Goiania", "Rio de Janeiro", "Para", "Amazonas"},
                {"Europa", "Asia", "Oceania", "Africa", "America do sul"},
                {"Pacifico", "Indico", "Atlantico", "Artico", "Antartico"},
                {"China", "EUA", "Brasil", "Russia", "Canada"},
                {"Africa", "Chile", "Brasil", "Russia", "EUA"},
                {"India", "EUA", "China", "Russia", "Brasil"},
                {"Europa", "Africa", "America", "Oceania", "Asia"},
                {"Lisboa", "Madri", "Bruxelas", "Berlim", "Paris"},
                {"Sao Paulo", "Goiania", "Brasilia", "Fortaleza", "Tocantins"},
                {"Pacifico", "Artico", "Antartico", "Atlantico", "Indico"},
                {"Buenos aires", "Quito", "Brasilia", "Santiago", "Montevideu"},
                {"Chile", "Brasil", "Colombia", "EUA", "Indonesia"},
                {"Europa", "Africa", "America", "Asia", "Oceania"},
                {"Toquio", "Quioto", "Osaka", "Hiroshima", "Nagoya"},
                {"Berlin", "Toquio", "Brasil", "Colombia", "Argentina"}
        };

        String[] respostasCorretas = {"a", "d", "a", "d", "A", "c", "d", "e", "a", "a", "a", "e", "d", "a", "c"};

        for (int i = 0; i < questoes.length; i++) {
            questoes[i] = new Questao();
            questoes[i].setPergunta(perguntas[i]);
            questoes[i].setOpcoes(opcoes[i][0], opcoes[i][1], opcoes[i][2], opcoes[i][3], opcoes[i][4]);
            questoes[i].setCorreta(respostasCorretas[i]);
        }

        Scanner scanner = new Scanner(System.in);
        int acertos = 0;

        for (Questao q : questoes) {
            q.escrevaQuestao();
            String resposta = q.leiaResposta(scanner);
            if (q.isCorreta(resposta)) {
                acertos++;
            }
        }

        System.out.println("Você acertou " + acertos + " de " + questoes.length + " questões.");
        scanner.close();
    }
}

class Cabecalho {
    public static void exibir() {
        System.out.println("====================================");
        System.out.println("      Faculdade : Unifan");
        System.out.println("      Aluno: Carlos henrick");
        System.out.println("      Professor: Ronaldo");
        System.out.println("      Tema: Quiz de Geografia");
        System.out.println("====================================\n");
    }
}

class Questao {
    private String pergunta;
    private String opcaoA;
    private String opcaoB;
    private String opcaoC;
    private String opcaoD;
    private String opcaoE;
    private String correta;

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setOpcoes(String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE) {
        this.opcaoA = opcaoA;
        this.opcaoB = opcaoB;
        this.opcaoC = opcaoC;
        this.opcaoD = opcaoD;
        this.opcaoE = opcaoE;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }

    public boolean isCorreta(String resposta) {
        if (resposta.equalsIgnoreCase(this.correta)) {
            System.out.println("Parabéns, resposta correta! - Letra: " + this.correta);
            return true;
        } else {
            System.out.println("Resposta errada! A opção correta é a letra: " + this.correta);
            return false;
        }
    }

    public String leiaResposta(Scanner scanner) {
        String resp;
        do {
            System.out.println("Digite a resposta: ");
            resp = scanner.next();
        } while (!respostaValida(resp));
        return resp;
    }

    private boolean respostaValida(String resp) {
        if (resp.equalsIgnoreCase("A") || resp.equalsIgnoreCase("B") ||
                resp.equalsIgnoreCase("C") || resp.equalsIgnoreCase("D") ||
                resp.equalsIgnoreCase("E")) {
            return true;
        }
        System.out.println("Resposta inválida! Digite opção A, B, C, D ou E.");
        return false;
    }

    public void escrevaQuestao() {
        System.out.println(this.pergunta);
        System.out.println("A) " + this.opcaoA);
        System.out.println("B) " + this.opcaoB);
        System.out.println("C) " + this.opcaoC);
        System.out.println("D) " + this.opcaoD);
        System.out.println("E) " + this.opcaoE);
    }
}