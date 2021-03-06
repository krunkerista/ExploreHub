package authentification.loginProcess;

import models.Account;

/**
 * Singleton class that holds the instance of the current registered account
 * @author: Gheorghe Mironica
 */
public class CurrentAccountSingleton {
    private static CurrentAccountSingleton ourInstance = null;
    private static Account account;

    private CurrentAccountSingleton() {

        // c-tor
    }
    public static CurrentAccountSingleton getInstance() {
        if(ourInstance == null){
            ourInstance = new CurrentAccountSingleton();
        }
        return ourInstance;
    }

    /**
     * Set the user instance equal to the argument
     * @param account the current registered account
     */
    public void setAccount(Account account){
        this.account = account;
    }
    /**
     * Get the user instance
     */
    public Account getAccount(){
        return account;
    }

}
