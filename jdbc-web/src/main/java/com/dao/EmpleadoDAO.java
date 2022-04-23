package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.EmpleadoDTO;
import com.entities.Empleado;
import com.general.Database;
import com.general.Operaciones;

//
public class EmpleadoDAO implements Operaciones{

	//Llamada a clases de API JDBC
	Connection con = null; //Nos permite abrir la conexion.
	PreparedStatement pst = null; //Entrada
	ResultSet rs = null; //Salida
	
	Database db=new Database();
	Empleado e=null;
	EmpleadoDTO edto=null;
	String resultado = null;

	@Override
	public Object guardar(Object o) {
		
		// Castear(convertir) el objeto a algo especifico
		e=(Empleado) o;
		
		//Prepara la sentencia de insercion
		String query="INSERT INTO EMPLEADO VALUES(?,?,?,?,?,?,?)";
		
		try {
			
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword());
			
			pst=con.prepareStatement(query);
			
			pst.setInt(1,e.getEmpleadoId());
			pst.setString(2,e.getNombre());
			pst.setInt(3,e.getAntiguedad());
			pst.setString(4,e.getSexo());
			pst.setString(5,e.getEstadoCivil());
			pst.setDate(6,e.getFechaNac());
			pst.setInt(7,e.getCargoId());
			
			//ejecutar la sentencia
			int f = pst.executeUpdate();
			
			//Evalua la respuesta de la linea anterior
			if (f>0) {
				System.out.println("Se ha registrado un nuevo empleado");
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
		e=(Empleado) o;
		
		//Prepara la sentencia de insercion
		String query="UPDATE EMPLEADO SET NOMBRE=?,ANTIGUEDAD=?,SEXO=?,ESTADO_CIVIL=?,FECHA_NAC=?,CARGO_ID=?"
				+"WHERE EMPLEADO_ID=?";
		
		try {
			
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword());
			
			pst=con.prepareStatement(query);
			
			pst.setString(1,e.getNombre());
			pst.setInt(2,e.getAntiguedad());
			pst.setString(3,e.getSexo());
			pst.setString(4,e.getEstadoCivil());
			pst.setDate(5,e.getFechaNac());
			pst.setInt(6,e.getCargoId());
			pst.setInt(7,e.getEmpleadoId());
			
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
			
		String query = "SELECT * FROM EMPLEADO WHERE EMPLEADO_ID = "+id;
		try {
		Class.forName(db.getDriver()); //se hace la llamada al conector.
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword()); //abre la conexion.
			pst=con.prepareStatement(query); //carga la sentencia precompilada hacia la BD.
			rs=pst.executeQuery(); //ejecuta la sentencia.
			//itera
			while(rs.next()) {
				
			e=new Empleado(rs.getInt("EMPLEADO_ID"),
					rs.getString("NOMBRE"),
					rs.getInt("ANTIGUEDAD"),
					rs.getString("SEXO"),
					rs.getString("ESTADO_CIVIL"),
					rs.getDate("FECHA_NAC"),
					rs.getInt("CARGO_ID"));
		}
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Error: "+ex.getMessage());
		}
		return e;
	}

	@Override
	public Object eliminar(int id) {
		
String query = "delete from Empleado where EMPLEADO_ID="+id;
		
		try {
			Class.forName(db.getDriver()); // se hace la llamada al conector
			con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());//abre la conexion
			pst = con.prepareStatement(query);//ejecuta la sentencia
			int f = pst.executeUpdate();
			
			if(f>0) {
				System.out.println("empleado eliminado");
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
		
		String query="SELECT * FROM EMPLEADO";
		try {
		Class.forName(db.getDriver()); //se hace la llamada al conector.
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword()); //abre la conexion.
			pst=con.prepareStatement(query); //carga la sentencia precompilada hacia la BD.
			rs=pst.executeQuery(); //ejecuta la sentencia.
			
			while(rs.next()) {
				
			e=new Empleado(rs.getInt("EMPLEADO_ID"),
					rs.getString("NOMBRE"),
					rs.getInt("ANTIGUEDAD"),
					rs.getString("SEXO"),
					rs.getString("ESTADO_CIVIL"),
					rs.getDate("FECHA_NAC"),
					rs.getInt("CARGO_ID"));
			list.add(e);
			
		}
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Error: "+ex.getMessage());
		}
		return list;
	}
	
	public EmpleadoDTO mostrarEmpleadoCargo(int id) {
		
		String query = "SELECT E.NOMBRE,E.ANTIGUEDAD,E.SEXO,E.ESTADO_CIVIL,E.FECHA_NAC,C.DESCRIPCION, C.SUELDO"
				+" FROM EMPLEADO E INNER JOIN CARGOS C ON E.CARGO_ID = C.CARGO_ID WHERE E.EMPLEADO_ID = "+id;
		try {
			Class.forName(db.getDriver()); //se hace la llamada al conector.
			con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getPassword()); //abre la conexion.
			
			pst=con.prepareStatement(query); //carga la sentencia precompilada hacia la BD.
			
			rs=pst.executeQuery(); //ejecuta la sentencia.
			
			while(rs.next()) {
				
			edto=new EmpleadoDTO(rs.getString("NOMBRE"),rs.getInt("ANTIGUEDAD"),rs.getString("DESCRIPCION"));
		}
			System.out.println(edto);
	}catch (Exception ex) {
		System.out.println("Error al obtener el registro "+ex.getMessage());
	}
	return edto;
	}
}