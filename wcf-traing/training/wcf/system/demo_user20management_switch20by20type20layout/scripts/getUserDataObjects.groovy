package system._demo_user20management_switch20by20type20layout.scripts;

def normalUser = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:NormalUser','none',null);
normalUser.set('userName', 'John Smith')

def normalUserInfo = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:UserInfo','none',null);
normalUserInfo.set('name', 'Normal User');
normalUserInfo.set('object', normalUser);

def advancedUser = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:AdvancedUser','none',null);
advancedUser.set('userName', 'Jimy Blue')
advancedUser.set('position', 'Team Leader')

def advancedUserInfo = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:UserInfo','none',null);
advancedUserInfo.set('name', 'Advanced User');
advancedUserInfo.set('object', advancedUser);

def superUser = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:SuperUser','none',null);
superUser.set('userName', 'Mily Wu')
superUser.set('position', 'Product Manager')
superUser.set('responsibility', 'Manage Foglight')

def superUserInfo = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:UserInfo','none',null);
superUserInfo.set('name', 'Super User');
superUserInfo.set('object', superUser);


def otherUser = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:OtherUser','none',null);
otherUser.set('userName', 'Lily Mock')
otherUser.set('description', "Other User View to display it own properties.")
def otherUserInfo = functionHelper.createDataObject('demo_user20management_switch20by20type20layout:UserInfo','none',null);
otherUserInfo.set('name', 'Other User');
otherUserInfo.set('object', otherUser);

def list = [normalUserInfo, advancedUserInfo, superUserInfo, otherUserInfo]

return list
