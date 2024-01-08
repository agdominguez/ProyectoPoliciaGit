package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.FlotaVehicular;
import com.bst.app.commons.dao.ICommonDao;

public interface IFlotaVehicularDao extends ICommonDao<FlotaVehicular, Object> {
	
	@Query("SELECT fv FROM FlotaVehicular fv WHERE CONCAT(fv.tipoVehiculo.tipo, fv.placa, fv.chasis, fv.marca, fv.modelo, fv.motor, fv.kilometraje) LIKE %?1% AND fv.eliminado = 'N'")
	Page<FlotaVehicular> searchList(String search, Pageable pageable);

	@Query("SELECT fv FROM FlotaVehicular fv WHERE fv.eliminado = 'N'")
	List<FlotaVehicular> findAllNotDeleted();

	@Query("SELECT fv FROM FlotaVehicular fv WHERE fv.eliminado = 'N'")
	Page<FlotaVehicular> findAllNotDeleted(Pageable pageable);

	@Query("SELECT fv FROM FlotaVehicular fv WHERE fv.eliminado = 'S'")
	Page<FlotaVehicular> findAllDeleted(Pageable pageable);
	

}
