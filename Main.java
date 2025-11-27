import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        FileHandler.loadExpenses(manager);

        while (true) {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Remove Expense");
            System.out.println("3. Update Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Total Expenses");
            System.out.println("6. Save & Exit");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    manager.addExpense(new Expense(id, category, amount, date));
                    break;

                case 2:
                    System.out.print("Enter Expense ID to remove: ");
                    int removeId = sc.nextInt();
                    manager.removeExpense(removeId);
                    break;

                case 3:
                    System.out.print("Enter Expense ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Category: ");
                    String newCat = sc.nextLine();

                    System.out.print("Enter new Amount: ");
                    double newAmt = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter new Date: ");
                    String newDate = sc.nextLine();

                    manager.updateExpense(updateId, newCat, newAmt, newDate);
                    break;

                case 4:
                    manager.viewExpenses();
                    break;

                case 5:
                    System.out.println("Total Expenses: ₹" + manager.totalExpenses());
                    break;

                case 6:
                    FileHandler.saveExpenses(manager.getExpenses());
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}