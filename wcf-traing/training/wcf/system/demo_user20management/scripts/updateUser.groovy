package system._demo_user20management.scripts;
import com.quest.wcf.data.messages.*; 

def demoUser = functionHelper.invokeFunction('system:demo_user20management.getDemoUserById', uiDemoUser.idNumber) 

if (demoUser) {
    def topologyService = server.TopologyService
    def user = topologyService.getObject(demoUser.getUniqueId())
    def updateObject = topologyService.beginUpdate(user);
    updateObject .set("userName", uiDemoUser.userName)
    updateObject .set("sex", uiDemoUser.sex)
    updateObject .set("age", uiDemoUser.age)
    updateObject .set("phoneNumber", uiDemoUser.phoneNumber)
    updateObject .set("email", uiDemoUser.email)
    updateObject .set("department", uiDemoUser.department)
    topologyService.endUpdate(updateObject )
} else {
    return [new ErrorMessage("The user " +uiDemoUser.userName+" is not exist!")]
}

return null;