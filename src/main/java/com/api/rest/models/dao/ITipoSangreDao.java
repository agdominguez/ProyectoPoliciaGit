package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.TipoSangre;
import com.bst.app.commons.dao.ICommonDao;

public interface ITipoSangreDao extends ICommonDao<TipoSangre, Object> {

	@Query("SELECT ts FROM TipoSangre ts WHERE CONCAT(ts.nombre, ts.descripcion) LIKE %?1% AND ts.eliminado = 'N'")
	Page<TipoSangre> searchList(String search, Pageable pageable);

	@Query("SELECT ts FROM TipoSangre ts WHERE ts.eliminado = 'N'")
	List<TipoSangre> findAllNotDeleted();

	@Query("SELECT ts FROM TipoSangre ts WHERE ts.eliminado = 'N'")
	Page<TipoSangre> findAllNotDeleted(Pageable pageable);

	@Query("SELECT ts FROM TipoSangre ts WHERE ts.eliminado = 'S'")
	Page<TipoSangre> findAllDeleted(Pageable pageable);
}
