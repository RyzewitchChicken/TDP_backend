package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.onticket.entity.Devices;

import pe.upc.onticket.repositorio.RepositorioDevice;


@Service
public class ServicioDevices {
	
	@Autowired RepositorioDevice repositorioDevices;
	
	
	/*registrar Devices*/
	@Transactional(rollbackFor= Exception.class)
	public Devices registrarDevices(Devices devices) throws Exception {
		if(devices.getCodigo()==null) {
			return repositorioDevices.save(devices);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Devices actualizarDevices(Devices devices, Long codigo) throws Exception {
		Devices dev=repositorioDevices.getDevice(codigo);
		if(devices.getNombre()!=null) {
			dev.setNombre(devices.getNombre());
		}
		if(devices.getNumero_serie()!=null) {
			dev.setNumero_serie(devices.getNumero_serie());
		}
		return repositorioDevices.save(dev);
		
	}
	
	//Obtener Datos
	public List<Devices> obtenerDatosDevices() {
		List<Devices> devices;
		devices=repositorioDevices.findAll();
		return devices;
	}
	
	
	public Devices obtenerDevices(Long codigo) throws Exception {
		Devices d;
		d=repositorioDevices.getDevice(codigo);
		if(d==null)throw new Exception("pedido no encontrado");
		return d;
	}
	
	
	//ELIMINAR UN DEVICE
	public Devices eliminarDevices(Long codigo) throws Exception {
		Devices d;
		d=repositorioDevices.getDevice(codigo);
		if(d.getCodigo()!=null) {
			repositorioDevices.delete(d);
		}else {
			throw new Exception();
		}
		return d;
	}

}
