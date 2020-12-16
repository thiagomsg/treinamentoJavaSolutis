package br.solutis.banco.configDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/banco?useTimezone=true&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}

	}
}
