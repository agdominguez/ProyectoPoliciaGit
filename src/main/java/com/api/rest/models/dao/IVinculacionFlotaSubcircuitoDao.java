package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.VinculacionFlotaSubcircuito;
import com.bst.app.commons.dao.ICommonDao;

public interface IVinculacionFlotaSubcircuitoDao extends ICommonDao<VinculacionFlotaSubcircuito, Object> {
	
	@Query("SELECT vfs FROM VinculacionFlotaSubcircuito vfs WHERE CONCAT(vfs.codigo, vfs.eliminado) LIKE %?1% AND vfs.eliminado = 'N'")
	Page<VinculacionFlotaSubcircuito> searchList(String search, Pageable pageable);

	@Query("SELECT vfs FROM VinculacionFlotaSubcircuito vfs WHERE vfs.eliminado = 'N'")
	List<VinculacionFlotaSubcircuito> findAllNotDeleted();

	@Query("SELECT vfs FROM VinculacionFlotaSubcircuito vfs WHERE vfs.eliminado = 'N'")
	Page<VinculacionFlotaSubcircuito> findAllNotDeleted(Pageable pageable);

	@Query("SELECT vfs FROM VinculacionFlotaSubcircuito vfs WHERE vfs.eliminado = 'S'")
	Page<VinculacionFlotaSubcircuito> findAllDeleted(Pageable pageable);

}
