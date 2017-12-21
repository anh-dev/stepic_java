package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, UserProfile> loginToProfile;
    private Map<String, UserProfile> sessionToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile){
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public UserProfile getUserByLogin(String login){
        return loginToProfile.get(login);
    }
    public void addSession(String sessionId, UserProfile userProfile){
        sessionToProfile.put(sessionId, userProfile);
    }
    public UserProfile getUserBySessionId(String sessionId){
        return sessionToProfile.get(sessionId);
    }
    public void deleteSession(String sessionId){
        sessionToProfile.remove(sessionId);
    }
}

