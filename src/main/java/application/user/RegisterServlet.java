package application.user;

import application.pub.BaseServlet;
import persistent.pojo.user.User;
import service.user.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/application/user/register")
public class RegisterServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) {
        String json = req.getParameter("user");
        RegisterService rs = new RegisterService();
        User user = (User) RegisterService.getBeanFromJson(json, User.class);
        try {
            resp.getWriter().print(rs.register(user));
        } catch (Exception e) {

        }
    }

}
