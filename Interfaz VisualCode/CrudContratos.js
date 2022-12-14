var app = {
    backend: 'http://localhost:8080/api/contrato',
    table : null,
    init: function(){
        app.initDatatable('#contrato');

        

        $('#save').click(function(){
            
            const dias = document.getElementById("dias").value;
            const fecha = document.getElementById("fecha").value;
            const horas = document.getElementById("horas").value;

            if (dias =='') {
                setTimeout(function(){
                    $("#validacionD").html("<span style='color:red'>Complete el campo</span>").fadeOut(4000);
                },1000);

                $('#dias').focus();
                return false;
            }else if (horas =='') {
                setTimeout(function(){
                    $("#validacionH").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#horas').focus();
                return false;
            }else if (fecha =='') {
                setTimeout(function(){
                    $("#validacionF").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#fecha').focus();
                return false;
            }
            app.save({
                id :$('#id').val(),
                dias : $('#dias').val(),
                fecha : $('#feha').val(),
                horas : $('#horas').val(),
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
                {data : "dias"},
                {data : "fecha_entrada"},
                {data : "horas"},
                {data : "id_recreador_fk.id"}
            ],
            buttons: [
                {
                    text : 'Crear',
                    action : function(e, dt, node, config){
                        app.cleanForm();
                        $('#contratoModal').modal();
                    }
                },
                {
                    text : 'Editar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        app.setDataToModal(data);
                        $('#contratoModal').modal();
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

        $('#contrato tbody').on('click', 'tr', function(){
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
        $('#dias').val(data.dias);
        $('#fecha').val(data.fecha_entrada);
        $('#horas').val(data.horas);
        $('#recreador').val(data.id_recreador_fk.id);
    },
    cleanForm: function(){
        $('#id').val('');
        $('#dias').val('');
        $('#fecha_entrada').val('');
        $('#horas').val('');
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
                $('#contratoModal').modal('hide');
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