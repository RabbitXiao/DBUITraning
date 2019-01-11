package system._demo_bean_input.scripts;
import com.quest.wcf.data.messages.*; 

def allCars = #!Car#.getTopologyObjects()
c = allCars.find {it.getName() == car.name }
if (c) {
	if( c.getUniqueId() == car.id && c.getDouble('number') == car.number)
		return [new WarningMessage("No Change!")]
	else if(c.getUniqueId() != car.id)
		return [new ErrorMessage("This Car Name is existing, please input another name.")]
}


def topologyService = server.TopologyService
def topologyType = topologyService.getType("Car")
def editCar = topologyService.getObject(car.id);
def updateObj = topologyService.beginUpdate(editCar);
updateObj.set("number", car.number)
updateObj.set("name", car.name)
topologyService.endUpdate(updateObj)


