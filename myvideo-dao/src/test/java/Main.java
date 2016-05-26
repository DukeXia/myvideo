import com.mysql.jdbc.Connection;
import com.raycloud.dao.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.sql.*;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/1.
 */
public class Main {

    private static String url = "jdbc:mysql://127.0.0.1/ljjtest";
    private static String user = "root";
    private static String password = "root";
    static{

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = (Connection) DriverManager.getConnection(url,user,password);
            //Statement statement = conn.createStatement();

            String sql = "select * from user where id = ?";
            //statement.execute(sql);

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"dd");
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                result.getString("colus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    }
}
