package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.CargoDTO;
import com.entities.Cargo;
import com.entities.Empleado;
import com.general.Database;
import com.general.Operaciones;

//
public class CargoDAO implements Operaciones{

	//Llamada a clases de API JDBC
	Connection con = null; //Nos permite abrir la conexion.
	PreparedStatement pst = null; //Entrada
	ResultSet rs = null; //Salida
	
	Database db=new Database();
	Cargo c=null;
	CargoDTO cdto=null;
	
	String resultado = null;

	@Override
	public Object guardar(Object o) {
		
		// Castear(convertir) el objeto a algo especifico
		c=(Cargo) o;
		
		//Prepara la sentencia de insercion
		String query = "INSERT INTO CARGOS VALUES(?,?,?)";
		
		try {
			
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword());
			
			pst=con.prepareStatement(query);
			
			pst.setInt(1,c.getCargoId());
			pst.setString(2,c.getDescripcion());
			pst.setInt(3,c.getSueldo());

			//ejecutar la sentencia
			int f = pst.executeUpdate();
			
			//Evalua la respuesta de la linea anterior
			if (f>0) {
				System.out.println("Se ha registrado un nuevo cargo");
				resultado="1";
			} else {
				System.out.println("No se pudo guardar");
				resultado="0";
			}
			
		} catch (Exception ex) {
			// TODO: handle exception
			resultado=ex.getMessage();
			System.out.println("Error en la BD");
		}
		return resultado;
	}

	@Override
	public Object actualizar(Object o) {
		// Castear(convertir) el objeto a algo especifico
		c=(Cargo) o;
		
		//Prepara la sentencia de insercion
		String query="UPDATE CARGOS SET DESCRIPCION=?,SUELDO=?"
				+"WHERE CARGO_ID=?";
		
		try {
			
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword());
			
			pst=con.prepareStatement(query);
			
			pst.setString(1,c.getDescripcion());
			pst.setInt(2,c.getSueldo());
			pst.setInt(3,c.getCargoId());
			
			//ejecutar la sentencia
			int f = pst.executeUpdate();
			
			//Evalua la respuesta de la linea anterior
			if (f>0) {
				System.out.println("Se ha actualizado el empleado");
				resultado="1";
			} else {
				System.out.println("No se pudo actualizar");
				resultado="0";
			}
			
		} catch (Exception ex) {
			// TODO: handle exception
			resultado=ex.getMessage();
			System.out.println("Error en la BD");
		}
		return resultado;
	}

	@Override
	public Object buscar(int id) {
			
		String query = "SELECT * FROM CARGOS WHERE CARGO_ID = "+id;
		try {
		Class.forName(db.getDriver()); //se hace la llamada al conector.
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword()); //abre la conexion.
			pst=con.prepareStatement(query); //carga la sentencia precompilada hacia la BD.
			rs=pst.executeQuery(); //ejecuta la sentencia.
			//itera
			while(rs.next()) {
			c=new Cargo(rs.getInt("CARGO_ID"),
					rs.getString("DESCRIPCION"),
					rs.getInt("SUELDO"));

		}
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Error: "+ex.getMessage());
		}
		return c;
	}

	@Override
	public Object eliminar(int id) {
		
String query = "DELETE FROM CARGOS WHERE CARGO_ID = "+id;
		
		try {
			Class.forName(db.getDriver()); // se hace la llamada al conector
			con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());//abre la conexion
			pst = con.prepareStatement(query);//ejecuta la sentencia
			int f = pst.executeUpdate();
			
			if(f>0) {
				System.out.println("Cargo eliminado");
				resultado = "1";
			}
			else {
				System.out.println("No se pudo eliminar");
				resultado = "0";
			}
		}
		catch (Exception ex) {
			resultado = ex.getMessage();
			System.out.println("Error: "+ ex.getMessage());
			
		}
						
		
		return resultado ;
	}

	@Override
	public List mostrarTodos() {
		// TODO Auto-generated method stub
		List<Object>list=new ArrayList<Object>();
		
		String query="SELECT * FROM CARGOS";
		try {
		Class.forName(db.getDriver()); //se hace la llamada al conector.
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword()); //abre la conexion.
			pst=con.prepareStatement(query); //carga la sentencia precompilada hacia la BD.
			rs=pst.executeQuery(); //ejecuta la sentencia.
			
			while(rs.next()) {
				
			c=new Cargo(rs.getInt("CARGO_ID"),
					rs.getString("DESCRIPCION"),
					rs.getInt("SUELDO"));
			list.add(c);
			
		}
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Error: "+ex.getMessage());
		}
		return list;
	}
	public CargoDTO empleadosPorCargo(int id) {
		String query="SELECT C.DESCRIPCION, E.* FROM EMPLEADO E INNER JOIN CARGOS C ON E.CARGO_ID = C.CARGO_ID WHERE C.CARGO_ID=" +id;
	try {
		Class.forName(db.getDriver()); //se hace la llamada al conector.
		con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword()); //abre la conexion.
		pst=con.prepareStatement(query); //carga la sentencia precompilada hacia la BD.
		rs=pst.executeQuery(); //ejecuta la sentencia.
		List<Empleado>list = new ArrayList<Empleado>();
		String descripcion="";
		while (rs.next()) {
			Empleado e = new Empleado(rs.getInt("EMPLEADO_ID"),
					rs.getString("NOMBRE"),
					rs.getInt("ANTIGUEDAD"),
					rs.getString("SEXO"),
					rs.getString("ESTADO_CIVIL"),
					rs.getDate("FECHA_NAC"),
					rs.getInt("CARGO_ID"));
			list.add(e);
		descripcion=rs.getString("DESCRIPCION");
		}
		cdto = new CargoDTO(descripcion,list);
		//System.out.println(cdto);
	}catch (Exception ex) {
		System.out.println("Error al listar elementos "+ex.getMessage());
	}
	return cdto;
	}
}