package Base;

import static java.lang.Math.round;

public class LoginData {
    private String username;
    private String password;
    private String existingName;
    private String non_existingName;
    private String emptyFirstName;
    private String firstName;
    private String lastName;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getexistingName(){
        return existingName;
    }
    public String getnon_existingName(){
        return non_existingName;
    }

    public String getEmptyFirstName(){
        return emptyFirstName;
    }
    public String getFirstName(){
        return firstName+(String.valueOf(Math.round(Math.random()*10000) ) ) ;
    }
    public String getLastName(){
        return lastName+(String.valueOf(Math.round(Math.random()*10000) ) );
    }

}
