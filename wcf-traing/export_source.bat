@echo off
call :SET_ENVIROMENT
call :CLEAN_WORKING_FOLDER
call :EXPORT_MODULES
call :EXIT
GOTO:EOF

:SET_ENVIROMENT
echo ===========================
set FOGLIGHT_SERVER_IP=10.154.10.8
set FOGLIGHT_BIN_PATH=C:\Dell\Foglight5_7_3\bin
set CARTRIDGE_NAME="TrainingCartridge"

set CUR_DIR=%cd%
set BASE_DIR=%cd%
set WORK_DIR=%BASE_DIR%\training

echo FOGLIGHT_SERVER_IP: "%FOGLIGHT_SERVER_IP%"
echo FOGLIGHT_BIN_PATH: "%FOGLIGHT_BIN_PATH%"
echo WORK_DIR: "%WORK_DIR%"
GOTO:EOF

:CLEAN_WORKING_FOLDER
	echo Delete folder: "%WORK_DIR%"	
	rmdir /s /q "%WORK_DIR%"
	echo Create folder: "%WORK_DIR%"
	mkdir "%WORK_DIR%"
GOTO:EOF

:EXPORT_MODULES
	echo Export modules in %CARTRIDGE_NAME% cartridge.
	call :EXPORT_MODULE demo
	call :EXPORT_MODULE demo_basic_components
	call :EXPORT_MODULE demo_basic_components_training
	call :EXPORT_MODULE demo_bean_input
	call :EXPORT_MODULE demo_bean_input_training
	call :EXPORT_MODULE demo_user20management
	call :EXPORT_MODULE demo_user20management_interator20layout
	call :EXPORT_MODULE demo_user20management_switch20by20type20layout
	call :EXPORT_MODULE demo_user20management_switch20layout
	call :EXPORT_MODULE demo_user20management_switch20to20layout
	call :EXPORT_MODULE demo_user20management_tab20layout
	call :EXPORT_MODULE demo_user20management_type20layout
GOTO:EOF

:EXPORT_MODULE
	set wcf_module_name=system:%1
	set file_name=%1
	set zip_file_path=%WORK_DIR%\%file_name%.zip
	echo Export module: "%wcf_module_name%"
	set EXPORT_CARTRIDGE_COMMAND=%FOGLIGHT_BIN_PATH%\fglcmd.bat -srv %FOGLIGHT_SERVER_IP% -port 8080 -cmd util:uiexport -m %wcf_module_name% -f "%zip_file_path%"
	call %EXPORT_CARTRIDGE_COMMAND%

	set source_folder=%WORK_DIR%\wcf 
	echo source folder is: %source_folder%
	echo Unzip file %zip_file_path% to source folder:%source_folder%
	unzip.exe -o -q %zip_file_path% -d %source_folder%
GOTO:EOF

:EXIT
	echo Complete exporting WCF codes from FMS:%FOGLIGHT_SERVER_IP% for cartridge:%CARTRIDGE_NAME%.
GOTO:EOF

