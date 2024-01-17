package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.TipoContrato;
import com.bst.app.commons.dao.ICommonDao;

public interface ITipoContratoDao extends ICommonDao<TipoContrato, Object> {

	@Query("SELECT tc FROM TipoContrato tc WHERE CONCAT(tc.nombre, tc.descripcion, tc.iva) LIKE %?1% AND tc.eliminado = 'N'")
	Page<TipoContrato> searchList(String search, Pageable pageable);

	@Query("SELECT tc FROM TipoContrato tc WHERE tc.eliminado = 'N'")
	List<TipoContrato> findAllNotDeleted();

	@Query("SELECT tc FROM TipoContrato tc WHERE tc.eliminado = 'N'")
	Page<TipoContrato> findAllNotDeleted(Pageable pageable);

	@Query("SELECT tc FROM TipoContrato tc WHERE tc.eliminado = 'S'")
	Page<TipoContrato> findAllDeleted(Pageable pageable);
}
