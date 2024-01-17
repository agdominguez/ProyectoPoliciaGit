package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.Solicitud;
import com.bst.app.commons.dao.ICommonDao;

public interface ISolicitudDao extends ICommonDao<Solicitud, Object> {

	@Query("SELECT s FROM Solicitud s WHERE CONCAT(s.codigo, s.vinculacion.vinculacionPersonal.personalPolicial.identificacion, "
			+ "s.vinculacion.vinculacionPersonal.personalPolicial.nombreCompleto) LIKE %?1% AND s.eliminado = 'N'")
	Page<Solicitud> searchList(String search, Pageable pageable);

	@Query("SELECT s FROM Solicitud s WHERE s.eliminado = 'N'")
	List<Solicitud> findAllNotDeleted();

	@Query("SELECT s FROM Solicitud s WHERE s.eliminado = 'N'")
	Page<Solicitud> findAllNotDeleted(Pageable pageable);

	@Query("SELECT s FROM Solicitud s WHERE s.eliminado = 'S'")
	Page<Solicitud> findAllDeleted(Pageable pageable);
}
