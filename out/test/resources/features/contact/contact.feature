Feature: Store customer service Demo Web Shop

  Scenario: 01 Como usuario deseo contactarme con servicio al cliente
    Given que el cliente ingrese a la pagina Demo Web Shop en el campo Conatc Us
    When diligencia el formulario correctamente
    Then recibira un mensaje Your enquiry has been successfully sent to the store owner


  Scenario: 02 - Como usuario deseo contactarme con servicio al cliente
    Given que el cliente ingreso a la pagina Demo Web Shop en el campo Conatc Us
    When diligencia el formulario correctamente Contact Us
    And no ingresa un correo electronico
    Then recibira un mensaje Enter email


#  Scenario: 03 - Como usuario deseo contactarme con servicio al cliente
#    Given que el cliente ingreso a la pagina Demo Web Shop en el campo Conatc Us
#    When diligencia el formulario correctamente Contact Us
#    And no ingresa un correo electronico correcto
#    Then recibira un mensaje Wrong email