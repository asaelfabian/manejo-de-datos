# pip install requests
# pip install beautifulsoup4


import requests #Solicitudes HTTP

from bs4 import BeautifulSoup # Analizar el contenido HTML

# Obtener y procesar una página web
def scrape():
    # URL del sitio web que queremos extraer
    url = 'https://www.example.com'
    
    # Solicitud GET a la URL
    response = requests.get(url)
    
    # Analizamos el contenido HTML de la respuesta usando BeautifulSoup
    soup = BeautifulSoup(response.text, 'html.parser')
    return soup

# Obtener el contenido de la página web
soup = scrape()

print(soup)

# Texto del primer encabezado <h1>, si existe. Si no, mostramos un mensaje por defecto.
title = soup.select_one('h1').text if soup.select_one('h1') else 'No h1 found'

# Texto del primer párrafo <p>, si existe. Si no, mostramos un mensaje por defecto.
text = soup.select_one('p').text if soup.select_one('p') else 'No p found'

# Primer enlace <a>, si existe. Si no, mostramos un mensaje por defecto.
link = soup.select_one('a').get('href') if soup.select_one('a') else 'No a found'

# Imprimimos los resultados obtenidos
print(title)
print(text)
print(link)
