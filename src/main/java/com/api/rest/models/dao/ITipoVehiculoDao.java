package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.TipoVehiculo;
import com.bst.app.commons.dao.ICommonDao;

public interface ITipoVehiculoDao extends ICommonDao<TipoVehiculo, Object>{


	@Query("SELECT tv FROM TipoVehiculo tv WHERE CONCAT(tv.tipo, tv.descripcion, tv.eliminado) LIKE %?1% AND tv.eliminado = 'N'")
	Page<TipoVehiculo> searchList(String search, Pageable pageable);

	@Query("SELECT tv FROM TipoVehiculo tv WHERE tv.eliminado = 'N'")
	List<TipoVehiculo> findAllNotDeleted();

	@Query("SELECT tv FROM TipoVehiculo tv WHERE tv.eliminado = 'N'")
	Page<TipoVehiculo> findAllNotDeleted(Pageable pageable);

	@Query("SELECT tv FROM TipoVehiculo tv WHERE tv.eliminado = 'S'")
	Page<TipoVehiculo> findAllDeleted(Pageable pageable);
	
}
