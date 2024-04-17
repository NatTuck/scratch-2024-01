import openpyxl as xl
from openpyxl.utils import column_index_from_string as l2i

wb = xl.load_workbook("output.xlsx")
sh = wb.active

for row in range(1, 55):
    print(sh[f"A{row}"].value, sh[f"B{row}"].value)
