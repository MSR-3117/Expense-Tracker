import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added successfully.");
    }

    public void removeExpense(int id) {
        Expense exp = findExpense(id);
        if (exp != null) {
            expenses.remove(exp);
            System.out.println("Expense removed successfully.");
        } else {
            System.out.println("Expense not found.");
        }
    }

    public void updateExpense(int id, String category, double amount, String date) {
        Expense exp = findExpense(id);
        if (exp != null) {
            exp.setCategory(category);
            exp.setAmount(amount);
            exp.setDate(date);
            System.out.println("Expense updated successfully.");
        } else {
            System.out.println("Expense not found.");
        }
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    public double totalExpenses() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public Expense findExpense(int id) {
        for (Expense e : expenses) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}