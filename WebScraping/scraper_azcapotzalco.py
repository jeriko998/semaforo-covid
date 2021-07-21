from urllib.request import urlopen
html = urlopen("https://datos.covid-19.conacyt.mx/fHDMap/mun.php")
print(html.read())