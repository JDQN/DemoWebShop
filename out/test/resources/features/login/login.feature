Feature: Ingresar al aplicativo web DemoShop

  Como usuario del aplicativo DemoShop quiero ingresar a mi cuenta para realizar compras

  Background:
    Given que el cliente entro al aplicativo DemoShop


  Scenario: 03 -Ingreso correcto del Login
    When ingrese los datos Email y Password correctamente
    Then entrara a la cuenta.


  Scenario: 04 -Ingreso incorrecto del Login
    When no ingrese los datos Email y Password correctamente
    Then recibira un mensaje Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect