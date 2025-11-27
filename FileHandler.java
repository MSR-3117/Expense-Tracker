import java.io.*;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "expenses.txt";

    public static void saveExpenses(List<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense exp : expenses) {
                writer.write(exp.getId() + "," + exp.getCategory() + "," + exp.getAmount() + "," + exp.getDate());
                writer.newLine();
            }
            System.out.println("Expenses saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    public static void loadExpenses(ExpenseManager manager) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String category = data[1];
                double amount = Double.parseDouble(data[2]);
                String date = data[3];

                manager.addExpense(new Expense(id, category, amount, date));
            }

            System.out.println("Expenses loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
}