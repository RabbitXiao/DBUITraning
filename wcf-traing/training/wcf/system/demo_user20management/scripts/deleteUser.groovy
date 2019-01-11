package system._demo_user20management.scripts;
import com.quest.wcf.data.messages.*; 

def topologyService = server.TopologyService

def demoUser = functionHelper.invokeFunction('system:demo_user20management.getDemoUserById', selDemoUser.idNumber)

if (demoUser) {
    topologyService.deleteObject(demoUser)
} else {
    return [new ErrorMessage("The user " +selDemoUser.userName+" is not exist!")]
}

return null;