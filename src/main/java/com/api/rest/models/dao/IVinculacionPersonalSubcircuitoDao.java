package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.VinculacionPersonalSubcircuito;
import com.bst.app.commons.dao.ICommonDao;

public interface IVinculacionPersonalSubcircuitoDao extends ICommonDao<VinculacionPersonalSubcircuito, Object> {
	
	@Query("SELECT vps FROM VinculacionPersonalSubcircuito vps WHERE CONCAT(vps.codigo, vps.eliminado) LIKE %?1% AND vps.eliminado = 'N'")
	Page<VinculacionPersonalSubcircuito> searchList(String search, Pageable pageable);

	@Query("SELECT vps FROM VinculacionPersonalSubcircuito vps WHERE vps.eliminado = 'N'")
	List<VinculacionPersonalSubcircuito> findAllNotDeleted();

	@Query("SELECT vps FROM VinculacionPersonalSubcircuito vps WHERE vps.eliminado = 'N'")
	Page<VinculacionPersonalSubcircuito> findAllNotDeleted(Pageable pageable);

	@Query("SELECT vps FROM VinculacionPersonalSubcircuito vps WHERE vps.eliminado = 'S'")
	Page<VinculacionPersonalSubcircuito> findAllDeleted(Pageable pageable);

}
