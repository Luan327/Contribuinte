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
        double taxa = 0;
        if (rendaMensal < 3000) {
            taxa = 0;
        } else if (rendaMensal < 5000) {
            taxa = getSalaryIncome() * 0.10;
        } else {
            taxa = getSalaryIncome() * 0.20;
        }
        return taxa;
    }

    public Double servicesTax() {
        double taxa = 0;
        if (getServicesIncome() > 0) {
            taxa = getServicesIncome() * 0.15;
        }
        return taxa;
    }

    public Double capitalTax() {
        double taxa = 0;
        if (getCapitalIncome() > 0) {
            taxa = getCapitalIncome() * 0.20;
        }
        return taxa;
    }
    public Double grossTax(){
        return servicesTax() + capitalTax() + salaryTax();
    }
    public double taxRebate(){
       double impostoDesconto = grossTax() * 0.30;
       double gastosGerais = getHealthSpending() + getEducationSpending();
       double abatimento;
       if(gastosGerais < impostoDesconto){
           abatimento = gastosGerais;
       }else{
           abatimento = impostoDesconto;
       }
       return abatimento;
    }
    public Double netTax(){
        return grossTax() - taxRebate();
    }

    @Override
    public String toString() {
        return "Imposto bruto total: " + String.format("%.2f%n",grossTax())
                + "Abatimento: " + String.format("%.2f%n",taxRebate())
                + "Imposto devido: " + String.format("%.2f%n",netTax());
    }
}
