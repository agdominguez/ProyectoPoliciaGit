package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.RangoPolicial;
import com.bst.app.commons.dao.ICommonDao;

public interface IRangoPolicialDao extends ICommonDao<RangoPolicial, Object> {
	
	@Query("SELECT rp FROM RangoPolicial rp WHERE CONCAT(rp.tipoRango, rp.nombreRango) LIKE %?1% AND rp.eliminado = 'N'")
	Page<RangoPolicial> searchList(String search, Pageable pageable);

	@Query("SELECT rp FROM RangoPolicial rp WHERE rp.eliminado = 'N'")
	List<RangoPolicial> findAllNotDeleted();

	@Query("SELECT rp FROM RangoPolicial rp WHERE rp.eliminado = 'N'")
	Page<RangoPolicial> findAllNotDeleted(Pageable pageable);

	@Query("SELECT rp FROM RangoPolicial rp WHERE rp.eliminado = 'S'")
	Page<RangoPolicial> findAllDeleted(Pageable pageable);

}
