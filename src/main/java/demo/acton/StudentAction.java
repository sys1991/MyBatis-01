package demo.acton;

import demo.model.Student;
import demo.util.MyBatisSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.jasypt.util.password.StrongPasswordEncryptor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/5/16.
 *
 */
@WebServlet(urlPatterns = "/student")
public class StudentAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action").equals("login")) {
            login(req, resp);
        }
        if (req.getParameter("action").equals("signUp")) {
            signUp(req, resp);

        }
    }

    protected void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        password = passwordEncryptor.encryptPassword(password);

        Student student = new Student();
        student.setEmail(req.getParameter("email"));
        student.setUsername(req.getParameter("username"));
        student.setPassword(password);
        student.setLastIp(req.getRemoteAddr());

        try (SqlSession sqlSession = MyBatisSqlSession.getSqlSession(true)) {
            sqlSession.insert("student.create", student);
        }
        resp.sendRedirect("/index.jsp");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setEmail(req.getParameter("email"));
        student.setLastIp(req.getRemoteAddr());

        try (SqlSession sqlSession = MyBatisSqlSession.getSqlSession(true)) {
           List<Student> students= sqlSession.selectList("student.login",student);
            for (Student s:students) {
                if (s.getPassword().equals(req.getParameter("password"))) {
                    sqlSession.update("student.login", student);
                    resp.sendRedirect("/student/index.jsp");
                } else {
                    continue;
                }
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
