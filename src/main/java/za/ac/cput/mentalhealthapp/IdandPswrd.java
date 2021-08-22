package za.ac.cput.mentalhealthapp;

import java.util.HashMap;

public class IdandPswrd {
    HashMap<Integer,String> loginInfo = new HashMap<Integer,String>();
    IdandPswrd(){
        loginInfo.put(218192215, "olothando");
        loginInfo.put(218192216, "alunamda");
        loginInfo.put(218192217, "owethu");
    }

    public HashMap getLogininfo(){

        return loginInfo;
    }

    public HashMap<Integer, String> getLoginInfo() {
        return loginInfo;
    }
}

