package accounts;

import dataset.UserDataSet;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, UserDataSet> loginToProfile;
    private Map<String, UserDataSet> sessionToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionToProfile = new HashMap<>();
    }

    public void addNewUser(UserDataSet userProfile){
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public UserDataSet getUserByLogin(String login){
        return loginToProfile.get(login);
    }
    public void addSession(String sessionId, UserDataSet userProfile){
        sessionToProfile.put(sessionId, userProfile);
    }
    public UserDataSet getUserBySessionId(String sessionId){
        return sessionToProfile.get(sessionId);
    }
    public void deleteSession(String sessionId){
        sessionToProfile.remove(sessionId);
    }
}

