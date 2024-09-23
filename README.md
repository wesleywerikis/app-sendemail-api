# AppSendemailApiApplication

Este projeto é uma API para envio de e-mails utilizando Spring Boot, JavaMailSender, e Thymeleaf para templates de
e-mail HTML.

## Funcionalidades

- Enviar e-mails com HTML personalizado.
- Utilizar templates Thymeleaf para personalização do corpo do e-mail.
- Configuração simples de remetente, destinatário, assunto e conteúdo do e-mail.

## Requisitos

- Java 17+
- Spring Boot 2.7+
- Maven
- Dependências:
    - `spring-boot-starter-web`
    - `spring-boot-starter-mail`
    - `spring-boot-starter-thymeleaf`

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/AppSendemailApiApplication.git
   cd AppSendemailApiApplication
   ```

2. Configure as propriedades do envio de e-mail no arquivo application.properties:

   ```bash
   spring.mail.host=smtp.gmail.com
   spring.mail.port=587
   spring.mail.username=seu-email@gmail.com
   spring.mail.password=sua-senha-de-aplicativo
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true

   ```
   
3. Compile o projeto com Maven:

   ```bash
   mvn clean install
   ```
   
4. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

## Endpoints

### Enviar E-mail

- **POST** `/api/emails/send`

#### Parâmetros (JSON):
```json
{
  "to": "destinatario@exemplo.com",
  "subject": "Assunto do E-mail",
  "name": "Nome do Remetente",
  "message": "Conteúdo da mensagem"
}
```

## Estrutura do Projeto

- `AppSendemailApiApplication.java`: Ponto de entrada da aplicação.
- `EmailController.java`: Controlador REST responsável por receber as requisições de envio de e-mails.
- `EmailService.java`: Serviço responsável por montar e enviar o e-mail utilizando o `JavaMailSender` e Thymeleaf.
- `EmailDto.java`: Objeto de transferência de dados para os parâmetros do e-mail.
