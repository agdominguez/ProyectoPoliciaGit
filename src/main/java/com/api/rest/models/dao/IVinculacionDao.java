package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.Vinculacion;
import com.bst.app.commons.dao.ICommonDao;

public interface IVinculacionDao extends ICommonDao<Vinculacion, Object> {

	@Query("SELECT v FROM Vinculacion v WHERE CONCAT(v.codigo, v.vinculacionPersonal.personalPolicial.identificacion, "
			+ "v.vinculacionPersonal.personalPolicial.nombreCompleto, v.eliminado) LIKE %?1% AND v.eliminado = 'N'")
	Page<Vinculacion> searchList(String search, Pageable pageable);

	@Query("SELECT v FROM Vinculacion v WHERE v.eliminado = 'N'")
	List<Vinculacion> findAllNotDeleted();

	@Query("SELECT v FROM Vinculacion v WHERE v.eliminado = 'N'")
	Page<Vinculacion> findAllNotDeleted(Pageable pageable);

	@Query("SELECT v FROM Vinculacion v WHERE v.eliminado = 'S'")
	Page<Vinculacion> findAllDeleted(Pageable pageable);

}
