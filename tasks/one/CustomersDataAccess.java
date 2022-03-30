package by.epam.tr.tasks.one;

import by.epam.tr.tasks.one.models.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomersDataAccess {

    private List<Customer> customers;

    public CustomersDataAccess() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customer.setId(customers.size() + 1);
        customers.add(customer);
    }

    public List<Customer> getSortedByName() {
        List<Customer> temp = new ArrayList<>(customers);
        temp.sort(Comparator.comparing(Customer::getSurname));
        return temp;
    }

    public List<Customer> getCustomersInCardInterval(String from, String to) {
        List<Customer> temp = new ArrayList<>();
        customers.forEach(customer -> {
            if (customer.getCardNumber().compareTo(from) >= 0 && customer.getCardNumber().compareTo(to) <= 0) {
                temp.add(customer);
            }
        } );
        return temp;
    }
}
