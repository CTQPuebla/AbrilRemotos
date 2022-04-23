package com.general;
//Encapsula la informacion necesaria para conectarse a la BD.

public class Database {
	
	private String usuario;
	private String password;
	private String url;
	private String driver;
	
	//Constructor
	public Database() {
		this.usuario="svr";
		this.password="admin";
		this.url="jdbc:oracle:thin:@localhost:1521:xe";
		this.driver="oracle.jdbc.OracleDriver";
	}
	//Getters & Setters
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
}
