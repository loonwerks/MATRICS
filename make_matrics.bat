@echo off
setlocal EnableExtensions EnableDelayedExpansion

set eclipseRelease=2023-12
set OSATE_VERSION=2.14.0
set OSATE_URL=https://osate-build.sei.cmu.edu/download/osate/stable/%OSATE_VERSION%/products/osate2-%OSATE_VERSION%-vfinal-win32.win32.x86_64.zip
set OSATE_DIR=osate2-%OSATE_VERSION%-MATRICS
set AGREE_UPDATE_SITE=https://raw.githubusercontent.com/loonwerks/AGREE-Updates/master/
set AGREE_FEATURE_ID=com.rockwellcollins.atc.agree.feature.feature.group
set RESOLUTE_UPDATE_SITE=https://raw.githubusercontent.com/loonwerks/Resolute-Updates/master/
set RESOLUTE_FEATURE_ID=com.rockwellcollins.atc.resolute.feature.feature.group

if exist %OSATE_DIR%\ echo Deleting previous OSATE version
rd /s /q %OSATE_DIR%
mkdir %OSATE_DIR%
pushd %OSATE_DIR%
echo Downloading OSATE
curl %OSATE_URL% --output osate2-%OSATE_VERSION%-vfinal-win32.win32.x86_64.zip
if not exist %cd%\osate2-%OSATE_VERSION%-vfinal-win32.win32.x86_64.zip (
	echo Unable to download OSATE
	exit /b
)
echo Extracting
Call :UnZipFile "%cd%" "%cd%\osate2-%OSATE_VERSION%-vfinal-win32.win32.x86_64.zip"
del /f /q osate2-%OSATE_VERSION%-vfinal-win32.win32.x86_64.zip

echo Installing CASE tools (this could take several minutes)
osate.exe -nosplash -console -consoleLog -application org.eclipse.equinox.p2.director -repository %AGREE_UPDATE_SITE% -installIU %AGREE_FEATURE_ID%
osate.exe -nosplash -console -consoleLog -application org.eclipse.equinox.p2.director -repository %RESOLUTE_UPDATE_SITE% -installIU %RESOLUTE_FEATURE_ID%

popd

echo Setup complete

exit /b


:UnZipFile <ExtractTo> <newzipfile>
set vbs="%temp%\_.vbs"
if exist %vbs% del /f /q %vbs%
>%vbs%  echo Set fso = CreateObject("Scripting.FileSystemObject")
>>%vbs% echo If NOT fso.FolderExists(%1) Then
>>%vbs% echo fso.CreateFolder(%1)
>>%vbs% echo End If
>>%vbs% echo set objShell = CreateObject("Shell.Application")
>>%vbs% echo set FilesInZip=objShell.NameSpace(%2).items
>>%vbs% echo objShell.NameSpace(%1).CopyHere(FilesInZip)
>>%vbs% echo Set fso = Nothing
>>%vbs% echo Set objShell = Nothing
cscript //nologo %vbs%
if exist %vbs% del /f /q %vbs%