public interface Account {
    default void createAccount(String name, String email){
        String Email,Name;
        Email = email;
        Name = name;


    }
    static int withdrawl(int amount){
        return amount;
    }

    static int deposit(int amount){
        return amount;
    }

}
