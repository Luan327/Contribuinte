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
}
