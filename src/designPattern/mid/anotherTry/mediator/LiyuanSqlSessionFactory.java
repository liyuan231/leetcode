package designPattern.mid.anotherTry.mediator;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

public interface LiyuanSqlSessionFactory {

    LiyuanSqlSession openSession();

}
