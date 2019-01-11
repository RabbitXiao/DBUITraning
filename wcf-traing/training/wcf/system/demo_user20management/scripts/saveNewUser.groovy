package system._demo_user20management.scripts;
import com.quest.wcf.data.messages.*; 
if (uiDemoUser) {
    if (functionHelper.invokeFunction('system:demo_user20management.getDemoUserById', uiDemoUser.idNumber)) {
        return [new ErrorMessage("The idNumber is exsit!")]
    }

    def topologyService = server.TopologyService
    def topologyType = topologyService.createType("DemoUser")
    def shell = topologyService.getObjectShell(topologyType)
    shell.set("IDNumber", uiDemoUser.idNumber)
    shell.set("userName", uiDemoUser.userName)
    shell.set("name", uiDemoUser.userName)
    shell.set("sex", uiDemoUser.sex)
    shell.set("age", uiDemoUser.age)
    shell.set("phoneNumber", uiDemoUser.phoneNumber)
    shell.set("email", uiDemoUser.email)
    shell.set("department", uiDemoUser.department)
    topologyService.mergeData(shell)
} else {
    return [new ErrorMessage("Please enter the user info.")]
}
return null