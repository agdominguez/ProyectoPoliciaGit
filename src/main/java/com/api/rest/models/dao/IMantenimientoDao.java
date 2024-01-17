package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

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
}
