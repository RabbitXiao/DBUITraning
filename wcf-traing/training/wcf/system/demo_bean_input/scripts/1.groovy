package system._demo_bean_input.scripts;

def topologyCars = #!Car#.getTopologyObjects()

def mTopologyService = server["TopologyService"];

def createUICar = {
	def uiCar = functionHelper.createDataObject("demo:Car",  'none', it.uniqueId)
	uiCar.store('name', it.name, null)
	uiCar.store('number', it.number,  null)
	uiCar.store('id', it.uniqueId, null)
	uiCar.store('topologyObject', it, null)
	return uiCar
}
return topologyCars?.collect { tCar ->
	createUICar(tCar)
}