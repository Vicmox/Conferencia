// Función para cargar y mostrar datos desde la API
function cargarConferenciasDesdeAPI() {
    var apiUrl = "http://localhost:8080/conferencias";

    $.ajax({
        url: apiUrl,
        type: "GET",
        dataType: "json",
        success: function (conferencias) {
            // Limpiar el contenido existente en la tabla
            $("#conferenciasBody").empty();

            // Iterar sobre la lista de conferencias y agregar filas a la tabla
            conferencias.forEach(function (conferencia) {
                var row = "<tr>";
                row += "<td>" + conferencia.id + "</td>";
                row += "<td>" + conferencia.nombre + "</td>";
                row += "<td>" + conferencia.fecha + "</td>";
                row += "<td>" + conferencia.fechaInicio + "</td>";
                row += "<td>" + conferencia.fechaCierre + "</td>";
                row += "<td>" + conferencia.plazoEnvioTrabajos + "</td>";
                row += "<button class='btn btn-danger btn-sm' onclick='eliminarConferencia(" + conferencia.id + ")'> Eliminar </button>";
                row += "<button class='btn btn-warning btn-sm' onclick='editarConferencia(" + conferencia.id + ")'> Editar </button>";
                row += "</td>";
                row += "</tr>";

                $("#conferenciasBody").append(row);
            });
        },
        error: function (error) {
            console.error("Error al cargar los datos desde la API:", error);
        }
    });
}

// Llamar a la función al cargar la página
$(document).ready(function () {
    cargarConferenciasDesdeAPI();
});


// Función para guardar una nueva conferencia o editar una existente
function guardarConferencia() {
    // Obtener los datos del formulario
    var formData = $("#conferenciaForm").serialize();

    // Enviar la solicitud al backend (puedes usar AJAX o fetch)
    $.ajax({
        url: "URL_DE_TU_BACKEND", // Reemplaza con la URL de tu backend
        type: "POST", // Puedes ajustar el método según tus necesidades (POST, PUT, etc.)
        data: formData,
        success: function (response) {
            console.log("Conferencia guardada exitosamente:", response);

            // Limpiar el formulario después de guardar
            $("#conferenciaForm")[0].reset();
        },
        error: function (error) {
            console.error("Error al guardar la conferencia:", error);
        }
    });
}


