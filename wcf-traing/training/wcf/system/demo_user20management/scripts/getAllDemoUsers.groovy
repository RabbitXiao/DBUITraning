package system._demo_user20management.scripts;

def topologyService = server.TopologyService

def topologyType = topologyService.getType("DemoUser");

return topologyService.getObjectsOfType(topologyType)