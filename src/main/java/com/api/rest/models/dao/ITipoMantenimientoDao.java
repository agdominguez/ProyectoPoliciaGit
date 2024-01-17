package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.TipoMantenimiento;
import com.bst.app.commons.dao.ICommonDao;

public interface ITipoMantenimientoDao extends ICommonDao<TipoMantenimiento, Object> {

	@Query("SELECT tm FROM TipoMantenimiento tm WHERE CONCAT(tm.nombre, tm.descripcion) LIKE %?1% AND tm.eliminado = 'N'")
	Page<TipoMantenimiento> searchList(String search, Pageable pageable);

	@Query("SELECT tm FROM TipoMantenimiento tm WHERE tm.eliminado = 'N'")
	List<TipoMantenimiento> findAllNotDeleted();

	@Query("SELECT tm FROM TipoMantenimiento tm WHERE tm.eliminado = 'N'")
	Page<TipoMantenimiento> findAllNotDeleted(Pageable pageable);

	@Query("SELECT tm FROM TipoMantenimiento tm WHERE tm.eliminado = 'S'")
	Page<TipoMantenimiento> findAllDeleted(Pageable pageable);
}
