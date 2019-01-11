package system._demo_user20management.scripts;

def demoUsers = functionHelper.invokeFunction('system:demo_user20management.getAllDemoUsers');

return demoUsers.find{it.IDNumber == idNumber};