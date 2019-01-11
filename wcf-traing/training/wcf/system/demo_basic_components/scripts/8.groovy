package system._demo_basic_components.scripts;

def topologyService = server.TopologyService

allCars = functionHelper.invokeFunction("system:demo_basic_components.1");

delCars.each{ car ->
	if (car.getName() in allCars*.getName()) {
		def id = allCars.find{it.getName() == car.getName()}.getUniqueId()
		def tcar = topologyService.getObject(id);
		topologyService.deleteObject(tcar)
	}
}
[]