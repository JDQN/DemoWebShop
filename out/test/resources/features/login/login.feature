Feature: Ingresar al aplicativo web DemoShop

  como usuario del aplicativo DemoShop quiero ingresar a mi cuenta para realizar compras

  Scenario: 04 -Ingreso correcto del Login
    Given que el cliente entro al aplicativo DemoShop
    When ingrese los datos Email y Password correctamente
    Then entrara a la cuenta.


  Scenario: 05 -Ingreso incorrecto del Login
    Given que el cliente entro al aplicativo DemoShop
    When no ingrese los datos Email y Password correctamente
    Then recibira un mensaje "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect"