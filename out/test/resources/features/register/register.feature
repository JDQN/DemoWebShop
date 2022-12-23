Feature: Registrar un usuario nuevo en el aplicativo web DemoShop

  Como nuevo usuario del aplicativo web DemoShop quiero registrar una para poder comprar productos

  Scenario: 06 - Registro correcto del cliente
    Given que el cliente entro a la pagina de registro
    When ingrese los datos del formulario correctamente
    Then recibira un mensaje Your registration completed


  Scenario: 07 -Registro incorrecto del cliente
    Given que el cliente entro a la pagina de registro
    When no ingrese los datos requeridos del formulario
    Then recibira un mensaje required de los campos que hacen falta por diligenciar
