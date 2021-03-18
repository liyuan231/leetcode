package designPattern.mid.anotherTry.mediator;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * @author liyuan
 */
public class LiyuanSqlSessionFactoryBuilder {
    public LiyuanSqlSessionFactory build(Reader reader) {
        return build(reader, null, null);
    }

    public LiyuanSqlSessionFactory build(Reader reader, String environment) {
        return build(reader, environment, null);
    }

    public LiyuanSqlSessionFactory build(Reader reader, Properties properties) {
        return build(reader, null, properties);
    }

    private LiyuanSqlSessionFactory build(Reader reader, String environment, Properties properties) {
        XMLConfigBuilder parser = new XMLConfigBuilder(reader, environment, properties);
        return build(parser.parse());
    }

    private LiyuanSqlSessionFactory build(Configuration configuartion) {
        return new LiyuanDefaultSqlSessionFactory(configuartion);
    }

    public LiyuanSqlSessionFactory build(InputStream inputStream) {
        return build(inputStream, null, null);
    }

    public LiyuanSqlSessionFactory build(InputStream inputStream, String environment) {
        return build(inputStream, environment, null);
    }

    public LiyuanSqlSessionFactory build(InputStream inputStream, Properties properties) {
        return build(inputStream, null, properties);
    }

    public LiyuanSqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
        try {
            XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
            return build(parser.parse());
        } catch (Exception e) {
            throw ExceptionFactory.wrapException("Error building SqlSession.", e);
        } finally {
            ErrorContext.instance().reset();
            try {
                inputStream.close();
            } catch (IOException e) {
                // Intentionally ignore. Prefer previous error.
            }
        }
    }

}
