package com.api.rest.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.api.rest.models.entity.OrdenTrabajo;
import com.bst.app.commons.dao.ICommonDao;

public interface IOrdenTrabajoDao extends ICommonDao<OrdenTrabajo, Object> {

	@Query("SELECT ot FROM OrdenTrabajo ot WHERE CONCAT(ot.codigo) LIKE %?1% AND ot.eliminado = 'N'")
	Page<OrdenTrabajo> searchList(String search, Pageable pageable);

	@Query("SELECT ot FROM OrdenTrabajo ot WHERE ot.eliminado = 'N'")
	List<OrdenTrabajo> findAllNotDeleted();

	@Query("SELECT ot FROM OrdenTrabajo ot WHERE ot.eliminado = 'N'")
	Page<OrdenTrabajo> findAllNotDeleted(Pageable pageable);

	@Query("SELECT ot FROM OrdenTrabajo ot WHERE ot.eliminado = 'S'")
	Page<OrdenTrabajo> findAllDeleted(Pageable pageable);

	@Procedure(name = "p_actualiza_estado_orden")
	public Map<String, Object> p_actualiza_estado_orden(
			@Param("p_codigo_orden") Long p_codigo_orden,
			@Param("p_estado") Character p_estado);

}
