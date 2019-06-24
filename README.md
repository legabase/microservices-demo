# microservices-demo-app
[![Build Status](https://travis-ci.com/necmettincetincift/microservices-demo-app.svg?branch=development)](https://travis-ci.com/necmettincetincift/microservices-demo-app)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tr.com.innova.lega.microservices-demo&metric=alert_status)](https://sonarcloud.io/dashboard?id=tr.com.innova.lega.microservices-demo)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tr.com.innova.lega.microservices-demo&metric=coverage)](https://sonarcloud.io/dashboard?id=tr.com.innova.lega.microservices-demo)
[![codebeat badge](https://codebeat.co/badges/da79769e-c403-4ce2-b826-721ea0be8847)](https://codebeat.co/projects/github-com-necmettincetincift-microservices-demo-app-development)

Genişleme için client, service ve app olarak ayrıldı

Sunucu çalıştırıldıktan sonra **http://localhost:8081** adresinden erişilebilir.
Sunucu port'u değiştirmek için **application.properties** dosyasındaki **server.port** değiştirilmelidir.

App modulü sadece Client modülü içerisindeki sınıflara erişim sağlayabilir.
Service moddülü 