var app = {
    backend: 'http://localhost:8080/api/solicitudes',
    table : null,
    init: function(){
        app.initDatatable('#solicitudes');

        
 
        $('#save').click(function(){
            
            const servicio = document.getElementById("servicio").value;
            const fecha = document.getElementById("fecha").value;
            const cliente = document.getElementById("clente").value;

            if (servicio =='') {
                setTimeout(function(){
                    $("#validacionS").html("<span style='color:red'>Complete el campo</span>").fadeOut(4000);
                },1000);

                $('#servicio').focus();
                return false;
            }else if (fecha =='') {
                setTimeout(function(){
                    $("#validacionF").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#fecha').afocus();
                return false;
            }else if (cliente =='') {
                setTimeout(function(){
                    $("#validacionC").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#cliente').focus();
                return false;
            }
            app.save({
                id :$('#id').val(),
                servicio : $('#servicio').val(),
                fecha : $('#fecha').val(),
                contrato : $('#cliente').val(),
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
                {data : "fecha_servicio"},
                {data : "id_cliente_fk.cedula"},
                {data : "id_servicio_fk.nombre_servicio"}
            ],
            buttons: [
                {
                    text : 'Crear',
                    action : function(e, dt, node, config){
                        app.cleanForm();
                        $('#solicitudModal').modal();
                    }
                },
                {
                    text : 'Editar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        app.setDataToModal(data);
                        $('#solicitudModal').modal();
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

        $('#solicitudes tbody').on('click', 'tr', function(){
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
        $('#fecha').val(data.fecha_servicio);
        $('#cli').val(data.id_cliente_fk);
        $('#servicio').val();
    },
    cleanForm: function(){
        $('#id').val('');
        $('#servicio').val('');
        $('#fecha').val('');
        $('#cliente').val('');
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
                $('#solicitudModal').modal('hide');
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
$.getJSON("/listaServicio", {}, function(data){
    $.each(data, function(i,item){
      $("#id_servicio").append("<option value="+item.id+">"+ item.id + "</option>");
    });
  });



$(document).ready(function(){
    app.init();
});