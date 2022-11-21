var app = {
    backend: 'http://localhost:8080/api/cliente',
    table : null,
    init: function(){
        app.initDatatable('#clientes');

        

        $('#save').click(function(){

            const id = document.getElementById("id").value;
            const nombres = document.getElementById("nombres").value;
            const apellidos = document.getElementById("apellidos").value;
            const correo = document.getElementById("correo").value;
            const ciudad = document.getElementById("ciudad").value;
            const fecha = document.getElementById("fecha").value;
            const ocupacion = document.getElementById("ocupacion").value;
            const telefono = document.getElementById("telefono").value;


            if (nombres =='') {
                setTimeout(function(){
                    $("#validacionN").html("<span style='color:red'>Complete el campo</span>").fadeOut(4000);
                },1000);

                $('#nombres').focus();
                return false;
            }else if (apellidos =='') {
                setTimeout(function(){
                    $("#validacionA").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#apellidos').focus();
                return false;
            }else if (correo =='') {
                setTimeout(function(){
                    $("#validacionE").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#correo').focus();
                return false;
            }else if (ciudad =='') {
                setTimeout(function(){
                    $("#validacionCi").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#ciudad').focus();
                return false;
            }else if (fecha =='') {
                setTimeout(function(){
                    $("#validacionF").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#fecha').focus();
                return false;
            }else if(fecha < "1957-01-01" && fecha > "2004-12-31"){
                setTimeout(function(){
                    $("#validacionF").html("<span style='color:red'>Fecha fuera de rango</span>").fadeOut(2000);
                },1000);

                $('#fecha').focus();
                return false;
            }else if (ocupacion =='') {
                setTimeout(function(){
                    $("#validacionO").html("<span style='color:red'>Edad</span>").fadeOut(2000);
                },1000);

                $('#ocupacion').focus();
                return false;
            }else if (telefono =='') {
                setTimeout(function(){
                    $("#validacionT").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#telefono').focus();
                return false;
            }
            app.save({
                id :$('#id').val(),
                nombre : $('#nombre').val(),
                apellido: $('#apellido').val(),
                cedula : $('#cedula').val(),
                celular : $('#celular').val(),
                correo : $('#correo').val(),
                direccion : $('#direccion').val(),
                fecha : $('#fecha_del_evento').val()
            });
        });
    },
    initDatatable : function(id){
        app.table = $(id).DataTable({
            ajax : {
                url : app.backend + '/all',
                dataSrc : function(json){
                    return json;
                }
            },
            dom: 'Bfrtip',
            columns : [
                {data: "id"},
                {data : "nombre"},
                {data : "apellido"},
                {data : "cedula"},
                {data : "celular"},
                {data : "correo"},
                {data : "direccion"},
                {data : "fecha_del_evento"}
            ],
            buttons: [
                {
                    text : 'crear',
                    action : function(e, dt, node, config){
                        app.cleanForm();
                        $('#clienteModal').modal();
                    }
                },
                {
                    text : 'Editar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        app.setDataToModal(data);
                        $('#clienteModal').modal();
                    }
                },
                {
                    text : 'Eliminar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        Swal.fire({
                            title: 'Seguro que desea eliminar este registro?',
                            text: "No podra recuperar el registro",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: 'delete'
                          }).then((result) => {
                            if (result.isConfirmed) {
                              Swal.fire(
                                app.delete(data.id),
                                'Deleted!',
                                'Your file has been deleted.',
                                'success'
                              )
                            }
                        })
                    }
                }
            ]
        });

        $('#clientes tbody').on('click', 'tr', function(){
            if($(this).hasClass('table-active')){
               $(this).removeClass('table-active');
            }else{
                app.table.$('tr.table-active').removeClass('table-active');
                $(this).addClass('table-active');
            }
        });
    },
    setDataToModal : function(data){
        $('#id').val(data.id);
        $('#nombre').val(data.nombres);
        $('#apellido').val(data.apellidos);
        $('#cedula').val(data.cedula);
        $('#celular').val(data.celular);
        $('#correo').val(data.correo);
        $('#direccion').val(data.direccion);
        $('#fecha_del_evento').val(data.fecha);
    },
    cleanForm: function(){
        $('#id').val('');
        $('#cedula').val('');
        $('#nombres').val('');
        $('#apellidos').val('');
        $('#correo').val('');
        $('#ciudad').val('');
        $('#fecha').val('');
        $('#ocupacion').val('');
        $('#telefono').val('');
    },
    save : function(data) {
        $.ajax({
            url: app.backend + '/save',
            data : JSON.stringify(data),
            method: 'POST',
            dataType : 'json',
            contentType: "application/json; charset=utf-8",
            success : function(json) {
                setTimeout(function(){
                    $("#msg").text('Se guardó la persona correctamente').fadeOut(5000);
                },100);
                $("#msg").show();
                $('#clienteModal').modal('hide');
                app.table.ajax.reload();
            },
            error : function(error) {
                $("msg").text(error.error);
                $("msg").show();
            }
        })
    },
    delete : function(id) {
        $.ajax({
            url: app.backend + '/delete/'+id,
            method: 'GET',
            dataType : 'json',
            contentType: "application/json; charset=utf-8",
            success : function(json) {
                setTimeout(function(){
                    $("#msg").text('Se elimino correctamente').fadeOut(5000);
                },100);
                $("#msg").show();
                app.table.ajax.reload();
            },
            error : function(error) {
                $("msg").text(error.error);
                $("msg").show();
            }
        })
    }
};


$(document).ready(function(){
    app.init();
});