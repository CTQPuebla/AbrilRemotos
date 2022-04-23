package com.msefectivo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msefectivo.impl.EfectivoImplements;
import com.msefectivo.service.EfectivoService;
import com.persistencia.entity.Efectivo;
import com.persistencia.request.EfectivoRequest;





@RestController
@RequestMapping("api/efectivo")
public class EfectivoController {

	@Autowired
	EfectivoService srv;
	@Autowired
	EfectivoImplements imp;
	 
	
	@GetMapping("mostrar-todos")
	public List<Efectivo> listar(){
		return srv.mostrarTodos();
	}
	
	
	@PutMapping("actualizar")
	public Efectivo actualizar(@RequestBody EfectivoRequest e) {
		return srv.actualizar(e);
	}
	
	

	
	

	    @RequestMapping("/example")
	    public String retiro(@RequestParam("test") double cantidad) {
	        
	    	
	    	List<Efectivo> efe= srv.mostrarTodos();
			
			double retiro= cantidad;
			//r >= efe.get(i).getId()
			double dr= retiro;
			//double dt=0;
			int contador = 0;
			
//			for (int i = 0; i < efe.size(); i++) {
//				=efe.get(i);
//			};   
			
					double a0= efe.get(0).getDenominacion();
					double a1= efe.get(1).getDenominacion();
					double a2= efe.get(2).getDenominacion();
					double a3= efe.get(3).getDenominacion();
					double a4= efe.get(4).getDenominacion();
					double a5= efe.get(5).getDenominacion();
					double a6= efe.get(6).getDenominacion();
					double a7= efe.get(7).getDenominacion();
					double a8= efe.get(8).getDenominacion();
					double a9= efe.get(9).getDenominacion();
					double a10= efe.get(10).getDenominacion();
					
					int b0= efe.get(0).getCantidad();
					int b1= efe.get(1).getCantidad();
					int b2= efe.get(2).getCantidad();
					int b3= efe.get(3).getCantidad();
					int b4= efe.get(4).getCantidad();
					int b5= efe.get(5).getCantidad();
					int b6= efe.get(6).getCantidad();
					int b7= efe.get(7).getCantidad();
					int b8= efe.get(8).getCantidad();
					int b9= efe.get(9).getCantidad();
					int b10= efe.get(10).getCantidad();
					
					int id0= efe.get(0).getEfectivoId();
					int id1= efe.get(1).getEfectivoId();
					int id2= efe.get(2).getEfectivoId();
					int id3= efe.get(3).getEfectivoId();
					int id4= efe.get(4).getEfectivoId();
					int id5= efe.get(5).getEfectivoId();
					int id6= efe.get(6).getEfectivoId();
					int id7= efe.get(7).getEfectivoId();
					int id8= efe.get(8).getEfectivoId();
					int id9= efe.get(9).getEfectivoId();
					int id10= efe.get(10).getEfectivoId();
		           
					double t1=a0*b0;
					double t2=a1*b1;
					double t3=a2*b2;
					double t4=a3*b3;
					double t5=a4*b4;
					double t6=a5*b5;
					double t7=a6*b6;
					double t8=a7*b7;
					double t9=a8*b8;
					double t10=a9*b9;
					double t11=a10*b10;
			        double saldo =t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11;
						
			           if(saldo >= retiro) {
			           while(dr>=a0 && contador< b0)
			            {
			            
			            dr=dr-a0;
			            contador++;
			            
			            }
			            String print1 = "Billete de :" + a0 + " : "+contador;
			            int res= b0-contador;
			            imp.retiro(res, id0);
			            contador=0;
			            while(dr>=a1 && contador< b1)
			            {
			            
			            dr=dr-a1;
			            contador++;
			            
			            }
			            String print2 ="Billete de :" + a1 + " : "+contador;
			            int res1= b1-contador;
			            imp.retiro(res1, id1);
			            contador=0;
			            while(dr>=a2 && contador< b2)
			            {
			            
			            dr=dr-a2;
			            contador++;
			            
			            }
			            String print3 ="Billete de :" + a2 + " : "+contador; 
			            int res2= b2-contador;
			            imp.retiro(res2, id2);
			            contador=0;
			            while(dr>=a3 && contador< b3)
			            {
			            
			            dr=dr-a3;
			            contador++;
			            
			            }
			            String print4 ="Billete de :" + a3 + " : "+contador;
			            int res3= b3-contador;
			            imp.retiro(res3, id3);
			            contador=0;
			            while(dr>=a4 && contador< b4)
			            {
			            
			            dr=dr-a4;
			            contador++;
			            
			            }
			            String print5 ="Billete de :" + a4 + " : "+contador;
			            int res4= b4-contador;
			            imp.retiro(res4, id4);
			            contador=0;
			            while(dr>=a5 && contador< b5)
			            {
			            
			            dr=dr-a5;
			            contador++;
			            
			            }
			            String print6 ="Billete de :" + a5 + " : "+contador;
			            int res5= b5-contador;
			            imp.retiro(res5, id5);
			            contador=0;
			            while(dr>=a6 && contador< b6)
			            {
			            
			            dr=dr-a6;
			            contador++;
			            
			            }
			            String print7 ="Monedas de :" + a6 + " : "+contador;
			            int res6= b6-contador;
			            imp.retiro(res6, id6);
			            contador=0;
			            while(dr>=a7 && contador< b7)
			            {
			            
			            dr=dr-a7;
			            contador++;
			            
			            }
			            String print8 ="Monedas de :" + a7 + " : "+contador;
			            int res7= b7-contador;
			            imp.retiro(res7, id7);
			            contador=0;
			            while(dr>=a8 && contador< b8)
			            {
			            
			            dr=dr-a8;
			            contador++;
			            
			            }
			            String print9 ="Monedas de :" + a8 + " : "+contador;
			            int res8= b8-contador;
			            imp.retiro(res8, id8);
			            contador=0;
			            while(dr>=a9 && contador< b9)
			            {
			            
			            dr=dr-a9;
			            contador++;
			            
			            }
			            String print10 ="Monedas de :" + a9 + " : "+contador; 
			            int res9= b9-contador;
			            imp.retiro(res9, id9);
			            contador=0;
			            
			            while(dr>=a10 && contador< b10)
			            {
			            
			            dr=dr-a10;
			            contador++;
			            
			            }
			            String print11 ="Monedas de :" + a10 + " : "+contador; 
			            int res10= b10-contador;
			            imp.retiro(res10, id10);
			            
			            
			            return  print1+"\n"+ print2+"\n"+print3+"\n"+print4+"\n"+print5+"\n"+print6+"\n"+print7+"\n"+print8+"\n"+print9+"\n"+print10+"\n"+print11 ;
			           }
			           else {
			        	   
			        	  return "No hay suficiente Efectivo.\n saldo disponible: "+saldo; 
			           }
	    	
	    	
	    	
	    	
	    }
	    
	    @GetMapping("recargar")
	    public String recargar() {
	    	
	    	List<Efectivo> efe= srv.mostrarTodos();
	    	
	    	int id0= efe.get(0).getEfectivoId();
			int id1= efe.get(1).getEfectivoId();
			int id2= efe.get(2).getEfectivoId();
			int id3= efe.get(3).getEfectivoId();
			int id4= efe.get(4).getEfectivoId();
			int id5= efe.get(5).getEfectivoId();
			int id6= efe.get(6).getEfectivoId();
			int id7= efe.get(7).getEfectivoId();
			int id8= efe.get(8).getEfectivoId();
			int id9= efe.get(9).getEfectivoId();
			int id10= efe.get(10).getEfectivoId();
			
	    	imp.retiro(2, id0);
	    	imp.retiro(5, id1);
	    	imp.retiro(10, id2);
	    	imp.retiro(20, id3);
	    	imp.retiro(30, id4);
	    	imp.retiro(40, id5);
	    	imp.retiro(50, id6);
	    	imp.retiro(100, id7);
	    	imp.retiro(200, id8);
	    	imp.retiro(300, id9);
	    	imp.retiro(100, id10);
	    	
	    	return "Saldo Recargado";
	    }
	
}
