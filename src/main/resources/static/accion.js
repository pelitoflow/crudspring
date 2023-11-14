document.addEventListener("DOMContentLoaded", function () {
    // Selección de botón "Agregar Usuario" por ID
    const abrirModalBtn = document.getElementById('abrirModalBtn');
    const cerrarModal = document.getElementById('cerrarModal');
    const miModal = document.getElementById('miModal');

    // Abrir el modal al hacer clic en el botón "Agregar Usuario"
    abrirModalBtn.addEventListener('click', function () {
        // Limpiar el formulario al abrir el modal
        document.getElementById('formularioUsuario').reset();

        miModal.style.display = 'block';
    });

    // Cerrar el modal al hacer clic en el botón de cerrar
    cerrarModal.addEventListener('click', function () {
        miModal.style.display = 'none';
    });

    // Selección de botones "Actualizar" por clase
    const actualizarButtons = document.querySelectorAll(".actualizar-button");

    // Agregar un manejador de eventos a cada botón "Actualizar"
    actualizarButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            // Obtener el ID del cliente desde el atributo data-client-id
            const clientId = button.getAttribute("data-client-id");

            // Realizar alguna acción con el ID del cliente, por ejemplo, redirigir a una página de actualización
            window.location.href = "/actualizar/" + clientId;
        });
    });

    // Selección de botones "Eliminar" por clase
    const eliminarButtons = document.querySelectorAll(".eliminar-button");

    // Agregar un manejador de eventos a cada botón "Eliminar"
    eliminarButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            // Obtener el ID del cliente desde el atributo data-client-id
            const clientId = button.getAttribute("data-client-id");

            // Realizar alguna acción con el ID del cliente, por ejemplo, confirmar la eliminación
            if (confirm("¿Estás seguro de que deseas eliminar este cliente?")) {
                // Redirigir a la página de eliminación
                window.location.href = "/borrar/" + clientId;
            }
        });
    });

    // Agregar un manejador de eventos al formulario dentro del modal
    document.getElementById('formularioUsuario').addEventListener('submit', function (event) {
        event.preventDefault();

        const modalId = document.getElementById('modalId').value;
        const modalNombre = document.getElementById('modalNombre').value;
        const modalApellidos = document.getElementById('modalApellidos').value;
        const modalEmail = document.getElementById('modalEmail').value;
        const modalCiudad = document.getElementById('modalCiudad').value;
        const modalTelefono = document.getElementById('modalTelefono').value;

        // Construir el objeto con los datos del formulario
        const usuarioData = {
            id: modalId,
            nombres: modalNombre,
            apellidos: modalApellidos,
            email: modalEmail,
            ciudad: modalCiudad,
            telefono: modalTelefono
            // Agrega otros campos según sea necesario
        };

        // Realizar la solicitud POST utilizando Fetch API
        fetch('/elpirata/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuarioData)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Respuesta del servidor:', data);
            
             // Actualizar la página
            window.location.reload();
        })
        .catch(error => console.error('Error al realizar la solicitud:', error));

        // Cerrar el modal después de realizar acciones
        miModal.style.display = 'none';
    });
});
