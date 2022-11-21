var app = {
    backend: 'http://localhost:8080/api/cliente',
    table : null,
    init: function(){
        app.initDatatable('#clientes');

        

        $('#save').click(function(){
            
            const nombres = document.getElementById("nombre").value;
            const apellidos = document.getElementById("apellido").value;
            const cedula = document.getElementById("cedula").value;
            const celular = document.getElementById("celular").value;
            const correo = document.getElementById("correo").value;
            const direccion = document.getElementById("direccion").value;
            const fechaEvento = document.getElementById("fechaEvento").value;


            if (nombres =='') {
                setTimeout(function(){
                    $("#validacionN").html("<span style='color:red'>Complete el campo</span>").fadeOut(4000);
                },1000);

                $('#nombre').focus();
                return false;
            }else if (apellidos =='') {
                setTimeout(function(){
                    $("#validacionA").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#apellido').focus();
                return false;
            }else if (correo =='') {
                setTimeout(function(){
                    $("#validacionE").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#correo').focus();
                return false;
            }else if (cedula =='') {
                setTimeout(function(){
                    $("#validacionCi").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#cedula').focus();
                return false;
            }else if (fechaEvento =='') {
                setTimeout(function(){
                    $("#validacionF").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#fechaEvento').focus();
                return false;
            }else if (celular =='') {
                setTimeout(function(){
                    $("#validacionO").html("<span style='color:red'>Edad</span>").fadeOut(2000);
                },1000);

                $('#celular').focus();
                return false;
            }else if (direccion =='') {
                setTimeout(function(){
                    $("#validacionT").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#direccion').focus();
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
                fechaEvento : $('#fechaEvento').val()
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
                {data : "fechaEvento"}
            ],
            buttons: [
                {
                    text : 'Crear',
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
        $('#nombre').val(data.nombre);
        $('#apellido').val(data.apellido);
        $('#cedula').val(data.cedula);
        $('#celular').val(data.celular);
        $('#correo').val(data.correo);
        $('#direccion').val(data.direccion);
        $('#fechaEvento').val(data.fechaEvento);
    },
    cleanForm: function(){
        $('#id').val('');
        $('#nombre').val('');
        $('#apellido').val('');
        $('#cedula').val('');
        $('#celular').val('');
        $('#correo').val('');
        $('#direccion').val('');
        $('#fechaEvento').val('');
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