Feature: Iniciar sesión y agregar candidato en OrangeHRM

  Como usuario de Recursos Humanos
  Quiero iniciar sesión y agregar nuevos candidatos
  Para gestionar el proceso de reclutamiento


  @successful
  Scenario: Ingresar a la pagina y realizar inicio de sesion
    Given "reclutador" abre el sitio web de pruebas
    When ingresa con usuario "Admin" y contrasenia "admin123"
    Then visualizara el titulo de la pagina "OrangeHRM"
    When "reclutador" hace clic en el boton de aniadir
    And "reclutador" llena el formulario con nombre "Juan" y apellido "Perez" selecciona "Payroll Administrator" con correo "tester@example.com" con numero de contacto "123412341234" y sube el archivo "documento.txt"
    Then debe visualizar el título de la página "Formulario Guardado"
    And el candidato "Juan Perez" debe aparecer en la lista


