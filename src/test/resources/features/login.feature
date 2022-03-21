Feature: Login
  Yo como cliente
  Quiero ingresar en la platafrma parabank
  Para ver mis estados financieros

  Background:
    Given :El cliente entra en la pagina se registra y va a la seccion de Login

  @login
  Scenario: El cliente proporciona las credenciales para poder ver su balance
    When 	El cliente ingresa a su perfil con sus credenciales
    Then 	El cliente entra a ver sus balace

  @login
  Scenario: El cliente proporciona las credenciales para poder ver su balance pero no usa email
    When 	El cliente ingresa una contracena asignada, pero no su correo
    Then 	Sale un error indicandole el ingreso de sus credenciales


  @login
  Scenario: El cliente entra a la pagina y va directamente al login
    When    el cliente intenta ingresar con sus credenciales que no estan verificadas
    Then    sale un error indicandole que el correo o contracenia no han sido verifivadas