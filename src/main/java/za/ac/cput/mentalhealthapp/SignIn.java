package za.ac.cput.mentalhealthapp;



public class SignIn {

    public static void main(String[] args) {

        IdandPswrd idPassword = new IdandPswrd();
        Login loginPage = new Login(idPassword.getLoginInfo());
    }


}
