package system._demo_basic_components.scripts;
import com.quest.wcf.data.messages.*;

/**
* @param action - String, "add" or "edit"
* @param name - String
* @param brand - String
* @param price - Double
* @return List<StatusMessage>
*/
def topologyService = server.TopologyService

def findCarByName = { allCars, name ->
	return allCars?.find {
		it?.getName() == name
	}
}
def addCar = { name, brand, price ->
	def topologyType = topologyService.createType("Car")
	def shell = topologyService.getObjectShell(topologyType)
	shell.set("name", name)
    shell.set("brand", brand)
    shell.set("price", price)
	topologyService.mergeData(shell)
}

def updateCar = { car, brand, price ->
	def tmpCar = topologyService.getObject(car.getUniqueId())
	def updateObj = topologyService.beginUpdate(tmpCar)
	updateObj.set("brand", brand)
	updateObj.set("price", price)
	topologyService.endUpdate(updateObj)
}

def statusMsgs = []
def allCars = functionHelper.invokeFunction("system:demo_basic_components.getAllCars")
def existingCar = findCarByName(allCars, name)

if (action == 'add') {
	if(existingCar != null) {
		statusMsgs << new ErrorMessage("Add failed - Car ${name} already exists.") 
		return statusMsgs
	}
	addCar(name, brand, price)
} else if (action == 'edit')  {
	if (existingCar == null) {
		statusMsgs << new ErrorMessage("Edit failed - Can not find Car ${name}.") 
		return statusMsgs
	}
	updateCar(existingCar, brand, price)
}
return statusMsgs