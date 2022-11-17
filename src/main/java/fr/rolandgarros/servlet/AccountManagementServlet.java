package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Account;
import fr.rolandgarros.services.AccountService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class AccountManagementServlet extends HttpServlet {

    final AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        String page = "/AccountManagement/AccountManagement.jsp";

        List<Account> accounts = accountService.getAllAccount();

        boolean isDeleteAccount = req.getParameter("delete") != null;

        if ( isDeleteAccount ) {
            int idAccountToDelete = Integer.parseInt(req.getParameter("accountId"));
            Account accountToDelete = accountService.getAccountById(idAccountToDelete);
            accountService.deleteAccount(accountToDelete);
        }

        req.setAttribute("accounts", accounts);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
