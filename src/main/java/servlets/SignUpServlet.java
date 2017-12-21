package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet  extends HttpServlet {

    private AccountService accountService;

    public SignUpServlet(AccountService accountService) {
       this.accountService = accountService;
    }

    //register user
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");


        if (login == null || pass == null){
            resp.setContentType("text/html;charset=UTF-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        UserProfile userProfile = new UserProfile(login, pass, login);
        accountService.addNewUser(userProfile);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}
