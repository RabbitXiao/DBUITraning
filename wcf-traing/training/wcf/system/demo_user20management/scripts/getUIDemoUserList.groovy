package system._demo_user20management.scripts;

def list = functionHelper.invokeFunction('system:demo_user20management.getAllDemoUsers');

def resultList = [];

list?.each {
    def uiDemoUser = functionHelper.createDataObject('demo_user20management:UIDemoUser', 'none', null)
    uiDemoUser.set('idNumber', it.IDNumber)
    uiDemoUser.set('userName', it.userName)
    uiDemoUser.set('sex', it.sex)
    uiDemoUser.set('age', it.age)
    uiDemoUser.set('phoneNumber', it.phoneNumber)
    uiDemoUser.set('email', it.email)
    uiDemoUser.set('department', it.department)
    resultList << uiDemoUser
}

return resultList;