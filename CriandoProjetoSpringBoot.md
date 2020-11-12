# Criando Projeto com SpringBoot (passo a passo)

## Precisamos seguir um padrão para criar um projeto Java com SpringBoot no VS Code

* Pressionar **Ctrl + Shift + P**
* Selecionar: __>Spring Initializr: Create a Maven Project...__
* Selecionar a versão do Spring Boot mais atual
* Selecionar a linguagem:
    * Java
    * Kotlin
    * Groovy
* Seguir com o padrão de nome do projeto __com.example__
* Definir o nome de seu projeto, todo em letra minúsculas 
    aula01-spring-boot
* Especificar o modo de empacotamento do projeto:
    * JAR -> quando estamos trabalhando com o Spring Boot com um servidor já embutido ou quando nossa aplicação roda apenas no Java.
    * WAR -> quando precisamos criar um projeto completo e depois passar para um servidor externo ao nosso projeto Spring Boot
* Especificar a versão do Java que iremos utilizar no projeto
    * No momento estamos utilizando a mais recente (14)
* Selecionar as dependências do projeto:
    * Spring Boot DevTools
    * Spring Web
* Selecionar a pasta onde será criado o projeto Maven
    * Selecionar Open no VS Code
    * Esperar carregar todo o projeto



## Adicionando uma nova dependência ao projeto

### Primeira forma
    
    * ctrl + shift + p
    * ´Maven: Add a dependency...´
    * Informar o nome da dependência que está buscando, exemplo: ´spring-boot-starter-validation´

### Segunda forma
A segunda forma de inserir uma dependência ao projeto é alterando o pom.xml
    
    * Encontrar o arquivo ´pom.xml´
    * Adicionar na divisão de dependências o seguinte código/informação

        <dependency> 
			<groupId>org.springframework.boot</groupId> 
			<artifactId>spring-boot-starter-validation</artifactId> 
	    </dependency>

        
