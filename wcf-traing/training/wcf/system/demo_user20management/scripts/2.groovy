package system._demo_user20management.scripts;


def resultList = [];


def uiDemoUser = functionHelper.createDataObject('demo_user20management:UIDemoUser', 'none', null)
uiDemoUser.set('userName','Evan Huang')
uiDemoUser.set('idNumber','0000001')

resultList << uiDemoUser


def uiDemoUser1 = functionHelper.createDataObject('demo_user20management:UIDemoUser', 'none', null)
uiDemoUser1.set('userName','Evan Huang1')
uiDemoUser1.set('idNumber','00000011')

resultList << uiDemoUser1
return resultList