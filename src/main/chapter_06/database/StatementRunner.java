package main.chapter_06.database;

import java.sql.*;

public class StatementRunner {
    private final Connection conn;

    public StatementRunner(Connection conn) {
        this.conn = conn;
    }

    // extract 메서드에 실행 어라운드 패턴 사용
    <R> R extract(final String sql, final Extractor<R> extractor) {
        try (var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.clearParameters();
            return extractor.run(stmt);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    void withStatement(final String sql, final With<PreparedStatement> withPrepareStatement) {
        extract(sql, stmt -> {
            withPrepareStatement.run(stmt);
            return null;
        });
    }

    void update(final String sql) {
        withStatement(sql, PreparedStatement::execute);
    }

    void query(final String sql, final With<ResultSet> withPrepareStatement) {
        withStatement(sql, statement -> {
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                withPrepareStatement.run(resultSet);
            }
        });
    }
}
