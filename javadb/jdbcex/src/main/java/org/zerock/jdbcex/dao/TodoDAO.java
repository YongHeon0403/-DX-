package org.zerock.jdbcex.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {
    public String getTime() {
        String now = null;

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             // ConnectionUtil 클래스의 싱글톤 인스턴스를 통해 DB 연결을 가져옵니다.

             PreparedStatement preparedStatement = connection.prepareStatement("select now()");
             // prepareStatement(String sql) : 주어진 SQL 문을 미리 컴파일해서 PreparedStatement 객체를 생성.
             // "select now()" : MySQL 기준으로 현재 시간을 조회하는 명렁어.
             // preparedStatement : 이 객체를 통해 SQL을 실행 가능.

             ResultSet resultSet = preparedStatement.executeQuery();
             // executeQuery() : SQL의 SELECT 문을 실행하는 메서드.
             // SQL 쿼리를 데이터베이스에 보내서 실행하고, 그 결과를 ResultSet 객체로 반환.
             // SQL 쿼리 "select now()"를 준비하고 실행합니다. now()는 MySQL 기준으로 현재 서버 시간을 반환하는 함수.
             ) {
            resultSet.next();    // ResultSet : 결과

            now = resultSet.getString(1);
            // 첫 번째 컬럼(현재 시간 값)을 문자열로 가져옵니다.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;    // 최종 반환
    }
    // @Cleanup을 적용한 새로운 테스트 코드
    public String getTime2() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }
}
