package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.AsignacionArmamento;
import com.bst.app.commons.dao.ICommonDao;

public interface IAsignacionArmamentoDao extends ICommonDao<AsignacionArmamento, Object> {
	
	@Query("SELECT ar FROM AsignacionArmamento ar WHERE CONCAT(ar.codigo) LIKE %?1% AND ar.eliminado = 'N'")
	Page<AsignacionArmamento> searchList(String search, Pageable pageable);

	@Query("SELECT ar FROM AsignacionArmamento ar WHERE ar.eliminado = 'N'")
	List<AsignacionArmamento> findAllNotDeleted();

	@Query("SELECT ar FROM AsignacionArmamento ar WHERE ar.eliminado = 'N'")
	Page<AsignacionArmamento> findAllNotDeleted(Pageable pageable);

	@Query("SELECT ar FROM AsignacionArmamento ar WHERE ar.eliminado = 'S'")
	Page<AsignacionArmamento> findAllDeleted(Pageable pageable);

}
