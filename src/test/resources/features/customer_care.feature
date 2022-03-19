Feature: Contact Us
  Yo como prospecto de usuario del banco ParaBank
  Quiero poder contactarme con ellos para poder pedir mayor información
  Para que me contacten y así solicitar un servicio

  Background:
    Given El cliente se encuentra en la seccion contact us de parabank

  @Contact
  Scenario: El cliente proporciona los datos para poder ser contactado
    When El cliente ingresa su nombre,email numero detelefono y mensaje
    Then El cliente recibe un mensaje de confirmacion

  @Contact
  Scenario: El cliente proporciona los datos para poder ser contactatado, pero no lo hace completo
      When  El cliente ingresa su nombre, numero de telefono y mensaje
      Then  El cliente recibe un mensaje que es obligatorio poner el correo
