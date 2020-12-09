
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Module {
	public static List<Diem> findAll(){
		List<Diem> DiemList = new ArrayList<Diem>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "select * from Diem ";
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				Diem Diem  = new Diem(rs.getInt("sbd"), rs.getString("ten"), rs.getString("gender"), rs.getString("chonTh"), rs.getFloat("toan"),
						rs.getFloat("van"), rs.getFloat("anh"), rs.getFloat("tohop"));
				DiemList.add(Diem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DiemList;
	}
	public static void insert(Diem Diem) {
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "insert into Diem(sbd, ten, gender, chonTh, toan, van, anh, tohop) values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Diem.getSbd());
			preparedStatement.setString(2, Diem.getTen());
			preparedStatement.setString(3, Diem.getGender());
			preparedStatement.setString(4, Diem.getChonTh());
			preparedStatement.setFloat(5, Diem.getToan());
			preparedStatement.setFloat(6, Diem.getVan());
			preparedStatement.setFloat(7, Diem.getAnh());
			preparedStatement.setFloat(8, Diem.getTohop());
			
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update(Diem Diem) {
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "update Diem set ten = ?, gender = ?, chonTh = ?, toan = ?, van = ?, anh = ?, tohop = ? where sbd = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Diem.getTen());
			preparedStatement.setString(2, Diem.getGender());
			preparedStatement.setString(3, Diem.getChonTh());
			preparedStatement.setFloat(4, Diem.getToan());
			preparedStatement.setFloat(5, Diem.getVan());
			preparedStatement.setFloat(6, Diem.getAnh());
			preparedStatement.setFloat(7, Diem.getTohop());
			preparedStatement.setInt(8, Diem.getSbd());
			
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delete(int sbd) {
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "delete from Diem where sbd = ?";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, sbd);
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static List<Diem> findByTen(String ten){
		List<Diem> DiemList = new ArrayList<Diem>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "select * from Diem where ten like ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+ten+"%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				Diem Diem  = new Diem(rs.getInt("sbd"), rs.getString("ten"), rs.getString("gender"), rs.getString("chonTh"), rs.getFloat("toan"),
						rs.getFloat("van"), rs.getFloat("anh"), rs.getFloat("tohop"));
				DiemList.add(Diem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DiemList;
		
		
	}

}

