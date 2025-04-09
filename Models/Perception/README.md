AGREE is a OSATE/Eclipse plugin.   If you are already familiar with how to install eclipse plugin, then you can just download the following the packages and install the AGREE plugin into the OSATE environment and skip the install instruction.  

•	OSATE 2.14  https://osate-build.sei.cmu.edu/download/osate/stable/2.14.0-vfinal/products/osate2-2.14.0-vfinal-win32.win32.x86_64.zip
•	AGREE: https://github.com/loonwerks/AGREE/releases/download/2.11.2-RELEASE/com.rockwellcollins.atc.agree.repository-2.11.2.zip

Install: 
1.	Unzip OSATE package. 
2.	Go to the unzipped folder and run osate.exe. 
3.	From the menu bar: Help->Install New Software->Add->Local-><AGREE.zip package>
4.	Check any EULA boxes that need to be filled.  

Import and viewing model: 
1.	From the menu bar: File->Import->General->Existing Projects into Workspace->Select root directory: Browse-><Location of the Folder Perception>
2.	Now the a project named Perception should show up in the “Projects:” field.  Select the project and then click finish.  
3.	To view diagram of model look at the AADL Navigator pane (typically on the left): Open Perception+->diagrams+->Checkpoint_mon2.aadl
4.	To view AADL/AGREE src code: Perception+->*.aadl

Analysis and results: 
1.	Open Perception+->Checkpoint.aadl (this is the top level system component)
2.	From the menu bar: Analysis->AGREE->Verify Monolithically. 
3.	View counterexample: in the AGREE results tab (typically on the bottom along other tabs such as Console/Problems/Properties..), expand any invalid results, find an invalid guarantee, right click on it for a pop up context menu: View Counterexample in->Console,Eclipse,Spreadsheet
