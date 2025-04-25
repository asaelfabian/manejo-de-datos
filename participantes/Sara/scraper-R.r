# Cargar la librería necesaria
library(rvest)

# URL del sitio
url <- "https://www.bbc.com/mundo"

# Leer el contenido HTML de la página web
pagina <- read_html(url)

# Extraer los bloques de noticias (etiquetas <h3>)
titulos <- pagina %>%
  html_nodes("h3") %>%
  html_text(trim = TRUE)

# Extraer los enlaces asociados a los titulares (dentro de etiquetas <a>)
enlaces <- pagina %>%
  html_nodes("a") %>%
  html_attr("href") %>%
  unique() %>% # evita duplicados
  .[grepl("/mundo", .)]
# filtramos los enlaces que parecen ser noticias de la sección "mundo"

# Si los enlaces son relativos, los convertimos en enlaces absolutos
enlaces_completos <- paste0("https://www.bbc.com", enlaces)

# Mostrar los primeros 10 títulos con sus enlaces asociados (si existieran)
cat("Titulares y enlaces (ejemplo):\n")
for (i in 1:min(10, length(titulos), length(enlaces_completos))) {
  cat(sprintf("[%d] %s\n     %s\n\n", i, titulos[i], enlaces_completos[i]))
}
