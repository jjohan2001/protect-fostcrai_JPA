var app = {
    backend: 'http://localhost:8080/api/recreadores',
    table : null,
    init: function(){
        app.initDatatable('#recreadores');

        

        $('#save').click(function(){
            
            const edad = document.getElementById("edad").value;
            const fecha = document.getElementById("fecha").value;
            const capacitacion = document.getElementById("capacitacion").value;
            const usuario = document.getElementById("usuario").value;

            if (edad =='') {
                setTimeout(function(){
                    $("#validacionE").html("<span style='color:red'>Complete el campo</span>").fadeOut(4000);
                },1000);

                $('#edad').focus();
                return false;
            }else if (fecha =='') {
                setTimeout(function(){
                    $("#validacionF").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#fecha').focus();
                return false;
            }else if (capacitacion =='') {
                setTimeout(function(){
                    $("#validacionCA").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#capacitacion').focus();
                return false;
            }else if (usuario =='') {
                setTimeout(function(){
                    $("#validacionU").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#usuario').focus();
                return false;
            }
            app.save({
                id :$('#id').val(),
                edad : $('#edad').val(),
                fecha_nacimiento : $('#fecha').val(),
                id_capacitacion_fk : $('#capacitacion').val(),
                id_usuario_fk : $('#usuario').val(),
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
                {data : "edad"},
                {data : "fecha_nacimiento"},
                {data : "id_capacitacion_fk.id"},
                {data : "id_usuario_fk.nombre"}
            ],
            buttons: [
                {
                    text : 'Crear',
                    action : function(e, dt, node, config){
                        app.cleanForm();
                        $('#recreadorModal').modal();
                    }
                },
                {
                    text : 'Editar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        app.setDataToModal(data);
                        $('#recreadorModal').modal();
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

        $('#recreadores tbody').on('click', 'tr', function(){
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
        $('#edad').val(data.edad);
        $('#fecha').val(data.fecha_nacimiento);
        $('#capacitacion').val(data.id_capacitacion_fk);
        $('#usuario').val(data.usuario);
    },
    cleanForm: function(){
        $('#id').val('');
        $('#edad').val('');
        $('#fecha').val('');
        $('#capacitacion').val('');
        $('#contrato').val('');
        $('#usuario').val('');
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
                $('#recreadorModal').modal('hide');
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

$.getJSON(app.backend + "/listaCapacitacion", {}, function(data){
    $.each(data, function(i,item){
        $("#capacitacion").append("<option value="+item.id +">"+ item.id +"</option>");
    });
});

$.getJSON(app.backend + "/listarUsuarios", {}, function(data){
    $.each(data, function(i,item){
        $("#usuario").append("<option value="+item.id +">"+ item.nombre +"</option>");
    });
});


$(document).ready(function(){
    app.init();
});