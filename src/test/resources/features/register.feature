Feature: Registro
  Yo como cliente
  Quiero registrarme en parabank
  Para poder adquirir algùn servicio financiero
  Background:
    Given : Que el cliente entra en la plataforma, seccion registro

  @Reg.
  Scenario: El cliente da sus credenciales para poder registrarlo en plataforma
    When ingresa se le solicitan los datos personales
    Then recibe un mensaje de bienvenda junto con su nombre

  @Reg.
  Scenario: El cliente da sus credenciales para poder registrarlo en plataforma pero son incompletos
    When Se le solicitan los datos personales pero no ingresa el apellido, y direccion
    Then recibe un mensaje para poner el apelido