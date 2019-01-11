package system._demo_basic_components.scripts;

def topologyService = server.TopologyService

if (action == 'add') {
	def topologyType = topologyService.createType("Car")
	def shell = topologyService.getObjectShell(topologyType)
	shell.set("name", name)
        shell.set("number", number)
	topologyService.mergeData(shell)
} else if (action == 'edit')  {
	allCars = functionHelper.invokeFunction("system:demo_basic_components.getAllCars");
	def id = allCars.find{it.getName() == oldName}?.getUniqueId()
	def car = topologyService.getObject(id);
	def updateObj = topologyService.beginUpdate(car);
	updateObj.set("name", name)
	updateObj.set("number", number)
	topologyService.endUpdate(updateObj)
}
[]