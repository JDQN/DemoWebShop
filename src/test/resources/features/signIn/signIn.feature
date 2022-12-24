Feature: Registrar un usuario nuevo en el aplicativo web DemoShop

  Como nuevo usuario del aplicativo web DemoShop quiero registrar una para poder comprar productos

  Background:
    Given que el cliente entro a la pagina de registro


  Scenario: 05 - Registro correcto del cliente
    When ingrese los datos del formulario correctamente
    And recibira un mensaje Your registration completed
    Then da click en el boton continuar


  Scenario: 06 - Registro incorrecto del cliente
    When no ingresa los datos requeridos del formulario
    Then recibira un mensaje required de los campos que hacen falta por diligenciar
