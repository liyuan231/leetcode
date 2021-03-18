package designPattern.mid.anotherTry.mediator;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

public class LiyuanDefaultSqlSessionFactory implements LiyuanSqlSessionFactory {
    private final Configuration configuration;

    public LiyuanDefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public LiyuanSqlSession openSession() {
        return openSessionFromDataSource(configuration.getDefaultExecutorType(), null, false);

    }

    private LiyuanSqlSession openSessionFromDataSource(ExecutorType executorType, TransactionIsolationLevel level, boolean autoCommit) {
        Transaction tx = null;
        Environment environment = configuration.getEnvironment();
        TransactionFactory transactionFactory = getTransactionFactoryEnvironment(environment);
        tx = transactionFactory.newTransaction(environment.getDataSource(), level, autoCommit);
        Executor executor = configuration.newExecutor(tx, executorType);
        return new LiyuanDefaultSqlSession(configuration, executor, autoCommit);
    }

    private TransactionFactory getTransactionFactoryEnvironment(Environment environment) {
        if (environment == null || environment.getTransactionFactory() == null) {
            return new ManagedTransactionFactory();
        }
        return environment.getTransactionFactory();
    }
}
