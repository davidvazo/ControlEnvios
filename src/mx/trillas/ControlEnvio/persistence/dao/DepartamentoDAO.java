package mx.trillas.ControlEnvio.persistence.dao;

import java.util.List;

import mx.trillas.ControlEnvio.persistence.pojos.Departamento;
import mx.trillas.ControlEnvio.persistence.pojos.Mensajeria;

public interface DepartamentoDAO {

	public void altaDepartamento(Departamento departamento) throws Exception;
	public Departamento getDepartamento(String nombre) throws Exception;
	public List<Departamento> getDepartamentoList() throws Exception;
	public Departamento getDepartamentoById(int id) throws Exception;
	public void altaDepartamentoByList(List<Departamento> departamentos) throws Exception;
	public void updateDepartamento(Departamento departamento) throws Exception;
}
