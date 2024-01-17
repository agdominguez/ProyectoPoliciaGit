package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.TipoReclamo;
import com.bst.app.commons.dao.ICommonDao;

public interface ITipoReclamoDao extends ICommonDao<TipoReclamo, Object> {

	@Query("SELECT tr FROM TipoReclamo tr WHERE CONCAT(tr.nombre, tr.descripcion) LIKE %?1% AND tr.eliminado = 'N'")
	Page<TipoReclamo> searchList(String search, Pageable pageable);

	@Query("SELECT tr FROM TipoReclamo tr WHERE tr.eliminado = 'N'")
	List<TipoReclamo> findAllNotDeleted();

	@Query("SELECT tr FROM TipoReclamo tr WHERE tr.eliminado = 'N'")
	Page<TipoReclamo> findAllNotDeleted(Pageable pageable);

	@Query("SELECT tr FROM TipoReclamo tr WHERE tr.eliminado = 'S'")
	Page<TipoReclamo> findAllDeleted(Pageable pageable);
}
