package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.PersonalPolicial;
import com.bst.app.commons.dao.ICommonDao;

public interface IPersonalPolicialDao extends ICommonDao<PersonalPolicial, Object> {

	@Query("SELECT pp FROM PersonalPolicial pp WHERE CONCAT(pp.identificacion, pp.nombreCompleto, pp.tipoSangre.nombre, pp.ciudadNacimiento.nombre, pp.telefonoCelular, pp.rango.nombreRango) LIKE %?1% AND pp.eliminado = 'N'")
	Page<PersonalPolicial> searchList(String search, Pageable pageable);

	@Query("SELECT pp FROM PersonalPolicial pp WHERE pp.eliminado = 'N'")
	List<PersonalPolicial> findAllNotDeleted();

	@Query("SELECT pp FROM PersonalPolicial pp WHERE pp.eliminado = 'N'")
	Page<PersonalPolicial> findAllNotDeleted(Pageable pageable);

	@Query("SELECT pp FROM PersonalPolicial pp WHERE pp.eliminado = 'S'")
	Page<PersonalPolicial> findAllDeleted(Pageable pageable);
}
