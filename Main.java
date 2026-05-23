import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome da receita: ");
        String nomeReceita = sc.nextLine();

        StringBuilder conteudo = new StringBuilder();
        conteudo.append(nomeReceita).append("\n\n");

        // Ingredientes
        int i = 1;
        System.out.println("Informe os ingredientes (deixe a descrição em branco para parar):");
        while (true) {
            System.out.print("Ingrediente " + i + " - Descrição: ");
            String descricao = sc.nextLine();
            if (descricao.isEmpty()) break;

            System.out.print("Ingrediente " + i + " - Quantidade: ");
            String quantidade = sc.nextLine();

            conteudo.append(i).append(". ").append(descricao).append(" - ").append(quantidade).append("\n");
            i++;
        }

        conteudo.append("\n");

        // Instruções
        int passo = 1;
        System.out.println("Informe as instruções passo a passo (deixe em branco para parar):");
        while (true) {
            System.out.print("Passo " + passo + ": ");
            String instrucao = sc.nextLine();
            if (instrucao.isEmpty()) break;

            conteudo.append("Passo ").append(passo).append(": ").append(instrucao).append("\n");
            passo++;
        }

        // Salva arquivo
        String nomeArquivo = nomeReceita.replace(" ", "_") + ".txt";
        FileWriter fw = new FileWriter(nomeArquivo);
        fw.write(conteudo.toString());
        fw.close();

        System.out.println("Receita salva em: " + nomeArquivo);
        sc.close();
    }
}