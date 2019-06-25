# Microservices Demo
[![Build Status](https://travis-ci.com/legabase/microservices-demo.svg?branch=development)](https://travis-ci.com/legabase/microservices-demo)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tr.com.innova.lega:microservices-demo&metric=alert_status)](https://sonarcloud.io/dashboard?id=tr.com.innova.lega:microservices-demo)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tr.com.innova.lega:microservices-demo&metric=coverage)](https://sonarcloud.io/component_measures?id=tr.com.innova.lega%3Amicroservices-demo&metric=coverage&view=list)
[![codebeat badge](https://codebeat.co/badges/c2c7e62d-42ee-42cc-a0e9-220e101dfa62)](https://codebeat.co/projects/github-com-legabase-microservices-demo-development)

Genişleme için client, service ve app olarak ayrıldı

Sunucu çalıştırıldıktan sonra **http://localhost:8081** adresinden erişilebilir.
Sunucu port'u değiştirmek için **application.properties** dosyasındaki **server.port** değiştirilmelidir.

App modulü sadece Client modülü içerisindeki sınıflara erişim sağlayabilir.
Service moddülü 
