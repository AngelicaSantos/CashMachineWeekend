package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public class BasicAccount extends Account {
    public String type = "Basic";

    public BasicAccount(AccountData accountData) {
        super(accountData);
    }

}
