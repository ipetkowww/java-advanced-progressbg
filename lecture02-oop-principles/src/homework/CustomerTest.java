package homework;

import java.util.Date;

public class CustomerTest {

    public static void main(String[] args) {
        Customer c1 = new Customer("Ivan", true, "Premium");
        Customer c2 = new Customer("Georgi", true, "Silver");
        System.out.println(c1);
        System.out.println(c2);


        Visit v1 = new Visit(c1, new Date());
        v1.setProductExpense(4.5);
        v1.setServiceExpense(8.5);
        v1.setProductExpense(1.5);

        Visit v2 = new Visit(c2, new Date());
        v2.setProductExpense(14.5);
        v2.setServiceExpense(81.5);
        v2.setProductExpense(12.5);


        Visit[] visits = {v1, v2};

        double total = 0;

        for (Visit visit : visits) {
            System.out.println(visit);
            total += visit.getTotalExpense();
        }
        System.out.println("Total expense = " + total);
    }
}
