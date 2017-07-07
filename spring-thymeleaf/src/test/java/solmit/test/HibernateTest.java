package solmit.test;

import java.util.Objects;

import org.hibernate.Session;

import com.solmit.util.HibernateUtil;
 

public class HibernateTest {

 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();

		if (Objects.nonNull(session)) {
			System.out.println("Conexion Exitosa");
		} else {
			System.out.println("Conexion Fallida");
		}
 

	 	
		
		
		
	}

	
 
}
