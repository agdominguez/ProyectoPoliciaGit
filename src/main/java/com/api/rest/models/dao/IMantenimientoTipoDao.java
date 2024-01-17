package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.MantenimientoTipo;
import com.bst.app.commons.dao.ICommonDao;

public interface IMantenimientoTipoDao extends ICommonDao<MantenimientoTipo, Object> {

	@Query("SELECT mt FROM MantenimientoTipo mt WHERE CONCAT(mt.codigo) LIKE %?1% AND mt.eliminado = 'N'")
	Page<MantenimientoTipo> searchList(String search, Pageable pageable);

	@Query("SELECT mt FROM MantenimientoTipo mt WHERE mt.eliminado = 'N'")
	List<MantenimientoTipo> findAllNotDeleted();

	@Query("SELECT mt FROM MantenimientoTipo mt WHERE mt.eliminado = 'N'")
	Page<MantenimientoTipo> findAllNotDeleted(Pageable pageable);

	@Query("SELECT mt FROM MantenimientoTipo mt WHERE mt.eliminado = 'S'")
	Page<MantenimientoTipo> findAllDeleted(Pageable pageable);
}
