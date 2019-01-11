package system._demo_user20management_switch20to20layout.scripts;

def views = association?.get('values', specificTimeRange);
if (views?.size() >0) {
    def view = views[0]
    return functionHelper.invokeFunction("system:wcf_common.17", view.get("qualifiedId", specificTimeRange))
}
return null;