document.addEventListener("DOMContentLoaded", function() {
    // Selección de botones "Actualizar" por clase
    const actualizarButtons = document.querySelectorAll(".actualizar-button");

    // Agregar un manejador de eventos a cada botón "Actualizar"
    actualizarButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            // Obtener el ID del cliente desde el atributo data-client-id
            const clientId = button.getAttribute("data-client-id");

            // Realizar alguna acción con el ID del cliente, por ejemplo, redirigir a una página de actualización
            window.location.href = "/actualizar/" + clientId;
        });
    });

    // Selección de botones "Eliminar" por clase
    const eliminarButtons = document.querySelectorAll(".eliminar-button");

    // Agregar un manejador de eventos a cada botón "Eliminar"
    eliminarButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            // Obtener el ID del cliente desde el atributo data-client-id
            const clientId = button.getAttribute("data-client-id");

            // Realizar alguna acción con el ID del cliente, por ejemplo, confirmar la eliminación
            if (confirm("¿Estás seguro de que deseas eliminar este cliente?")) {
                // Redirigir a la página de eliminación
                window.location.href = "/borrar/" + clientId;
            }
        });
    });
});
