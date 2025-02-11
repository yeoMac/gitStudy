package gitJDBC.DBStudy.member.repository;

import gitJDBC.DBStudy.member.entity.Member;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;

@Slf4j
public class MemberRepositoryImpl implements MemberRepository{

    private final DataSource dataSource;
    private final SQLExceptionTranslator exTranslator;

    public MemberRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.exTranslator = new SQLErrorCodeSQLExceptionTranslator(dataSource);
    }


    @Override
    public String findEmailById(Long id) {
        return null;
    }

    @Override
    public Member saveMember(Member member) {
        String sql = "INSERT INTO MEMBER(password, name, nickname, email) VALUES(?, ?, ?, ?)";
        String[] generateColumns = {"member_id"};


        try (Connection con = getConnection();
             PreparedStatement pstmt=con.prepareStatement(sql,generateColumns);) {

            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getNickname());
            pstmt.setString(4, member.getEmail());

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    return new Member(id,
                            member.getPassword(),
                            member.getNickname(),
                            member.getName(),
                            member.getEmail(),
                            new Date()
                    );
                } else {
                    throw new SQLException("회원가입 실패");
                }
            }

        } catch (SQLException e) {
            throw exTranslator.translate("createMember", sql, e);
        }
    }

    private Connection getConnection() {
        Connection con = DataSourceUtils.getConnection(dataSource);
        log.info("get Connection={}, class= {}", con, con.getClass());
        return con;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
