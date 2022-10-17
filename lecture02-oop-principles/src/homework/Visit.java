package homework;

import java.util.Date;

public class Visit {

    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense += serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense += productExpense;
    }

    public double getTotalExpense() {
        return (this.serviceExpense - (this.serviceExpense * DiscountRate.getServiceDiscountRate(customer.getMemberType()))) +
                (this.productExpense - (this.productExpense * DiscountRate.getProductDiscountRate(customer.getMemberType())));
    }

    @Override
    public String toString() {
        return "Visit{" +
                "customer name=" + customer.getName() +
                ", customer member=" + customer.isMember() +
                ", customer member type=" + customer.getMemberType() +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }
}
