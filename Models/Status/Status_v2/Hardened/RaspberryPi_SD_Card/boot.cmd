echo "--- EXECUTING BOOT SCRIPT ---"
fatls mmc 0
fatload mmc 0 0x10000000 loader.img
go 0x10000000
