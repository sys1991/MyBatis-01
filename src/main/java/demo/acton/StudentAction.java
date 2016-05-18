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
import java.nio.channels.NonWritableChannelException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/16.
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
        String photo = req.getParameter("photo");
        int classId = Integer.parseInt(req.getParameter("classId"));

        Student student = new Student();
        student.setEmail(req.getParameter("email").trim());
        student.setUsername(req.getParameter("username").trim());
        student.setPassword(password);
        student.setPhoto(photo);
        student.setLastIp(req.getRemoteAddr());
        student.setClassId(classId);

        try (SqlSession sqlSession = MyBatisSqlSession.getSqlSession(true)) {
            sqlSession.insert("student.create", student);
        }
        resp.sendRedirect("/index.jsp");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (SqlSession sqlSession = MyBatisSqlSession.getSqlSession(false)) {
            List<Student> students = sqlSession.selectList("student.login", email);
            if (students.size() == 1) {
                Student student = students.get(0);
                String encryptedPassword = student.getPassword();
                StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
                if (encryptor.checkPassword(password, encryptedPassword)) {
                    String lastIp = req.getRemoteAddr();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String lastLogin = simpleDateFormat.format(new Date());

                    student.setLastIp(lastIp);
                    student.setLastLogin(lastLogin);
                    sqlSession.update("student.update", student);
                    sqlSession.commit();

                    student.setPassword(null);
                    req.getSession().setAttribute("student", student);
                    resp.sendRedirect("/student/index.jsp");
                } else {

                    req.setAttribute("message", "检查账号或者密码");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }

            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
