package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO class has CRUD + Query methods 
public class ProductDAO {

	public static int save(Product p) throws SQLException {
		// Insert
		int generatedId = 0;
		try (Connection c = JdbcUtil.getConnection()) {

			// String sql = "insert into product values(" + p.getId() + ",'" + p.getName() +
			// "'," + p.getPrice() + ","
			// + p.getQoh() + ")";
			String psql = "insert into product(product_name, product_price,product_qoh) values(?,?,?)";
			PreparedStatement s = c.prepareStatement(psql, Statement.RETURN_GENERATED_KEYS);
			// s.setInt(1, p.getId());
			s.setString(1, p.getName());
			s.setFloat(2, p.getPrice());
			s.setInt(3, p.getQoh());
			s.executeUpdate();

			ResultSet keys = s.getGeneratedKeys();
			keys.next();
			generatedId = keys.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return generatedId;
	}

	public Product findById(Integer id) {
		// Read based on Id
		Product p = null;
		try (Connection c = JdbcUtil.getConnection()) {
			PreparedStatement s = c.prepareStatement("select* from product where product_id=?");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				p = mapRow(rs);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product p;
		p = new Product();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setPrice(rs.getFloat(3));
		p.setQoh(rs.getInt(4));
		return p;
	}

	public List<Product> findAll() {
		// Read All
		List<Product> all = new ArrayList<>();
		try (Connection c = JdbcUtil.getConnection()) {
			c.setAutoCommit(false);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from product");
			while (rs.next()) {
				Product aProduct = mapRow(rs);
				all.add(aProduct);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return all;
	}

	public void remove(Integer id) {
		// delete
		try (Connection c = JdbcUtil.getConnection()) {

			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("delete from product where product_id =id");
			while(rs.next()) {
				System.out.println(rs);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//		public void update(Product updated) {
//		//update	
//		}

	public static void main(String[] args) throws SQLException {
		ProductDAO dao = new ProductDAO();

		Product toBeSaved = new Product("Pencil box", 20, 3);
		int generatedId = dao.save(toBeSaved);
		System.out.println("Product created with genearted id " + generatedId);
		Product fromDb = dao.findById(generatedId);
		System.out.println(fromDb);
		List<Product> all = dao.findAll();
		all.forEach(System.out::println);
		dao.remove(3);
	}
}
