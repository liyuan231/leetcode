package designPattern.mid.anotherTry.mediator;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import java.io.IOException;
import java.util.List;

public class LiyuanDefaultSqlSession implements LiyuanSqlSession {
    private final Configuration configuration;
    private final Executor executor;
    private final boolean autoCommit;
    private boolean dirty;
    private List<Cursor<?>> cursorList;


    public LiyuanDefaultSqlSession(Configuration configuration, Executor executor, boolean autoCommit) {
        this.configuration = configuration;
        this.executor = executor;
        this.autoCommit = autoCommit;
        this.dirty = false;
    }

    @Override
    public <T> T selectOne(String statement) {
        return selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> list = selectList(statement, parameter);
        if (list.size() == 1) {
            return list.get(0);
        }
        throw new TooManyResultsException("too many results, expect one!");
    }

    @Override
    public <T> List<T> selectList(String statement) {
        return selectList(statement, null);
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        try {
            return executor.query(mappedStatement, wrapCollection(parameter), RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Object wrapCollection(Object parameter) {
        return ParamNameResolver.wrapToMapIfCollection(parameter, null);
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("operation not support!");
    }
}
