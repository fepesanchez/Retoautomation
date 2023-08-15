package Models;

public class ClientDTO {

    private static String name;
    private static String lastname;
    private static String emailtrainer;

    public ClientDTO(String name, String lastname, String emailtrainer){
        this.name = name;
        this.lastname = lastname;
        this.emailtrainer = emailtrainer;
    }

    public static String getname(){
        return name;
    }
    public static String getLastname(){
        return lastname;
    }
    public static String getEmailtrainer(){
        return emailtrainer;
    }
}
