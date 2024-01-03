package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.JerarquiaDependencia;
import com.bst.app.commons.dao.ICommonDao;

public interface IJerarquiaDependenciaDao extends ICommonDao<JerarquiaDependencia, Object> {

	@Query("SELECT jd FROM JerarquiaDependencia jd WHERE CONCAT(jd.nombre, jd.siglas) LIKE %?1% AND jd.eliminado = 'N'")
	Page<JerarquiaDependencia> searchList(String search, Pageable pageable);

	@Query("SELECT jd FROM JerarquiaDependencia jd WHERE jd.eliminado = 'N'")
	List<JerarquiaDependencia> findAllNotDeleted();

	@Query("SELECT jd FROM JerarquiaDependencia jd WHERE jd.eliminado = 'N'")
	Page<JerarquiaDependencia> findAllNotDeleted(Pageable pageable);

	@Query("SELECT jd FROM JerarquiaDependencia jd WHERE jd.eliminado = 'S'")
	Page<JerarquiaDependencia> findAllDeleted(Pageable pageable);
}
