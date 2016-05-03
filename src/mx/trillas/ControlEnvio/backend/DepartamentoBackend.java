package mx.trillas.ControlEnvio.backend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import mx.trillas.ControlEnvio.persistence.dao.DepartamentoDAO;
import mx.trillas.ControlEnvio.persistence.impl.DepartamentoDAODBImpl;
import mx.trillas.ControlEnvio.persistence.pojos.Departamento;

public class DepartamentoBackend {

	 private static final String STRING_PATTERN = "([a-zA-ZpáéíóúÁÉÍÓÚ\\s]){3,45}";

	 private static Logger logger = Logger.getLogger(Departamento.class);

	 private static DepartamentoDAO departamentoDAO = new DepartamentoDAODBImpl();

	 public static boolean checkString(String phrase){

		  Pattern pattern;
		  Matcher matcher;

		  pattern = Pattern.compile(STRING_PATTERN);
		  matcher = pattern.matcher(phrase);

		  return matcher.matches();
	 }

	 public static void loadDepartamentoData(String nombreDepartamento) throws Exception {
		 Departamento departamento = null;
		 departamento  = new Departamento();

		 departamento.setNombre(nombreDepartamento);

		 try {
			 departamentoDAO.altaDepartamento(departamento);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	 }
}
