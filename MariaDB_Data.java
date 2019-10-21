import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MariaDB_Data {

	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/booktest";
		String user = "root";
		String pw = "1234";
		String sql = "";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("����̹� �ε� �Ϸ�!");
			Connection con = DriverManager.getConnection(url, user, pw);
			
						
			if(con != null) {
				System.out.println("mysql ���� ����");
//				sql = "insert into member(user_id, pass, name, gender, zipcode,"
//						+ "address1, address2, address3) values "
//						+ "('"+userid+"', '"+pass+"', '"+name+"', '"+gender+"', '"
//						+ zipcode+"', '"+address1+"', '"+address2+"', '"+address3+"')";
				sql = "insert into book(name, Publisher, cost, author)"
						+ "values (?,?,?,?)";
				
				//System.out.println(sql);
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, Publisher);
				pstmt.setString(3, cost);
				pstmt.setString(4, author);
				
				int result = pstmt.executeUpdate();
				if(result == 1) {
					System.out.println("����");
				}else {
					System.out.println("����");
				}
			}
		}catch(ClassNotFoundException e) {
			System.out.println("����̹��� �������� �ʽ��ϴ�.");
		}catch(SQLException  e) {
            e.printStackTrace();
		}
	}
}