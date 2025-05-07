
Feature: Iniciar sesion en el sistema OrangeHRM

  Como usuario registrado
  Quiero iniciar sesion en el sistema OrangeHRM
  Para poder acceder a sus funcionalidades

  @successful
  Scenario: Ingresar a la pagina y realizar inicio de sesion
    Given "alejandro" abre el sitio web de pruebas
    When ingresa con usuario "Admin" y contrasenia "admin123"
    Then visualizara el titulo de la pagina "OrangeHRM"
    When "alejandro" hace clic en el boton de aniadir
    And "alejandro" llena el formulario con nombre "Juan" y apellido "Perez" selecciona "Payroll Administrator" con correo "tester@example.com" con numero de contacto "123412341234" y sube el archivo "documento.txt"
    Then visualizará el título de la página "Formulario Guardado"
    When se hace clic en el boton shortlist
