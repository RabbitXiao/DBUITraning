package system._demo_bean_input_training.scripts;
def topologyCars = #!Car#.getTopologyObjects()

def createCar = { tCar ->
	def car = functionHelper.createDataObject("demo_bean_input_training:Car", 'none', tCar.getUniqueId())
	car.store("name", tCar.name, null)
	car.store("number", tCar.number, null)
	car.store("id", tCar.uniqueId, null)
	return car
}

topologyCars?.collect { tCar ->
	createCar(tCar)
}	