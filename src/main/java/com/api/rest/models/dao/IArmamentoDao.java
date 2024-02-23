package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.Armamento;
import com.bst.app.commons.dao.ICommonDao;

public interface IArmamentoDao extends ICommonDao<Armamento, Object> {
	
	@Query("SELECT a FROM Armamento a WHERE CONCAT(a.codigo) LIKE %?1% AND a.eliminado = 'N'")
	Page<Armamento> searchList(String search, Pageable pageable);

	@Query("SELECT a FROM Armamento a WHERE a.eliminado = 'N'")
	List<Armamento> findAllNotDeleted();

	@Query("SELECT a FROM Armamento a WHERE a.eliminado = 'N'")
	Page<Armamento> findAllNotDeleted(Pageable pageable);

	@Query("SELECT a FROM Armamento a WHERE a.eliminado = 'S'")
	Page<Armamento> findAllDeleted(Pageable pageable);

}
