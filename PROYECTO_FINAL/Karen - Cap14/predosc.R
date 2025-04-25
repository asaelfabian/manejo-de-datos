#Instalar librwrias
install.packages("lubridate")
install.packages("stringr")
install.packages("plyr")
install.packages("ggplot2")

# Librerías necesarias
library(lubridate)   # Fechas
library(stringr)     # Texto
library(plyr)        # Manejo de listas a data.frame
library(ggplot2)     # Gráficas

# Cargar dataset de tweets desde archivo CSV
oscars <- read.csv("oscars_tweets_big.csv")

# Ver los datos
#View(oscars)  # Visualiza el dataset cargado
head(oscars)  # muestra las primeras filas del dataset

# Crear variable de tiempo y redondearla por hora
oscars$time <- as.POSIXct(oscars$created_at, tz = "UTC")
oscars$round_hour <- round_date(oscars$time, unit = "hour")

# Contar tweets por hora
plot_time <- as.data.frame(table(oscars$round_hour))

# Graficar evolución de tweets por hora
plot(plot_time[,2],
     type = "l",
     xaxt = "n",
     xlab = "Hora",
     ylab = "Cantidad de tweets",
     col = "deeppink",  
     lwd = 4)              # grosor de línea

axis(1,
     at = c(1, 2, 3, 4, 5, 6),
     labels = plot_time[c(1, 2, 3, 4, 5, 6), 1])


# Convertir textos a minúsculas
oscars$lotext <- tolower(oscars$text)

# Definir palabras a buscar
actor <- c("leonardo dicaprio", "matthew mcconaughey")
actress <- c("cate blanchett")
film <- c("gravity", "12 years a slave")

# Buscar menciones exactas
dat_actor <- ldply(lapply(oscars$lotext, str_detect, actor))
dat_actress <- ldply(lapply(oscars$lotext, str_detect, actress))
dat_film <- ldply(lapply(oscars$lotext, str_detect, film))

colnames(dat_actor) <- c("dicaprio", "mcconaughey")
colnames(dat_actress) <- c("blanchett")
colnames(dat_film) <- c("gravity", "twelve_years_slave")

# Total de menciones exactas
apply(dat_actor, 2, sum)
apply(dat_actress, 2, sum)
apply(dat_film, 2, sum)

# Buscar errores de escritura (búsqueda aproximada)
length_actor <- unlist(lapply(lapply(actor, agrep, oscars$lotext), length))
length_actress <- unlist(lapply(lapply(actress, agrep, oscars$lotext), length))
length_film <- unlist(lapply(lapply(film, agrep, oscars$lotext), length))

names(length_actor) <- c("dicaprio", "mcconaughey")
names(length_actress) <- c("blanchett")
names(length_film) <- c("gravity", "twelve_years_slave")

# Total de menciones aproximadas
length_actor
length_actress
length_film
