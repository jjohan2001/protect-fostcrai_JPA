var app = {
    backend: 'http://localhost:8080/api/actividades',
    table : null,
    init: function(){
        app.initDatatable('#actividades');

        

        $('#save').click(function(){
            
            const actividad = document.getElementById("actividad").value;
            const horas = document.getElementById("horas").value;
            const solicitud = document.getElementById("solicitud").value;

            if (actividad =='') {
                setTimeout(function(){
                    $("#validacionA").html("<span style='color:red'>Complete el campo</span>").fadeOut(4000);
                },1000);

                $('#actividad').focus();
                return false;
            }else if (horas =='') {
                setTimeout(function(){
                    $("#validacionH").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#horas').focus();
                return false;
            }else if (solicitud =='') {
                setTimeout(function(){
                    $("#validacionS").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#solicitud').focus();
                return false;
            }
            app.save({
                id :$('#id').val(),
                actividades : $('#actividad').val(),
                horas: $('#horas').val(),
                solicitud_id : $('#solicitud').val(),
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
                {data : "actividades"},
                {data : "horas"},
                {data : "solicitud_id.id"}
            ],
            buttons: [
                {
                    text : 'Crear',
                    action : function(e, dt, node, config){
                        app.cleanForm();
                        $('#actividadModal').modal();
                    }
                },
                {
                    text : 'Editar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        app.setDataToModal(data);
                        $('#actividadModal').modal();
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

        $('#actividades tbody').on('click', 'tr', function(){
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
        $('#actividad').val(data.actividades);
        $('#horas').val(data.horas);
        $('#solicitud').val(data.solicitud_id);
    },
    cleanForm: function(){
        $('#id').val('');
        $('#actividad').val('');
        $('#horas').val('');
        $('#solicitud').val('');
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
                $('#actividadModal').modal('hide');
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

$.getJSON(app.backend + "/listaSolicitudes", {}, function(data){
    $.each(data, function(i,item){
        $("#solicitud").append("<option value="+item.id +">"+ item.id +"</option>");
    });
});


$(document).ready(function(){
    app.init();
});