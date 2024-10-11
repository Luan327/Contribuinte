import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos contribuintes: ");
        int quantidadeContribuinte = sc.nextInt();

        List<TaxPayer> tP = new ArrayList<>();
        for (int i = 0; i < quantidadeContribuinte; i++) {
            System.out.println("Dados do " + (i + 1) + "º contribuinte: ");
            System.out.print("Renda Salario: ");
            double rendaSalario = sc.nextDouble();

            System.out.print("Renda Prestação Serviço: ");
            double rendaPrestacao = sc.nextDouble();

            System.out.print("Renda Capital: ");
            double rendaCapital = sc.nextDouble();

            System.out.print("Gastos Medicos: ");
            double gastosMedicos = sc.nextDouble();

            System.out.print("Gastos educacionais: ");
            double gastosEducacionais = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(rendaSalario,rendaPrestacao,rendaCapital,gastosMedicos,gastosEducacionais);
            tP.add(taxPayer);
        }
    }
}