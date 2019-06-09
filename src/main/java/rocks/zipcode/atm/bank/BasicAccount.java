package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public class BasicAccount extends Account {
    private String type = "Basic";

    public BasicAccount(AccountData accountData) {
        super(accountData);
    }

}
