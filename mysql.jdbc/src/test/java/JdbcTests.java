import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.*;

public class JdbcTests {
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	@Test
	public void OrderCitiesByDescendingOrder() {

		connect();
		int countRows = 0;
		int testCaseAmount = 10;
		try {
			String query = "SELECT city FROM city ORDER BY city DESC LIMIT 10";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			countRows = 0;
			while(rs.next()){
				countRows ++;
				String City = rs.getString("city");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = countRows;

		assertEquals(result, testCaseAmount, "Sum of the numbers was not correct");

	}

	@Test
	public void FindTitlesLikeAirplane() {

		connect();
		int countRows = 0;
		int testCaseAmount = 2;
		try {
			String query = "SELECT title FROM film WHERE title LIKE '%airplane%'";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			countRows = 0;
			while(rs.next()){
				countRows ++;
				String Title= rs.getString("title");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = countRows;

		assertEquals(result, testCaseAmount, "Sum of the numbers was not correct");
	}

	@Test
	public void SelectHighestAmountFromPayment() {

		connect();
		String Highest = "";
		double testCaseAmount = 11.99;
		try {
			String query = "SELECT MAX(amount) AS 'Highest' FROM payment;";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while(rs.next()){
				Highest = rs.getString("Highest");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		double result = Double.parseDouble(Highest);

		assertEquals(result, testCaseAmount, "Sum of the numbers was not correct");
	}

	@Test
	public void SelectRecordsFromStoreId1() {

		connect();
		String NumberOfRecords = "";
		int testCaseAmount = 326; 
		try {
			String query = "SELECT COUNT(*) AS NumberOfRecords FROM customer AS c WHERE c.store_id = 1";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()){
				NumberOfRecords = rs.getString("NumberOfRecords");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = Integer.parseInt(NumberOfRecords);

		assertEquals(result, testCaseAmount, "Sum of the numbers was not correct");

	}

	@Test
	public void FindPaymentUsingEmail() {

		connect();
		int countRows = 0;
		int testCaseAmount = 28; 
		try {
			String query = "SELECT * FROM payment AS p INNER JOIN customer AS c ON c.customer_id = p.customer_id WHERE c.email = 'NANCY.THOMAS@sakilacustomer.org'";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			countRows = 0;
			while(rs.next()){
				countRows ++;
				Integer CustomerID = rs.getInt("customer_id");
				Integer StoreID = rs.getInt("store_id");
				String FirstName = rs.getString("first_name");
				String LastName = rs.getString("last_name");
				String Email = rs.getString("email");
				Integer AddressID = rs.getInt("address_id");
				Integer Active = rs.getInt("active");
				String CreateDate = rs.getString("create_date");
				String LastUpdate = rs.getString("last_update");
				Integer PaymentID = rs.getInt("payment_id");
				Integer StaffID = rs.getInt("staff_id");
				Integer RentalID = rs.getInt("rental_id");
				BigDecimal Amount = rs.getBigDecimal("amount");
				String PaymentDate = rs.getString("payment_date");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = countRows;

		assertEquals(result, testCaseAmount, "Sum of the numbers was not correct");
	}

	@Test
	public void FindFilmInfoFromFirstLastName() {

		connect();
		int countRows = 0;
		int testCaseAmount = 1; 
		try {
			String query = "SELECT film_info FROM actor_info AS a WHERE a.first_name = 'Bob' AND a.last_name = 'Fawcett'";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			countRows = 0;
			while(rs.next()){
				countRows ++;
				String FilmInfo = rs.getString("film_info");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = countRows;

		assertEquals(result, testCaseAmount, "Sum of the numbers was not correct");
	}

	@Test
	public void SelectFilmByTitle() {

		connect();
		int countRowsForTestCase1 = 0;
		int countRowsForTestCase2 = 0;
		int test1CaseAmount = 1; 
		int test2CaseAmount = 4; 
		try {
			String query = "SELECT @filmID := film_id FROM film WHERE title='Alien Center'";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			countRowsForTestCase1 = 0;
			while(rs.next()){
				countRowsForTestCase1 ++;
				String FilmID = rs.getString("@filmID := film_id");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			String query = "CALL film_in_stock(@filmID, 2, @inventoryIDs)";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			countRowsForTestCase2 = 0;
			while(rs.next()){
				countRowsForTestCase2 ++;
				Integer InventoryID = rs.getInt("inventory_id");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int firstResult = countRowsForTestCase1;
		int secondResult = countRowsForTestCase2;

		assertEquals(firstResult, test1CaseAmount, "Sum of the numbers was not correct");
		assertEquals(secondResult, test2CaseAmount, "Sum of the numbers was not correct");
	}

	@Test
	public void CreateNewStore() {
		connect();
		int executedSuccessfully = 0;
		int testCaseAmount = 1; 
		try {
			String query = "START TRANSACTION; SET @existingAddress = (SELECT address_id FROM address WHERE address = '47 MySakila Drive');"
					+ "INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username) "
					+ "VALUES (\"John\", \"Doe\", @existingAddress, \"rando@gmail.com\", \"2\", \"1\", \"newJohn\");"
					+ "SET @staffId = LAST_INSERT_ID();"
					+ "SET @cityId = (SELECT city_id FROM city WHERE city = 'Acua');"
					+ "INSERT INTO address (address, district, city_id, phone, location) "
					+ "VALUES ('110 Main', 'Dime Box', @cityId, 7137778888, ST_GeomFromText('POINT(1 1)'));"
					+ "SET @addressId = LAST_INSERT_ID();"
					+ "INSERT INTO store (manager_staff_id, address_id) VALUES (@staffId, @addressId);"
					+ "SET @storeId = LAST_INSERT_ID();"
					+ "UPDATE staff SET store_id = @storeId WHERE staff_id = @staffId;"
					+ "ROLLBACK;";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			executedSuccessfully = 0;
			while(rs.next()){
				executedSuccessfully ++;
				Integer AddressID = rs.getInt("address_id");
				String FirstName = rs.getString("first_name");
				String LastName = rs.getString("last_name");
				String Email = rs.getString("email");
				Integer StoreID = rs.getInt("store_id");
				Integer Active = rs.getInt("active");
				String Username = rs.getString("username");
				String Address = rs.getString("address");
				String District = rs.getString("district");
				Integer CityID = rs.getInt("city_id");
				String Phone = rs.getString("phone");
				String Location = rs.getString("location");
				Integer ManagerStaffID = rs.getInt("manager_staff_id");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = executedSuccessfully;

		assertEquals(result, testCaseAmount, "The test did not execute successfully");
	}

	@Test
	public void UpdateTimestampForNewStore() {
		connect();
		int executedSuccessfully = 0;
		int testCaseAmount = 1; 
		try {
			String query = "START TRANSACTION;"
					+ "SET SQL_SAFE_UPDATES = 0;"
					+ "UPDATE store AS s INNER JOIN address AS a ON a.address_id = s.address_id SET s.last_update = CURDATE() WHERE a.address = '110 Main';"
					+ "SET SQL_SAFE_UPDATES = 1;"
					+ "ROLLBACK;";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			executedSuccessfully = 0;
			while(rs.next()){
				executedSuccessfully ++;
				Integer AddressID = rs.getInt("address_id");
				String LastUpdate = rs.getString("last_update");
				String Address = rs.getString("address");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = executedSuccessfully;

		assertEquals(result, testCaseAmount, "The test did not execute successfully");
	}

	@Test
	public void DeleteNewStore() {
		connect();
		int executedSuccessfully = 0;
		int testCaseAmount = 1; 
		try {
			String query = "START TRANSACTION;"
					+ "SET SQL_SAFE_UPDATES = 0;"
					+ "SET @managerStaffId = (SELECT manager_staff_id FROM store AS s INNER JOIN address AS a ON a.address_id = s.address_id WHERE a.address = '110 Main');"
					+ "SET @store_id = (SELECT store_id FROM store LIMIT 1);"
					+ "UPDATE staff SET store_id = @storeId WHERE staff_id = @managerStaffId;"
					+ "DELETE s.* FROM store AS s INNER JOIN address AS a ON a.address_id = s.address_id WHERE a.address = '110 Main';"
					+ "SET SQL_SAFE_UPDATES = 1;"
					+ "ROLLBACK;";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			executedSuccessfully = 0;
			while(rs.next()){
				executedSuccessfully ++;
				Integer AddressID = rs.getInt("address_id");
				Integer StoreID = rs.getInt("store_id");
				String Address = rs.getString("address");
				Integer CityID = rs.getInt("city_id");
				Integer ManagerStaffID = rs.getInt("manager_staff_id");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		disconnect();

		int result = executedSuccessfully;

		assertEquals(result, testCaseAmount, "The test did not execute successfully");
	}

	private void connect() {
		String databaseURL = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "password";
		connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(databaseURL, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	private void disconnect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
