package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Account;
import fr.rolandgarros.services.AccountService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccountServlet extends HttpServlet {

    final AccountService accountService = new AccountService();

    public static final String LOGIN_ERROR_WRONG_LOGIN_OR_PASSWORD = "WrongPasswordOrLogin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        String page = "/ViewAccount/Connection.jsp";;

        String login = req.getParameter("Login");
        String password = req.getParameter("Password");

        if (login == null || password == null) {
            doRedirection(req, resp, page);
            return;
        }

        Account account = accountService.getAccount(login, password);
        if (account == null) {
            req.setAttribute("error", LOGIN_ERROR_WRONG_LOGIN_OR_PASSWORD);
            doRedirection(req, resp, page);
            return;
        }

        req.getSession().setAttribute("login", account.getLogin());
        req.getSession().setAttribute("role", account.getRole());

        try {
            resp.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doRedirection(HttpServletRequest req, HttpServletResponse resp, String page) {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
