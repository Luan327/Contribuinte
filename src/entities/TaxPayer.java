package entities;

public class TaxPayer {
    private Double salaryIncome;
    private Double servicesIncome;
    private Double capitalIncome;
    private Double healthSpending;
    private Double educationSpending;

    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public Double salaryTax() {
        double rendaMensal = getSalaryIncome() / 12;

        if (rendaMensal < 3000) {
           return 0.0;
        } else if (rendaMensal < 5000) {
            return getSalaryIncome() * 0.10;
        } else {
           return getSalaryIncome() * 0.20;
        }
    }

    public Double servicesTax() {
        return getServicesIncome() > 0 ? getServicesIncome() * 0.15 : 0;
    }

    public Double capitalTax() {
        return getCapitalIncome() > 0 ? getCapitalIncome() * 0.20 : 0;
    }

    public Double grossTax() {
        return servicesTax() + capitalTax() + salaryTax();
    }

    public double taxRebate() {
        double impostoDesconto = grossTax() * 0.30;
        double gastosGerais = getHealthSpending() + getEducationSpending();
        return Math.min(gastosGerais, impostoDesconto);
    }

    public Double netTax() {
        return Math.max(0,grossTax() - taxRebate());
    }

    @Override
    public String toString() {
        return "Imposto bruto total: " + String.format("%.2f%n", grossTax())
                + "Abatimento: " + String.format("%.2f%n", taxRebate())
                + "Imposto devido: " + String.format("%.2f%n", netTax());
    }
}
