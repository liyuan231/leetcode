package designPattern.mid;

import designPattern.mid.anotherTry.mediator.LiyuanSqlSession;
import designPattern.mid.anotherTry.mediator.LiyuanSqlSessionFactory;
import designPattern.mid.anotherTry.mediator.LiyuanSqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestORM {
    public static void main(String[] args) throws FileNotFoundException {
        LiyuanSqlSessionFactory sqlSessionFactory = new LiyuanSqlSessionFactoryBuilder().build(new FileInputStream("F:\\IdeaProjects\\leetcode\\resources\\configuration.xml"));
        LiyuanSqlSession liyuanSqlSession = sqlSessionFactory.openSession();
        Object o = liyuanSqlSession.selectOne("designPattern.mid.anotherTry.dao.IUserDao", 1L);

        System.out.println(o);

    }
}
