package com.visa.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.visa.prj.entity.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public int addProduct(Product p) throws PersistenceException {
		int id = 0;
		String SQL = "insert into products(id, name, priced, category, count) values (0, ?, ?, ?, ?)";
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getCategory());
			ps.setInt(4, p.getCount());
			ps.executeUpdate(); // INSERT, DELETE, UPDATE
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException ex) {
			throw new PersistenceException("unable to add product", ex);
		} finally {
			DbUtil.closeConnection(con);
		}
		return id;
	}

	@Override
	public List<Product> getProduct() throws FetchException {
		List<Product> products = new ArrayList<>();
		String SQL = "select * from products";
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"),
						rs.getDouble("priced"), rs.getInt("count")));
			}

		} catch (SQLException e) {
			throw new FetchException("unable to fetch", e);
		} finally {
			DbUtil.closeConnection(con);
		}

		return products;
	}

}
