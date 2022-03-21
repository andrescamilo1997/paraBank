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


