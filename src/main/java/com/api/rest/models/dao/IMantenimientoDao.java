package com.api.rest.models.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.api.rest.models.entity.Mantenimiento;
import com.bst.app.commons.dao.ICommonDao;

public interface IMantenimientoDao extends ICommonDao<Mantenimiento, Object> {

	@Query("SELECT m FROM Mantenimiento m WHERE CONCAT(m.codigo) LIKE %?1% AND m.eliminado = 'N'")
	Page<Mantenimiento> searchList(String search, Pageable pageable);

	@Query("SELECT m FROM Mantenimiento m WHERE m.eliminado = 'N'")
	List<Mantenimiento> findAllNotDeleted();

	@Query("SELECT m FROM Mantenimiento m WHERE m.eliminado = 'N'")
	Page<Mantenimiento> findAllNotDeleted(Pageable pageable);

	@Query("SELECT m FROM Mantenimiento m WHERE m.eliminado = 'S'")
	Page<Mantenimiento> findAllDeleted(Pageable pageable);
	
	@Procedure(name = "p_inserta_mantenimiento")
	public Map<String, Object> p_inserta_mantenimiento(
			@Param("p_codigo_solicitud") Long p_codigo_solicitud,
			@Param("p_asunto") String p_asunto,
			@Param("p_detalle") String p_detalle,
			@Param("p_kilometraje_actual") BigDecimal p_kilometraje_actual);

}
