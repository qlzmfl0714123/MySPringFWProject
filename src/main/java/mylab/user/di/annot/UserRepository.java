package mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    // XML 없이 값 주입(혼합 전략에서 어노테이션 활용)
    @Value("MySQL")
    private String dbType;

    public UserRepository() {}

    public String getDbType() { return dbType; }
    public void setDbType(String dbType) { this.dbType = dbType; }

    public boolean saveUser(String userId, String name) {
        System.out.println("사용자 저장: " + userId + ", " + name + " (DB: " + dbType + ")");
        return true;
    }

    @Override
    public String toString() {
        return "UserRepository [dbType=" + dbType + "]";
    }
}