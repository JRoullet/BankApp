package jroullet83.msloans.model.dto;

public class CustomerDto {

    public CustomerDto(int customerId) {
        this.customerId = customerId;
    }

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

}
