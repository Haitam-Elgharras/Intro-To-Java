package exceptions;

import java.io.IOException;

public class Account {
    private float balance;
    public void deposit(float value) throws IOException {
        // here we mustn't handle the exception because it should be handled by the caller
        if(value <= 0)
            throw new IllegalArgumentException();
        //or
        if (value <= 0)
            throw new IOException();
    }

    public void withdraw(float value) throws InsufficientFundsException
    {
        if(value > balance)
            throw new InsufficientFundsException();
    }


}
