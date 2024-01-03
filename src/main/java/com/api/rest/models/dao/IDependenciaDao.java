package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.Dependencia;
import com.bst.app.commons.dao.ICommonDao;

public interface IDependenciaDao extends ICommonDao<Dependencia, Object> {

	@Query("SELECT d FROM Dependencia d WHERE CONCAT(d.nombre, d.siglas) LIKE %?1% AND d.eliminado = 'N'")
	Page<Dependencia> searchList(String search, Pageable pageable);

	@Query("SELECT d FROM Dependencia d WHERE d.eliminado = 'N'")
	List<Dependencia> findAllNotDeleted();

	@Query("SELECT d FROM Dependencia d WHERE d.eliminado = 'N'")
	Page<Dependencia> findAllNotDeleted(Pageable pageable);

	@Query("SELECT d FROM Dependencia d WHERE d.eliminado = 'S'")
	Page<Dependencia> findAllDeleted(Pageable pageable);
}
