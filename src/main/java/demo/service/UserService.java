package demo.service;

import demo.util.MyBatisSqlSession;
import demo.model.Student;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by Administrator on 2016/5/16.
 */
public class UserService {

//    private static int createUserViaXML() {
//        try(SqlSession sqlSession = MyBatisSqlSession.getSqlSession(true)) {
//        /*"demo.MapperInterface.UserMapper.create"是对应user-mapper.xml映射文件里<mapper namespace="">的值*/
//        return sqlSession.insert("student.create",new Student());
//
//        }
//    }

//    private static int createUser() {
//        try (SqlSession sqlSession = MyBatisSqlSession.getSqlSession(true)) {
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            return userMapper.create(new Student(null,"lisi@qq.com","lisi","123"));
//
//        }
//
//    }

    public static void main(String[] args) {
//        createUserViaXML();
//        createUser();
    }
}
