package designPattern.mid.anotherTry.mediator;

import java.io.Closeable;
import java.util.List;

public interface LiyuanSqlSession extends Closeable {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);
}
